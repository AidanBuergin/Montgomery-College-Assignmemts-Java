import java.util.*;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Movie movie = new Movie();
		
		System.out.println("Enter the name of a movie");
		movie.setTitle(sc.nextLine());
		
		System.out.println("Enter the rating of the movie");
		movie.setRating(sc.nextLine());
		
		System.out.println("Enter the number of tickets sold for this movie");
		movie.setSoldTickets(sc.nextInt());
		
		sc.close();
		System.out.println("Goodbye\n");
		
		System.out.println(movie.toString());
		
		
		
	}

}
