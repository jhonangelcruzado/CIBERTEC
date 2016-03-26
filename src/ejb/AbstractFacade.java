package ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Cliente;

public abstract class AbstractFacade<T> {
	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void create(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void edit(T entity) {
		getEntityManager().merge(entity);
	}
	
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public List<Cliente> findAll() {
		Query query = getEntityManager().createQuery("SELECT c FROM Cliente c");
	    return query.getResultList();
	}

}
