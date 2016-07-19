package principal;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;


public class View extends JFrame implements ActionListener, Observers {
	Model model;
	
	/*Panel*/
	private JPanel contentPane;
	
	/*Tabla*/
	private JTable table;
	private JScrollPane JP;
	private DefaultTableModel tabla = new DefaultTableModel();
	
	/*Menu*/
	JMenuBar menuBar = new JMenuBar();
	
	JMenu Inicio = new JMenu("Inicio");
	JMenu Opciones = new JMenu("Opciones");
	
	JMenuItem Clientes = new JMenuItem("Clientes");
	
	/*add Clientes*/
	private final JLabel lblNombre = new JLabel("Nombre");
	private final JLabel lblApellido = new JLabel("Apellido");
	
	private final JTextField textNombre = new JTextField();
	private final JTextField textApellido = new JTextField();
	private final JTextField textObraSocial = new JTextField();
	private final JTextField textLocalidad = new JTextField();
	private final JTextField textNumAfiliado = new JTextField();
	private final JTextField textDireccion = new JTextField();
	private final JTextField textKMTS = new JTextField();
	private final JRadioButton rdbtnDependencia = new JRadioButton("Dependencia");
	
	private final JButton btnAgregar = new JButton("Agregar");
	
	/*Notificaciones*/
	private final JLabel lblNotificaiones = new JLabel("Notificaiones");
	private final JLabel lblObraSocial = new JLabel("Obra Social");
	private final JLabel lblLocalidad = new JLabel("Localidad");
	private final JLabel lblNumAfiliado = new JLabel("Num Afiliado");
	private final JLabel lblDireccin = new JLabel("Direcci\u00F3n");
	private final JLabel lblKmts = new JLabel("KMTS");
	
	
	
	public View(Model model) {
		/*Agregar modelo y observadores*/
		this.model = model;
		model.registerObserver(((Observers)this));
		
		/*Panel*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
	    
	    /*Menu*/
	    create_menu();
		
		/*Panel*/
		create_panel();
		
		/*Tabla*/
		create_tabla();
		
		/*add Clientes*/
		view_clientes();
		
		/*Texto de notificaciones*/
		view_notificaciones();	
	}
	
	/*Metodo que agrega el nombre de las columnas*/
	public void add_Column(String column){
		tabla.addColumn(column);
	}
	
	/*Metodo que agrega filas*/
	public void add_Fila(Object []object){
		tabla.addRow(object);
	}
	
	/*Metodo que limpia la tabla*/
	public void clear_all(){
		tabla.setColumnCount(0);
		tabla.setRowCount(0);
	}
	
