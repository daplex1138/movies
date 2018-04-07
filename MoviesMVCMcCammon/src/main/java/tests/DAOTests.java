package tests;

import java.util.List;

import dao.DirectorDAO;
import model.Director;

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
		
		// Print directors from DB
		System.out.println("---------- Directors in DB ----------");
		List <Director> directorList = directorDao.getAll();
		for(Director director : directorList) {
			System.out.println(director.toString());
		}
		
		// Correcting/updating a director
		director5.setGender("MALE");
		directorDao.update(director5);
		System.out.println("---------- Correcting director information ----------");
		directorList = directorDao.getAll();
		for(Director director : directorList) {
			System.out.println(director.toString());
		}
			
		// Deletes all directors
		System.out.println("---------- Deleting all directors ----------");
		for(Director director : directorList) {
			directorDao.delete(director);
		}
		System.out.println("--------------------> Directors Deleted");
	}

}
