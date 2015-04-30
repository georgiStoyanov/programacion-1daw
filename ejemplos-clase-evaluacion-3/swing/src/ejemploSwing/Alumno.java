package ejemploSwing;

import java.util.Date;

public class Alumno {
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private double calificacion;
    private String nota;
	
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
    
    public Alumno(String nombre, String apellidos, Date fechaNacimiento, double calificacion, String nota) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaNacimiento(fechaNacimiento);
		this.setCalificacion(calificacion);
		this.setNota(nota);
	}

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
                + ", calificacion=" + calificacion + ", nota=" + nota + "]";
    }
}