	/*Eventos*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Clientes){
			model.print_clientes();
			clientesVisible(true);
		}
		if(e.getSource() == btnAgregar){
				
				lblNotificaiones.setVisible(false);
				Object[] obj = {0,textObraSocial.getText(),textLocalidad.getText(),textNombre.getText(),textApellido.getText(),textNumAfiliado.getText(),
						        textDireccion.getText(), textKMTS.getText(), rdbtnDependencia.isSelected()};
				model.insert_cliente(obj);
		}
	}
	
	public void create_menu(){
		setJMenuBar(menuBar);
		
		menuBar.add(Inicio);
		menuBar.add(Opciones);
		
		Inicio.add(Clientes);
		
		Clientes.addActionListener(this);
	}
	public void create_panel(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void create_tabla(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table = new JTable();	
		table.setModel(tabla);		
		JP = new JScrollPane(table);
		JP.setBounds(0,0,screenSize.width/2, screenSize.height);
		contentPane.add(JP);
	}
	public void view_clientes(){
		contentPane.add(lblNombre);
		lblNombre.setBounds(980, 70, 46, 14);
		lblNombre.setVisible(false);
		
		contentPane.add(lblApellido);
		lblApellido.setBounds(980, 95, 46, 14);
		lblApellido.setVisible(false);
		
		contentPane.add(lblObraSocial);
		lblObraSocial.setBounds(980, 120, 68, 14);
		lblObraSocial.setVisible(false);
		
		contentPane.add(lblLocalidad);
		lblLocalidad.setBounds(980, 145, 68, 14);
		lblLocalidad.setVisible(false);
		
		contentPane.add(lblNumAfiliado);
		lblNumAfiliado.setBounds(980, 170, 74, 14);
		lblNumAfiliado.setVisible(false);
		
		contentPane.add(lblDireccin);
		lblDireccin.setBounds(980, 195, 56, 14);
		lblDireccin.setVisible(false);
		
		contentPane.add(lblKmts);
		lblKmts.setBounds(980, 220, 46, 14);
		lblKmts.setVisible(false);
		
		contentPane.add(textNombre);
		textNombre.setBounds(1057, 67, 86, 20);
		textNombre.setColumns(10);
		textNombre.setVisible(false);
		
		contentPane.add(textApellido);
		textApellido.setBounds(1057, 92, 86, 20);
		textApellido.setColumns(10);
		textApellido.setVisible(false);
		
		contentPane.add(textObraSocial);
		textObraSocial.setBounds(1057, 117, 86, 20);
		textObraSocial.setColumns(10);
		textObraSocial.setVisible(false);
		
		contentPane.add(textLocalidad);
		textLocalidad.setBounds(1057, 142, 86, 20);
		textLocalidad.setColumns(10);
		textLocalidad.setVisible(false);
		
		textNumAfiliado.setBounds(1057, 167, 86, 20);
		contentPane.add(textNumAfiliado);
		textNumAfiliado.setColumns(10);
		textNumAfiliado.setVisible(false);
		
		textDireccion.setBounds(1057, 192, 86, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		textDireccion.setVisible(false);
		
		textKMTS.setBounds(1057, 217, 86, 20);
		contentPane.add(textKMTS);
		textKMTS.setColumns(10);
		textKMTS.setVisible(false);
		
		contentPane.add(btnAgregar);
		btnAgregar.setBounds(980, 296, 89, 23);
		btnAgregar.setVisible(false);
		btnAgregar.addActionListener(this);
		
		contentPane.add(rdbtnDependencia);
		//rdbtnDependencia.setSelected(true);
		rdbtnDependencia.setBounds(1057, 244, 109, 23);
		rdbtnDependencia.setVisible(false);
	}
	public void view_notificaciones(){
		contentPane.add(lblNotificaiones);
		lblNotificaiones.setBounds(1173, 740, 378, 14);
		lblNotificaiones.setVisible(false);
	}
	public void clientesVisible(boolean visible){
		if(visible){
			lblNombre.setVisible(true);
			lblApellido.setVisible(true);
			lblObraSocial.setVisible(true);
			lblLocalidad.setVisible(true);
			lblNumAfiliado.setVisible(true);
			lblDireccin.setVisible(true);
			lblKmts.setVisible(true);
		
			textNombre.setVisible(true);
			textApellido.setVisible(true);
			textObraSocial.setVisible(true);
			textLocalidad.setVisible(true);
			textNumAfiliado.setVisible(true);
			textDireccion.setVisible(true);
			textKMTS.setVisible(true);
		
			rdbtnDependencia.setVisible(true);
		
			btnAgregar.setVisible(true);
		}
		else{
			lblNombre.setVisible(false);
			lblApellido.setVisible(false);
			lblObraSocial.setVisible(false);
			lblLocalidad.setVisible(false);
			lblNumAfiliado.setVisible(false);
			lblDireccin.setVisible(false);
			lblKmts.setVisible(false);
		
			textNombre.setVisible(false);
			textApellido.setVisible(false);
			textObraSocial.setVisible(false);
			textLocalidad.setVisible(false);
			textNumAfiliado.setVisible(false);
			textDireccion.setVisible(false);
			textKMTS.setVisible(false);
		
			rdbtnDependencia.setVisible(false);
		
			btnAgregar.setVisible(false);
		}
	}
}
	
	
