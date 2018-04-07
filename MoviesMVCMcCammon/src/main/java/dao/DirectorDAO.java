package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Director;

public class DirectorDAO {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MoviesMVCMcCammon");
	
	public void insert(Director toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Director> getAll() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String query = "select d from director d";
		TypedQuery<Director> typedQuery = em.createQuery(query, Director.class);
		List<Director> all = typedQuery.getResultList();
		
		return all;
	}
}
