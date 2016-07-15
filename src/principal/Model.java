package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	MyDataAcces conexion;
	Observers o;
	
	public Model(){
		conexion = new MyDataAcces ();
	}
	
	public void registerObserver(Observers o){
		this.o = o;
	}
	
	public void get_clientes(){
		ResultSet resultado;
		String nombre;
		String apellido;
		Object []object = new Object[8];
		int i=0;
		
		resultado = conexion.getQuery("select* from clientes");
		
		o.add_Column("Nombre");o.add_Column("Apellido");
		
		try {
		      while(resultado.next()){
		    	  nombre = resultado.getString("nombre");
		    	  object[0]=nombre;
		    	  apellido = resultado.getString("apellido");
		    	  object[1]=apellido;
		    	  o.add_Fila(object);
		    	  //System.out.println(nombre + apellido);
		      }
		     
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		   }
	}
}
