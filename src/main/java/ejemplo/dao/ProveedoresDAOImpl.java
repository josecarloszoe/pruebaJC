package ejemplo.dao;

import org.springframework.stereotype.Repository;

import ejemplo.entities.Proveedores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import java.util.List;

@Repository
public class ProveedoresDAOImpl implements Dao<Proveedores>{

	@PersistenceUnit
	private EntityManagerFactory emf;
  
  public List<Proveedores> load(long id) {
	  EntityManager em = emf.createEntityManager();
	 Query listaQ = em.createQuery("select p from Proveedores p where p.idCliente = :id ");
	 listaQ.setParameter("id", id);
	 return listaQ.getResultList();
  }
  
  
}
