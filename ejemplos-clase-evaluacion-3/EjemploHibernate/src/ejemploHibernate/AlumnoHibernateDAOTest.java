package ejemploHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AlumnoHibernateDAOTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ejemplo-oracle");
		EntityManager em = emf.createEntityManager();
		
		Alumno a = new Alumno();
		Matriculacion m = new Matriculacion("Asignatura1");
		a.addMatriculacion(m);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		em.persist(m);
		tx.commit();
		
		
	}

}
