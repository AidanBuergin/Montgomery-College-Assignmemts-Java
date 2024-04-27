// bake_funcs.c: required service functions for handling of Bakefiles
#include "bake.h"
#include <unistd.h>
////////////////////////////////////////////////////////////////////////////////
// PROBLEM 1
////////////////////////////////////////////////////////////////////////////////

char *slurp_file_efficient(char *fname){
// PROBLEM 1: Uses combination of stat() and read() to efficiently
// read in the entire contents of a file into a malloc()'d block of
// memory, null terminates it (\0). Returns a pointer to the file data
// or NULL if the file could not be opened.

	struct stat st;
	int suc = stat(fname, &st);		//call stat on file
	int size = st.st_size;			//store size
	if(suc == -1){					//err case stat()
		printf("Couldn't open file: No such file or directory\n");
		return NULL;
	}
	
	int fd = open(fname, O_RDONLY);	//open file
	if(fd == -1){					//err case open()
		printf("Couldn't open file: No such file or directory\n");
		return NULL;
	}
	
	char *p = malloc(size+1);		//make room for null terminate
	int n = read(fd, p, size);		//read from file
	p[n] = '\0';					//add null
	
	return p;
}

rule_t *bake_target_rule(bake_t *bake, char *targname){
// PROBLEM 1: Searches bake for a rule with a target that equals
// `targname`. If found, returns a pointer to that rule. Otherwise
// returns NULL if no rule with target `targname` exists.
//
// DESIGN NOTE: The curent design makes use of linear search for
// target location, O(rule_count) for each lookup. Maintainting a hash
// table of target->rule key/vals would allow O(1) lookup for rules
// with given target names.
	
	for(int i = 0; i < bake->rule_count; i++){				//go through rules
		if(strcmp(bake->rules[i].target, targname) == 0){	//targname match?
			return &bake->rules[i];
		}
	}
	
	return NULL;
}

rule_t *bake_add_empty_rule(bake_t *bake){
// PROBLEM 1: Modifies `bake` to add a new, empty rule to it and
// returns a pointer to that rule. If bake->rules[] is full
// (rule_capacity and rule_count are equal) doubles the size of
// rules[] via realloc() in order create room at its end for the new
// empty rule. Returns a pointer to the new empty rule.
//
// CLARIFICATION: This function intitalizes all the date in the
// returned rule to NULL or 0 including the nested arrays. HINT: make
// use of the memset() to quickly initialize the entire rule_t struct
// to 0's. This is possible due to the nested arrays being within the
// rule_t rather than pointers to other blocks of memory which means a
// single memset() call will suffice.
// 
// CAUTION: Calling this function MAY invalidate any pointers to
// existing rules as the array that houses the rules may move.
// This sequence is dangerous:
//   rule_t *rule  = bake_target_rule(bake, "sometarget");
//   rule_t *empty = bake_add_empty_rule(bake);
//   rule may now point to de-allocated memory

	if(bake->rule_capacity == bake->rule_count){					//does expansion need to happen?
		bake->rules = realloc(bake->rules, (sizeof(rule_t) * 2 * bake->rule_capacity));	//expansion
		bake->rule_capacity *= 2;
	}
	
	memset(&bake->rules[bake->rule_count], 0, sizeof(rule_t));		//initialize rule to 0s
	bake->rule_count++;
	return &bake->rules[bake->rule_count-1];
}

int bake_add_implicit_rules(bake_t *bake){
// PROBLEM 1: Iterate over all rules appending implicit rules for any
// dependency that is not an explicit target. New rules added in this
// way are marked with the RULE_IMPLICIT_BIT.
//
// CAUTION: Since bake->rules[] may expand, care must be taken when
// referencing rules in this function to avoid inadvertently derefing
// a pointer to free()'d memory.
	
	for(int i = 0; i < bake->rule_count; i++){		//loop for all rules
		
		int j = 0;
		while(j < 128){								//loop for each rule's deps
			if(bake->rules[i].deps[j] == NULL){		//reached the end?
				break;
			}
		
			if(bake_target_rule(bake, bake->rules[i].deps[j]) == NULL){					//target exist?
				bake_add_empty_rule(bake);												//new rule made
				SET_BIT(bake->rules[bake->rule_count-1].rule_flags, RULE_IMPLICIT_BIT);	//set implicit
				bake->rules[bake->rule_count-1].target = bake->rules[i].deps[j];		//set rule name
			}
			
			j++;
		}
	}

	return 0;
}

