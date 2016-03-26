package ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Pais;

public class PaisDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSF");
	EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Pais> findAll() {
		Query query = em.createQuery("SELECT p FROM Pais p");
	    return query.getResultList();
	}
}
