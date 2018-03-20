package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import presentacion.controlador.Controlador;

public class VentanaLocalidades extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLocalidades;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JTextField txtLoca;
	private String[] nombreColumnas = {"Localidad"};
	private DefaultTableModel modelLocalidades;
	
	private Controlador controlador;
	
	
	public VentanaLocalidades(Controlador controlador)
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 280, 182);
		panel.add(spLocalidades);
		
		modelLocalidades = new DefaultTableModel(null,nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidades);
		
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
		spLocalidades.setViewportView(tablaLocalidades);
		
		JLabel lblagregar = new JLabel("Insertar Localidad");
		lblagregar.setBounds(10, 200, 108, 23);
		panel.add(lblagregar);
		
		txtLoca = new JTextField();
		txtLoca.setBounds(10, 220, 89, 23 );
		panel.add(txtLoca);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this.controlador);
		btnAgregar.setBounds(110, 220, 89, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(controlador);
		btnBorrar.setBounds(208, 220, 89, 23);
		panel.add(btnBorrar);
		
		
		this.setVisible(true);
	}
	
	public DefaultTableModel getModelLocalidades() 
	{
		return modelLocalidades;
	}
	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregar;
	}
	
	public JButton getBtnBorrarLocalidad()
	{
		return btnBorrar;
	}
	
	public JTextField getTextLoca()
	{
		return txtLoca;
	}
	
	public JTable getTablaLocalidades()
	{
		return tablaLocalidades;
	}
	
}