void bake_print_cmd(cmd_t *cmd){
// PROBLEM 1: If the SILENCE_BIT is set, does nothing and immediately
// returns. Otherwise, prints the given command token by token. If I/O
// redirects are indicated by the fields of the command, prints the
// after all tokens with "< infile" for input followed by "> outfile"
// if present. This function is used to print out commands in
// bake_execute_cmd().
	
	if(CHECK_BIT(cmd->cmd_flags, CMD_SILENCE_BIT) == 1){	//silence check
		return;
	}
	
	int i = 0;
	while(1){												//loop for token prints
		if(cmd->tokens[i]==NULL){
			break;
		}
		
		printf("%s ", cmd->tokens[i]);
		i++;
	}
	
	if(cmd->input_redirect != NULL){						//input redirect
		printf("< %s ", cmd->input_redirect);		
	}
	
	if(cmd->output_redirect != NULL){						//output redirect
		printf("> %s ", cmd->output_redirect);
	}
	
	printf("\n");
	
	return;
}

////////////////////////////////////////////////////////////////////////////////
// PROBLEM 2
////////////////////////////////////////////////////////////////////////////////

int bake_execute_cmd(cmd_t *cmd){
// PROBLEM 2: Called during bake_do_update(). Prints the command using
// bake_print_cmd() unless its SILENCE bit is set. fork()'s a child
// process which exec's the command specified in cmd->tokens.  Sets up
// I/O redirection in child process if indicated by cmd flags and
// fields. Uses a wait() call to wait until the child process is
// done. If the child completes normally, its exit code is passed up,
// 0 or non-zero. If the child process fails to complete normally or
// prints an error message with line number of command
// CMD_NONSTAND_EXIT. Non-zero returns from this function will usually
// be handled in a build by cancelling the build whil 0 return will
// cause the build to prceed and execute subsequent commands.
//
// During Input and Output redirection, if the requrested files cannot
// be opened, the child process exits with code CMD_FAIL_INPREDI or
// CMD_FAIL_OUTREDI. Additionally, if the child fails to exec() a
// command, CMD_FAIL_EXEC is used as its return code. All of these are
// non-zero and trigger builds to fail. In the above failure cases,
// prints one of the below error messages appropriate to the error.
// 
// perror("ERROR: can't open file for output")
// perror("ERROR: can't open file for output")
// perror("ERROR: job failed to exec");
//
// CLARIFICATION: When open()'ing files for output redirection,
// certain options should be passed to ensure that the created file
// adheres to conventions
// - For the second argument to open(), pass options
//     O_WRONLY|O_CREAT|O_TRUNC
//   which will open the file for writing, create it if not present,
//   and truncate the file if it already exists
// - For the third argument to open(), pass the arguments
//     S_IRUSR|S_IWUSR
//   which will set the "rw" permissions on the created file for the
//   owner (user) of the file

	bake_print_cmd(cmd);
										//print commands
	if(cmd->tokens[0] == NULL){
		return 0;
	}
	
	pid_t child = fork();									//fork
	
	if(child == 0){											//for child
	
		if(CHECK_BIT(cmd->cmd_flags, CMD_INPREDI_BIT)){		//input redirect
			int fd = open(cmd->input_redirect, O_RDONLY);
			if(fd == -1){
				perror("ERROR: can't open file for input");
				exit(CMD_FAIL_INPREDI);
			}
			dup2(fd, STDIN_FILENO);							//redirection
		}
		
		if(CHECK_BIT(cmd->cmd_flags, CMD_OUTREDI_BIT)){		//output redirect
			int fd = open(cmd->output_redirect, O_WRONLY|O_CREAT|O_TRUNC,  S_IRUSR|S_IWUSR);
			if(fd == -1){
				perror("ERROR: can't open file for output");
				exit(CMD_FAIL_OUTREDI);
			}
			dup2(fd, STDOUT_FILENO);						//redirection
		}
		
		if(execvp(cmd->tokens[0], cmd->tokens) < 0){		//exec
			perror("ERROR: command failed to exec");
			exit(CMD_FAIL_EXEC);
		}	
	}
	
	int status;
	waitpid (child, &status, 0);
	if(!WIFEXITED(status)){                     			//child did not complete properly
    	exit(CMD_NONSTAND_EXIT);
  	}

	return WEXITSTATUS(status);
}

