import java.util.*;

public class MovieDriver_Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		String title;
		String rating;
		int tickets;
		
		Scanner sc = new Scanner(System.in);
		
		Movie movie = new Movie();
		
		while(i < 1) {
			
			System.out.println("Enter the name of a movie");
			title = sc.nextLine();
			movie.setTitle(title);
			
			System.out.println("Enter the rating of the movie");
			rating = sc.nextLine();
			movie.setRating(rating);
			
			System.out.println("Enter the number of tickets sold for this movie");
			tickets = sc.nextInt();
			sc.nextLine();
			movie.setSoldTickets(tickets);
			
			System.out.println(movie.toString());
			
			System.out.println("Do you want to enter another? (y or n)");
			if(!(sc.nextLine().toLowerCase().equals("y"))) {
				i = 1;
				System.out.println("Goodbye");
			}
			
		}
		
		sc.close();
		
		
	}

}
