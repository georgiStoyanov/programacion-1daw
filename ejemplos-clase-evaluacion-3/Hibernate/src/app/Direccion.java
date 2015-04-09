package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {

	public Direccion(){
		
	}
	
	public Direccion( String direccion, String cp, String municipio, String provincia ){
		this();
		setDireccion(direccion);
		setCodigoPostal(cp);
		setMunicipio(municipio);
		setProvincia(provincia);
		setPais("España");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;
    
    @Column
    private String direccion;

    @Column
    private String codigoPostal;
    
    @Column
    private String municipio;
    
    @Column
    private String provincia;
    
    @Column
    private String pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		// HIBERNATE SUELE HACER ESTO SOLO, PERO HAY EXCEPCIONES
		if( !cliente.getDirecciones().contains(this) ){
			cliente.getDirecciones().add(this);
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", cliente=" + cliente.getIdCliente() + ", direccion="
				+ direccion + ", codigoPostal=" + codigoPostal + ", municipio="
				+ municipio + ", provincia=" + provincia + ", pais=" + pais
				+ "]";
	}




}
