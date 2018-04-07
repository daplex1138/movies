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
		String query = "select d from Director d";
		TypedQuery<Director> typedQuery = em.createQuery(query, Director.class);
		List<Director> all = typedQuery.getResultList();
		
		return all;
	}
	
	public void delete(Director toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Director> typedQuery = em.createQuery("SELECT d FROM Director d WHERE d.id = :selectedId", Director.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Director result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Director toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Director searchForDirectorById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Director result = em.find(Director.class, id);
		em.close();
		
		return result;
	}
	
}
