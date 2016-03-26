package controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import ejb.PaisDAO;
import entities.Pais;

@ManagedBean
@RequestScoped
public class PaisController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private PaisDAO dao;
	private ArrayList<SelectItem> lista;
	
	@PostConstruct
	public void init() {
		setDao(new PaisDAO());
		setLista(new ArrayList<SelectItem>());
	}

	public PaisDAO getDao() {
		return dao;
	}

	public void setDao(PaisDAO dao) {
		this.dao = dao;
	}

	public ArrayList<SelectItem> getLista() {
		for (Pais p : dao.findAll()) {
			lista.add(new SelectItem(p.getIdPais(), p.getPais()));
		}
		return lista;
	}

	public void setLista(ArrayList<SelectItem> lista) {
		this.lista = lista;
	}
}
