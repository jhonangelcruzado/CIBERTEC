package controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import ejb.TipoDocumentoDAO;
import entities.TipoDocumento;

@ManagedBean
@RequestScoped
public class TipoDocumentoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TipoDocumentoDAO dao;
	private ArrayList<SelectItem> lista;
	
	@PostConstruct
	public void init() {
		setDao(new TipoDocumentoDAO());
		setLista(new ArrayList<SelectItem>());
	}

	public TipoDocumentoDAO getDao() {
		return dao;
	}

	public void setDao(TipoDocumentoDAO dao) {
		this.dao = dao;
	}

	public ArrayList<SelectItem> getLista() {
		for (TipoDocumento d : dao.findAll()) {
			lista.add(new SelectItem(d.getIdTipoDocumento(), d.getDocumento()));
		}
		return lista;
	}

	public void setLista(ArrayList<SelectItem> lista) {
		this.lista = lista;
	}
}
