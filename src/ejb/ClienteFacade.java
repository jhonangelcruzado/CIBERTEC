package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {
	private EntityManagerFactory emf;
	
	@Override
	public EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("JSF");
		return emf.createEntityManager();
	}
	
	public ClienteFacade() {
		super(Cliente.class);
	}
	
}
