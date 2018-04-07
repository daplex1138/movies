package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Movie;

public class MovieDAO {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MoviesMVCMcCammon");
	
	public void insert(Movie toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Movie> getAll() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String query = "select m from Movie m";
		TypedQuery<Movie> typedQuery = em.createQuery(query, Movie.class);
		List<Movie> all = typedQuery.getResultList();
		
		return all;
	}
}
