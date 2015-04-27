package app;

 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
 
 
public class Main {
 
	
	
    /**
     * @param args
     */
	
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplo-derby");
        EntityManager em = emf.createEntityManager();
        crearClientes(em);
        listarClientes(em);
        em.close();
        System.exit(0);
    }

	private static void crearClientes(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Cliente c = new Cliente("Álvaro", "González Sotillo");
        c.setImagen( "holaquetal".getBytes() );
        Direccion d1 = new Direccion("una calle", "28999", "Un municipio", "Madrid");
        Direccion d2 = new Direccion("otra calle", "28999", "Otro municipio", "Madrid");
        
        c.addDireccion(d1);
        c.addDireccion(d2);
        
        em.persist(c);
        em.persist(d1);
        em.persist(d2);
        
        
        tx.commit();
		
	}

	
	private static void listarClientes(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("FROM Cliente");
        @SuppressWarnings("unchecked") 
        List<Cliente> clientes = query.getResultList();
        for( Cliente c: clientes ){
        	System.out.println(c);
        }
        tx.commit();
        
	}
}