////////////////////////////////////////////////////////////////////////////////
// PROBLEM 3
////////////////////////////////////////////////////////////////////////////////

int bake_set_updates(bake_t *bake, char *targname){
// PROBLEM 3: Starting at `targname`, recurses down the
// target/dependency DAG setting the UPDATE bit in rule_flags to
// indicate whether a target requires updates. Makes use of the
// CLEAR_BIT(), CHECK_BIT(), and SET_BIT() macros when dealing with
// bit-manipulations. For a given rule, first visits all its
// dependencies to check if they require updates via recursion. Then
// determines if `targname` requires an update. The conditions that
// require an update are described in detail in the program
// specification and shoudl be consulted while implementing this
// function. Returns 1 if target needs to be updated so associated
// rule commands should be run later. Returns 0 if the named target
// does not need to be updated. Prints an error if targname is not
// found and returns -1. If any dependency returns -1, an error
// ocurred lower down the DAG. In case, nothing is printed nothing and
// -1 is returned up the nested recursion.
	

	rule_t *rule = bake_target_rule(bake, targname);			//current rule

	if(rule == NULL){											//initial check that the rule exists
		printf("No rule to create target '%s'\n", targname);
		return -1;
	}
	
	if(CHECK_BIT(rule->rule_flags, RULE_UPDATE_BIT)){			//check for previosuly called and updated files
		CLEAR_BIT(rule->rule_flags, RULE_UPDATE_BIT);
	}
	
	if(access(targname, F_OK) == -1){							//check for non-existent file but commands
		if(rule->cmd_count > 0){
			SET_BIT(rule->rule_flags, RULE_UPDATE_BIT);			//set for update
		}
		else if(strcmp(rule->target, "all") == 0){				//special case for 0 cmds
			SET_BIT(rule->rule_flags, RULE_UPDATE_BIT);
		} else {
			printf("Implicit rule cannot find file '%s'\n", targname);
			return -1;
		}
	}
	
	int i = 0;
	char *deptemp = rule->deps[i];								//get pointer of first dependancy
	while(deptemp != NULL){
		int ret = bake_set_updates(bake, deptemp);				//recursive call
		if(ret == -1){											//error
			return -1;
		}
		if(ret == 1){											//dependency requires update, so update
			SET_BIT(rule->rule_flags, RULE_UPDATE_BIT);			//set for update	
		}
		
		if(access(targname, F_OK) == 0 && access(deptemp, F_OK) == 0){	//time check
			struct stat sbtarg; 
			struct stat sbdep;
			stat(targname, &sbtarg); 
			stat(deptemp, &sbdep);
			if(diff_timespec(sbdep.st_mtim, sbtarg.st_mtim) > 0){
				SET_BIT(rule->rule_flags, RULE_UPDATE_BIT);
			}
		}
		
		i++;
		deptemp = bake_target_rule(bake, targname)->deps[i];	//next dependancy
	}
	
	//if no dependants need updates or exist
	
	if(CHECK_BIT(rule->rule_flags, RULE_IMPLICIT_BIT) != 0){	//implicit check
		if(access(targname, F_OK) == -1){						//file exists?
			printf("No rule to create target '%s'\n", targname);
			return -1;
		} else {
			
		}
	}
	
	return CHECK_BIT(rule->rule_flags, RULE_UPDATE_BIT);
}

int bake_do_updates(bake_t *bake, char *targname){
// PROBLEM 3: Starting at `targname`, run commands if the UPDATE bit
// is set. Before running commands associated with `targname`,
// recursively visit dependencies and if their UPDATE bit is set, run
// their commands first. Returns number of rules that were updated or
// -1 to indicate an error ocurred while running commands.
	
	rule_t *rule = bake_target_rule(bake, targname);			//get rule
	if(rule == NULL){
		printf("No rule to create target '%s'", targname);
	}
	
	if(!CHECK_BIT(rule->rule_flags, RULE_UPDATE_BIT)){			//update flag set?
		return 0;
	}
	
	int i = 0;
	int sum = 0;
	char *dep = rule->deps[i];									//get first deps[]
	while(dep != NULL){
		int k = sum;
		sum += bake_do_updates(bake, rule->deps[i]);
		if(sum < k){return -1;}
		
		i++;
		dep = rule->deps[i];
	}
	
	//last guy update
	printf("bake: updating '%s' via %d command(s)\n", rule->target, rule->cmd_count);
	
	for(int m = 0; m < rule->cmd_count; m++){			//loop for every command in the rule
		int ret = bake_execute_cmd(&rule->cmds[m]);		//run specific cmd
		if(ret != 0){									//err case
			printf("%s:%d ERROR during target '%s', exit code %d\n", 
			bake->filename, rule->cmds[m].line_number, targname, ret);
			return -1;
		}
	}
	
	CLEAR_BIT(rule->rule_flags, RULE_UPDATE_BIT);
	sum += 1;
	
	for(int m = 0; m < rule->cmd_count; m++){
		if(CHECK_BIT((rule->cmds[m].cmd_flags), (CMD_SILENCE_BIT))){
			//sum--;
		}
	}
	
	if(strcmp(rule->target, "all") == 0){						//special case for 0 cmds
		//sum++;
	}
	
	return sum;
}

