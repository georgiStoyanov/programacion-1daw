package app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	
	public Cliente(){
	}
	
	public Cliente( String nombre, String apellidos ){
		this();
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public long getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(long id) {
		this.idcliente = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idcliente;

	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@OneToMany(mappedBy="cliente")
	private List<Direccion> direcciones;
	

	public List<Direccion> getDirecciones() {
		if (direcciones == null) {
			direcciones = new ArrayList<Direccion>();
		}
		return direcciones;
	}

	public void addDireccion(Direccion d){
		// HIBERNATE SUELE HACER ESTO SOLO, PERO HAY EXCEPCIONES
		getDirecciones().add(d);
		if( d.getCliente() != this ){
			d.setCliente(this);
		}
	}
	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direcciones=" + direcciones
				+ "]";
	}

	
	
}
