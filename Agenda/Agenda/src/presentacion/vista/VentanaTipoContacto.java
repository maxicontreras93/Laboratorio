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

public class VentanaTipoContacto extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaTipoContacto;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JTextField txtTcon;
	private String[] nombreColumnas = {"Tipo De Contacto"};
	private DefaultTableModel modelTipoContacto;
	
	private Controlador controlador;
	
	public VentanaTipoContacto(Controlador controlador)
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
		
		JScrollPane spTipoContacto = new JScrollPane();
		spTipoContacto.setBounds(10, 11, 280, 182);
		panel.add(spTipoContacto);
		
		modelTipoContacto = new DefaultTableModel(null,nombreColumnas);
		tablaTipoContacto = new JTable(modelTipoContacto);
		
		tablaTipoContacto.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaTipoContacto.getColumnModel().getColumn(0).setResizable(false);
		spTipoContacto.setViewportView(tablaTipoContacto);
		
		JLabel lblagregar = new JLabel("Insertar Localidad");
		lblagregar.setBounds(10, 200, 108, 23);
		panel.add(lblagregar);
		
		txtTcon = new JTextField();
		txtTcon.setBounds(10, 220, 89, 23 );
		panel.add(txtTcon);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this.controlador);
		btnAgregar.setBounds(110, 220, 89, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this.controlador);
		btnBorrar.setBounds(208, 220, 89, 23);
		panel.add(btnBorrar);
		
		this.setVisible(true);
				
	}
	public DefaultTableModel getModelTipoContacto() 
	{
		return modelTipoContacto;
	}
	
	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public JButton getBtnAgregarTipoContacto()
	{
		return btnAgregar;
	}
	
	public JTextField getTxtTcon()
	{
		return txtTcon;
	}
	
	public JButton getBtnBorrarTipoContacto()
	{
		return btnBorrar;
	}
	
	public JTable getTablaTipoContacto()
	{
		return tablaTipoContacto;
	}
	
	public boolean getVisible()
	{
		return this.getVisible();
	}
	
	
}
