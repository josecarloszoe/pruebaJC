package ejemplo.main;

import java.util.List;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.entities.Proveedores;
import ejemplo.service.ProveedorService;

@Component
public class ExampleProveedor {

	@Autowired
	ProveedorService proveedorService;

@SuppressWarnings("finally")
public int run(long idClinte) {
      
	  List<Proveedores> prov =  proveedorService.getProveById(idClinte);
	  
	  if(prov.isEmpty())
		  return -1;
	  
	  FileWriter fichero = null;
      PrintWriter pw = null;
      try
      {
          fichero = new FileWriter("prueba.txt");
          pw = new PrintWriter(fichero);

          for(Proveedores pr: prov) {
        	  String idP = String.valueOf(pr.getId());
        	  String nombre= pr.getNombre();
        	  String fecha = pr.getFechaAlta();
        	  pw.println(idP+", "+nombre+", "+fecha+", "+idClinte);
        	  
          }
          

      } catch (Exception e) {
          e.printStackTrace();
      } finally {
         try {
         if (null != fichero)
            fichero.close();
         } catch (final Exception e2) {
            e2.printStackTrace();
         }
         
         return 0;
      }
	  
  }
}