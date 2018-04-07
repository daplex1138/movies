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
	
	public void delete(Movie toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em.createQuery("SELECT m FROM Movie m WHERE m.id = :selectedId", Movie.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Movie result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Movie toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Movie searchForDirectorById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Movie result = em.find(Movie.class, id);
		em.close();
		
		return result;
	}
}
