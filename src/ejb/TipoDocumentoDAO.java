package ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.TipoDocumento;

public class TipoDocumentoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSF");
	EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<TipoDocumento> findAll() {
		Query query = em.createQuery("SELECT t FROM TipoDocumento t");
	    return query.getResultList();
	}
}
