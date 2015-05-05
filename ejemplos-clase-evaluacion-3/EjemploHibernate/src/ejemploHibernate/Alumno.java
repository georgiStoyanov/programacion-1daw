package ejemploHibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alumno {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private int idAlumno;
	
	@Column	private String nombre;
	@Column private String apellidos;
	@Column private Date fechaNacimiento;
	@Column private double calificacion;
	@Column private String nota;
	
	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	
	public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    public Alumno(int idAlumno, String nombre, String apellidos, Date fechaNacimiento, double calificacion, String nota) {
    	this.setIdAlumno(idAlumno);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaNacimiento(fechaNacimiento);
		this.setCalificacion(calificacion);
		this.setNota(nota);
	}

    public Alumno() {
    	this(-1,"","",new Date(),0,"");
	}

	@Override
    public String toString() {
        return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
                + ", calificacion=" + calificacion + ", nota=" + nota + "]";
    }
}
