package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	MyDataAcces database;
	Observers o;
	boolean[] utilizada = {false, false, false, false, false};   //Para saber si estan siendo utilizadas las tablas.
	
	public Model(){
		database = new MyDataAcces ();
	}
	
	public void registerObserver(Observers o){
		this.o = o;
	}
	
	public void print_clientes(){
		if(utilizada[0]==true){
			//Si ya esta siendo utilizada, no hace nada.
		}
		else{
			//Seteo la tabla que esta siendo utilizada
			for(int i=0; i<utilizada.length; i++){
				utilizada[i]=false;
			}
			utilizada[0]=true;
			
			o.clear_all();    //Borro lo que haya de antes en la tabla
			
			
			ResultSet resultado;
			//Object []object = new Object[8];
		
			resultado = database.getQuery("select* from clientes");
		
			o.add_Column("Id Cliente");o.add_Column("Id Obra Social");
			o.add_Column("Id Localidad");o.add_Column("Nombre");
			o.add_Column("Apellido");o.add_Column("Num Afiliado");
			o.add_Column("Direccion");o.add_Column("KMTS");
			o.add_Column("Dependencia");
		
			try {
				while(resultado.next()){
					/*nombre = resultado.getString("nombre");
					object[0]=nombre;*/
					String[] string = {resultado.getString("idCliente"),resultado.getString("idObraSocial"),resultado.getString("idLocalidad"),
							           resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("num_afiliado"),
							           resultado.getString("direccion"),resultado.getString("kmts"),resultado.getString("dependencia")};
					Object[] object = {string[0],string[1],string[2],string[3],string[4],string[5],string[6],string[7],string[8]}; 
					o.add_Fila(object);
					//System.out.println(object[0].toString() + string[1]);
				}
		     
		    	}catch (SQLException e) {
		    		// TODO Auto-generated catch block
		    		e.printStackTrace();
		    	}
		}
	}
	
	public void insert_cliente(Object[] obj){
		database.setQuery("call ins_clientes(" + obj[0]+ "," + obj[1] +"," + obj[2] + "," + "\"" + obj[3]
				+ "\"" + "," + "\"" + obj[4] + "\"" + "," + obj[5] + "," + "\"" + obj[6] + "\"" + "," + obj[7] + "," + obj[8] + ")");
		o.add_Fila(obj);
	}
	
	public int toInt(Object obj){
		int i = Integer.parseInt(obj.toString());
		return i;
	}
}
