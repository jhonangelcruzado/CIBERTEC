package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import entities.Cliente;

@Local
public interface ClienteFacadeLocal {
	
	void create(Cliente cliente);
	
	void edit(Cliente cliente);
	
	void remove(Cliente cliente);
	
	Cliente find(Object id);
	
	List<Cliente> findAll();

}
