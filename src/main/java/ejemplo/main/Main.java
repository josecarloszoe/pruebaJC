package ejemplo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import ejemplo.service.ProveedorService;

@Configuration
@ComponentScan
public class Main {

	  @Bean
	  public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	      LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
	      factory.setPersistenceUnitName("example-unit");
	      return factory;
	  }
	
	@Autowired
	ProveedorService proveedorService;
	
	public static void main(String[] args) {
		
		String one = args[0];
		Long id = Long.valueOf(one);
		AnnotationConfigApplicationContext context =
	              new AnnotationConfigApplicationContext(Main.class);
	    int result = context.getBean(ExampleProveedor.class).run(id);
	    
	    if(result == -1)
	    	System.out.println("El id Cliente no tiene proveedores");
	    else
	    	System.out.println("Fin");

	}


}
