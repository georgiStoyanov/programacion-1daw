package ejemploHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matriculacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMatriculacion;
	
    @ManyToOne
    @JoinColumn(name="idalumno")
	private Alumno alumno;
    
    
    @Column
    private String nombreAsignatura;
    
    public String getNombreAsignatura() {
		return nombreAsignatura;
	}


	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}


	public Matriculacion(){
    	this(null);
    }
    
    
    public Matriculacion( String nombreAsignatura ){
    	this.nombreAsignatura = nombreAsignatura;
    }
    

	public int getIdMatriculacion() {
		return idMatriculacion;
	}

	public void setIdMatriculacion(int idMatriculacion) {
		this.idMatriculacion = idMatriculacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
		alumno.addMatriculacion(this);
	}
	
	@Override
	public String toString() {
		return "Matriculación en:" + getNombreAsignatura();
	}
}
