package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.Cliente;

public class ClienteDao {

	EntityTransaction transaction;
	static EntityManager manager;
	TypedQuery<Cliente> query;
	
	public ClienteDao() {
		manager = HibernateUtil.getEntityManager();
	}
	
	public void create(Cliente c) throws Exception{
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(c);
		transaction.commit();
	}
	
	public List<Cliente> findAll(){
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
	public Cliente findById(Long idCliente) {
		query = (TypedQuery<Cliente>) manager.createQuery("select obj from Cliente as obj where obj.idCliente = :param1", Cliente.class);
		query.setParameter("param1", idCliente);
		return query.getSingleResult();
	}
	
	public void delete(Cliente c) throws Exception{
		transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(c);
		transaction.commit();
	}
		
}
