package ejemplo.dao;

import java.util.List;

import ejemplo.entities.Proveedores;

public interface Dao<T> {
	 
	  List<Proveedores> load(long id);
	  
	}
