package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import ejb.ClienteDAO;
import ejb.ClienteFacade;
import ejb.ClienteFacadeLocal;
import entities.Cliente;

@Named
@RequestScoped
@ManagedBean
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacadeLocal clienteEJB;
	private Cliente cliente;
	private DataModel<Cliente> listaClientes;
	private ClienteDAO dao = new ClienteDAO();
	private static int estado;

	@PostConstruct
	public void init() {

		setCliente(new Cliente());	
		clienteEJB = new ClienteFacade();
		
		if (estado == 0) {
			System.out.println("Generando cod..");
			cliente.setIdCliente(dao.generarCodigo());
		}
	}
	
	public String grabar() {
		System.out.println("Estado = " + estado);
		try {

			if (estado == 0) {
				cliente.setEstado("Activo");
				return dao.crear(cliente);
			} else {
				return dao.modificar(cliente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error.xhtml";
	}
	
	public void buscar(ActionEvent e) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(e.getComponent().getAttributes().get("idCliente").toString());
		
		estado = 1;
		System.out.println("Estado = " + estado);
		this.cliente = dao.buscar(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DataModel<Cliente> getListaClientes() {
		listaClientes = new ListDataModel<Cliente>(clienteEJB.findAll());
		return listaClientes;
	}

	public void setListaClientes(DataModel<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
