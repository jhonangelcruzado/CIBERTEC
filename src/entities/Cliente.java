package entities;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;
import org.omg.CORBA.ParameterMode;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idCliente;

	private String apellidos;

	private String email;

	private String estado;

	private String nombres;

	private String nroDocumento;

	private String razonSocial;

	private String ruc;

	private String tarjetaCredito;

	private String telefono;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="idPais")
	private Pais pais;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="idTipoDocumento")
	private TipoDocumento tipodocumento;

	public Cliente() {
		pais = new Pais();
		tipodocumento = new TipoDocumento();
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public TipoDocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

}