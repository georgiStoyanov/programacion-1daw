package ejemploDAO;

import java.util.Date;
import java.util.List;

public interface AlumnoDAO {
	public void update( Alumno a ) throws Exception;
	public void insert( Alumno a ) throws Exception;
	public void delete( Alumno a ) throws Exception;
	
	public void createDataBase()  throws Exception;
	
	/**
	 * 
	 * @param a Un alumno con la clave primaria rellena, lo demás se ignora (nombre y apellidos)
	 * @return null si no lo encuentra, y otra instancia de Alumno con los datos, si lo encuentra
	 */
	public Alumno findByPrimaryKey( Alumno a ) throws Exception;
	
	/**
	 * @param min Fecha minima, incluida
	 * @param min Fecha maxima, incluida
	 * @return Los alumnos que cumplen el criterio
	 */
	public List<Alumno> findByBirthDay( Date min, Date max ) throws Exception;

	public List<Alumno> findAll() throws Exception;
	public void commit() throws Exception;
	

}


















