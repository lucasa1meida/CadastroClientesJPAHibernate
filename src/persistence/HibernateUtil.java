package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil {

	
	 protected static EntityManager manager;
	 protected EntityTransaction transaction;
	
	 
	public static EntityManager getEntityManager(){
	  EntityManagerFactory factory = Persistence.createEntityManagerFactory("prjCadastroClienteMVC");
	  if (manager==null){
	      manager = factory.createEntityManager();
	  }
	  return manager;
	}
	
	public EntityManager getManager(){
		return manager;
	}
}