////////////////////////////////////////////////////////////////////////////////
// PROBLEM 4
////////////////////////////////////////////////////////////////////////////////

int bake_cmd_postprocess(bake_t *bake, cmd_t *cmd){
// PROBLEM 4: Examines cmd->tokens to set cmd->flags and a few other
// fields. Used to post-process the raw tokens of a command. Likely
// uses the utility function array_shift() to ease the re-arrangment
// of arrays.
// 
// 1. If tokens[0] = "@", eliminates this token by shifting all tokens
// over and sets the SILENCED bit
// 
// 2. If tokens[i] = "<", input redirection is desired; if tokens[i+1]
// is not NULL, returns -1. Otherwise sets the INPREDI bit and
// input_redirect field to tokens[i+1]. Then shifts all tokens over to
// eliminate tokens[i] and tokens[i+1].
// 
// 3. If tokens[i] = ">", output redirection is desired and performs
// similar operations to #2 with the OUTREDI flag and output_redirect
// fields.
//
// Correctly handles any order of "< input" / "> output" and other
// tokens (ex: output redirection may appear first followed by normal
// tokens followed by input redirection)
// 
// If multiple "<" or ">" tokens appear, the behavior of this function
// is unspecified: it may return an error, segfault, or behave randomly.
// 
// Returns 0 on succesful completion.
//
// DESIGN NOTE: This function must be called prior to any commands
// being run. The ideal location is during parsing to modify commands
// as a bake_t structure is built. However, this functionality is
// separated out to enable future functionality such as variable
// substitution to be added to commands and tested separately from
// parsing. Any additional context needed for such things will be part
// of the 'bake' parameter (e.g. may contain a map of variable
// names/values for substitutions).
	
	if(strcmp(cmd->tokens[0], "@") == 0){
		array_shift(cmd->tokens, 0, 128);
		SET_BIT(cmd->cmd_flags, CMD_SILENCE_BIT);
	}
	
	int i = 0;
	char *token = cmd->tokens[i];
	while(token != NULL){
		
		if(strcmp(token, ">") == 0){
			if(cmd->tokens[i + 1] == NULL){
				return -1;
			}
			SET_BIT(cmd->cmd_flags, CMD_OUTREDI_BIT);
			cmd->output_redirect = cmd->tokens[i + 1];
			array_shift(cmd->tokens, i, 128);
			array_shift(cmd->tokens, i, 128);
			i -= 1;
		}
		
		if(strcmp(token, "<") == 0){
			if(cmd->tokens[i + 1] == NULL){
				return -1;
			}
			SET_BIT(cmd->cmd_flags, CMD_INPREDI_BIT);
			cmd->input_redirect = cmd->tokens[i + 1];
			array_shift(cmd->tokens, i, 128);
			array_shift(cmd->tokens, i, 128);
			i -= 1;
		}
		
		i++;
		token = cmd->tokens[i];
	}

	return 0;
}

void bake_post_process(bake_t *bake){
// PROBLEM 4: Applies postprocessing operations to the bake after
// loading it from a file. Currently only iterates over all rules and
// applies bake_cmd_postprocess() to each of their commands.
//
// DESIGN NOTE: This function is where additional operations could be
// used to further modify the bakefile such as performing variable
// substitutions on rules / targets, including other bakefiles. etc.


	for(int i = 0; i < bake->rule_count; i++){
		for(int j = 0; j < bake->rules[i].cmd_count; j++){
			bake_cmd_postprocess(bake, &bake->rules[i].cmds[j]);
		}
	}
}
