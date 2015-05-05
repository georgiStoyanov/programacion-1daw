package ejemploHibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AlumnoHibernateDAO implements AlumnoDAO{

	
	
	private EntityManager _em;

	public AlumnoHibernateDAO( EntityManager em ){
		_em = em;
	}
	
	@Override
	public void update(Alumno a) {
		_em.persist(a);
	}

	@Override
	public void insert(Alumno a)  {
		_em.persist(a);
	}

	@Override
	public void delete(Alumno a)  {
		_em.remove(a);
	}


	@Override
	public Alumno findByPrimaryKey(Alumno a)  {
		TypedQuery<Alumno> q = _em.createQuery("from Alumno where idalumno=:id", Alumno.class);
		q.setParameter("id", a.getIdAlumno() );
		List<Alumno> resultList = q.getResultList();
		return resultList.get(0);
	}

	@Override
	public List<Alumno> findByBirthDay(Date min, Date max)  {
		TypedQuery<Alumno> q = _em.createQuery("from Alumno where fechaNacimiento <= :min and fechaNacimiento >= :max", Alumno.class);
		q.setParameter("min", min );
		q.setParameter("max", max );
		List<Alumno> resultList = q.getResultList();
		return resultList;

	}

	@Override
	public List<Alumno> findAll() {
		TypedQuery<Alumno> q = _em.createQuery("from Alumno", Alumno.class);
		List<Alumno> resultList = q.getResultList();
		return resultList;
	}

}
