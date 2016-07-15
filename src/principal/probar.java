package principal;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class probar {
	
	public probar(){
		
		/*Crear Tabla*/
		JTable tabla;
		tabla = new JTable();
		
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();	
		tabla.setModel(modelo);
		
		JScrollPane JP = new JScrollPane(tabla);
		
		JFrame frame = new JFrame();
		frame.add(JP);
		
		frame.setVisible(true);
		
		/*Añadir Columnas*/ 
		modelo.addColumn("Id");
		modelo.addColumn("Primer nombre");
		modelo.addColumn("Segundo nombre");
		modelo.addColumn("Primer apellido");
		modelo.addColumn("Segundo apellido");
		modelo.addColumn("Sexo");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		
		/*Añadir Filas*/
		Object []object = new Object[8];
		object[0] = "1";
		object[1] = "Carlos"; 
		object[2] = "Sanchez"; 
		object[3] = "Carliños"; 
		object[4] = "Cabezon"; 
		object[5] = "Masculino"; 
		object[6] = "Pje balzano 1203"; 
		object[7] = "4635894";
		modelo.addRow(object);
		
		/*Borrar Todo*/
		/*modelo.setColumnCount(0);
		modelo.setRowCount(0);*/
		
	}
	
}
