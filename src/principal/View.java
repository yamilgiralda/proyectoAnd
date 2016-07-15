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


public class View extends JFrame implements ActionListener, Observers {
	Model model;
	
	/*Panel*/
	private JPanel contentPane;
	
	/*Tabla*/
	private JTable table;
	private JScrollPane JP;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	/*Menu*/
	JMenuBar menuBar = new JMenuBar();
	
	JMenu Inicio = new JMenu("Inicio");
	JMenu Opciones = new JMenu("Opciones");
	
	JMenuItem Clientes = new JMenuItem("Clientes");
	
	public View(Model model) {
		/*Agregar modelo y observadores*/
		this.model = model;
		model.registerObserver(((Observers)this));
		
		/*Panel*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		
	    /*Menu*/  
		setJMenuBar(menuBar);
		
		menuBar.add(Inicio);
		menuBar.add(Opciones);
		
		Inicio.add(Clientes);
		
		Clientes.addActionListener(this);
		
		/*Panel*/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Tabla*/
		table = new JTable();	
		table.setModel(modelo);		
		JP = new JScrollPane(table);
		JP.setBounds(0,0,screenSize.width/2, screenSize.height);
		contentPane.add(JP);
	}
	
	/*Metodo que agrega el nombre de las columnas*/
	public void add_Column(String column){
		modelo.addColumn(column);
	}
	
	/*Metodo que agrega filas*/
	public void add_Fila(Object []object){
		modelo.addRow(object);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Clientes){
			model.get_clientes();
		}
	}
}
	
	
