package ejb;

import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import entities.Cliente;


public class ClienteDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSF");
	EntityManager em = emf.createEntityManager();
	
	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		Query query = em.createQuery("SELECT c FROM Cliente c");
	    return query.getResultList();
	}
	
	public String crear(Cliente cliente) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return "listarClientes.xhtml";
	}
	
	public Cliente buscar(Cliente cliente) {
		Cliente obj = null;
		
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			obj = em.find(Cliente.class, cliente.getIdCliente());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return obj;
	}
	
	public String modificar(Cliente cliente) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return "listarClientes.xhtml";
	}
	
	public void eliminar(Cliente cliente) {
		Cliente obj = null;
		
		try {
			em.getTransaction().begin();
			obj = em.find(Cliente.class, cliente.getIdCliente());
			if (obj != null) em.remove(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public String generarCodigo() {
		
		try {
			em.getTransaction().begin();
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("usp_GenerarCodigoCliente");
			storedProcedure.registerStoredProcedureParameter("CODIGO", Integer.class, ParameterMode.OUT);
			
			storedProcedure.execute();
			
			int numero = (Integer) storedProcedure.getOutputParameterValue("CODIGO");
			
			em.getTransaction().commit();
			DecimalFormat df = new DecimalFormat("CLI-00000");
			
			if (numero < 100000) {
				return df.format(numero);
			} else {
				return "CLI-" + numero;
			}
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {

		}
		
	}
}
