package comboPackage;

import java.util.List;

public class DAOTests {

	public static void main(String[] args) {
		
		// Create and insert directors
		Director director1 = new Director("Steven", "Spielberg", "1234 Rich Place", "male");
		Director director2 = new Director("George", "Lucas", "1234 Even Richer", "male");
		Director director3 = new Director("Ava", "DuVernay", "1738 Somewhere", "female");
		Director director4 = new Director("Hitchcock", "Alfred", "8976 Twilight Zone", "male");
		Director director5 = new Director("Halp", "Taylor", "4638 Somwhere", "sadkfhaslkdfh");
		
		DirectorDAO directorDao = new DirectorDAO();
		directorDao.insert(director1);
		directorDao.insert(director2);
		directorDao.insert(director3);
		directorDao.insert(director4);
		directorDao.insert(director5);
		
		// Correcting/updating a director
		director5.setGender("MALE");
		directorDao.update(director5);
		
		// Print directors from DB
		System.out.println("---------- Directors in DB ----------");
		List <Director> directorList = directorDao.getAll();
		for(Director director : directorList) {
			System.out.println(director.toString());
		}			
		
		// Create and inserting movies
		Movie movie1 = new Movie("Ready Player One", "2018", "PG-13", "sci-fi", 140, director1);
		Movie movie2 = new Movie("Schindlers List", "1993", "R", "Drama", 195, director1);
		Movie movie3 = new Movie("The Last Jedi", "2017", "PG-13", "Sci-fi", 150, director2);
		Movie movie4 = new Movie("Selma", "2014", "PG-13", "drama", 168, director3);
		Movie movie5 = new Movie("The Birds", "1963", "PG-13", "PG-13", 120, director4);
		
		MovieDAO movieDao = new MovieDAO();
		movieDao.insert(movie1);
		movieDao.insert(movie2);
		movieDao.insert(movie3);
		movieDao.insert(movie4);
		movieDao.insert(movie5);
		
		// Print movies from DB
		System.out.println("---------- Movies in DB ----------");
		List <Movie> movieList = movieDao.getAll();
		for(Movie movie : movieList) {
			System.out.println(movie.toString());
		}
		
		// Find a single director by ID.
		Director directorSingleResult = directorDao.searchForDirectorById(directorList.get(directorList.size() - 1).getId());
		System.out.println("---------- Find a single Director by ID ----------");
		System.out.println(directorSingleResult.toString());
		
		// Find a single movie by ID.
		Movie movieSingleResult = movieDao.searchForMovieById(movieList.get(movieList.size() - 1).getId());
		System.out.println("---------- Find a single Director by ID ----------");
		System.out.println(movieSingleResult.toString());
		
		// Deletes all movies
		System.out.println("\n---------- Deleting all movies ----------");
		for(Movie movie : movieList) {
			movieDao.delete(movie);
		}
		System.out.println("--------------------> Movies Deleted");
		
		// Deletes all directors
		System.out.println("---------- Deleting all directors ----------");
		for(Director director : directorList) {
			directorDao.delete(director);
		}
		System.out.println("--------------------> Directors Deleted");
	}

}
