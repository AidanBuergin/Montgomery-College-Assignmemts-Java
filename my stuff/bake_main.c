#include "bake.h"
#include <unistd.h>

int main(int argc, char *argv[]){
	
	char *targ = NULL;						//target variable
	bake_t *bake = NULL;					//bake variable
	
	if(strcmp(argv[0], "cat")== 0){
		printf("%s %s", argv[0], argv[1]);
	}
	
	if(argc == 1){							//1 arg?
		bake = bake_create_from_file("Bakefile");
		if(bake == NULL){
			printf("ERROR: unable to process file 'Bakefile'\n");
			exit(EXIT_FAILURE);
		}
	}
	else if(argc == 2){						//2 args?
		bake = bake_create_from_file("Bakefile");
		if(bake == NULL){
			printf("ERROR: unable to process file 'Bakefile'\n");
			exit(EXIT_FAILURE);
		}
		targ = argv[1];
	}
	else if(argc == 3){						//3 args?
		bake = bake_create_from_file(argv[2]);
		if(bake == NULL){
			printf("ERROR: unable to process file '%s'\n", argv[2]);
			exit(EXIT_FAILURE);
		}
	}
	else if(argc == 4){						//4 args?
		bake = bake_create_from_file(argv[2]);
		if(bake == NULL){
			printf("ERROR: unable to process file '%s'\n", argv[2]);
			exit(EXIT_FAILURE);
		}
		targ = argv[3];
	}
	
	if(bake->rule_count == 0){				//0 rule err check
		printf("ERROR: '%s' has 0 rules\n", bake->filename);
		bake_free(bake);
		exit(EXIT_FAILURE);
	}
	
	bake_add_implicit_rules(bake);			//add implicit
	bake_post_process(bake);				//post processs
	
	if(targ == NULL){						//'all' or 'clean' check
		targ = bake->rules[0].target;
	}
	
	int ret = 0;
	ret = bake_set_updates(bake, targ);
	
	if(ret == -1){								//failed?
		printf("bake failed\n");
		bake_free(bake);
		exit(EXIT_FAILURE);
	}
	
	if(ret == 0){								//no update needed?
		if(access(targ, F_OK) == -1){			//file exist?
			printf("bake: nothing to be done for target '%s'\n", targ);
			return 0;
		} else {
			printf("bake: file '%s' is up to date\n", targ);
			return 0;
		}
	}
	
	int updates = bake_do_updates(bake, targ);	//carry out updates
	if(updates == -1){							//err occured?
		printf("bake failed\n");
		bake_free(bake);
		exit(EXIT_FAILURE);
	}
	
	printf("bake complete, %d update(s) performed\n", updates);

	bake_free(bake);
	return 0;
}
