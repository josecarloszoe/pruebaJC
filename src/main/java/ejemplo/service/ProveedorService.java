package ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ejemplo.dao.Dao;
import ejemplo.entities.Proveedores;

@Service
public class ProveedorService {

	  @Autowired
	  private Dao<Proveedores> dao;
	  
	  public List<Proveedores> getProveById(long id) {
	      try {
	          return dao.load(id);
	      } catch (DataAccessException e) {
	          e.printStackTrace();
	      }
	      return null;
	  }
}
