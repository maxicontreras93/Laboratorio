package presentacion.vista;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.PersonaDTO;
import modelo.Localidades;
import modelo.TipoDeContacto;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import presentacion.controlador.Controlador;

public class VentanaEditar extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JComboBox comboLocalidad;
	private JTextField txtEmail;
	private JDatePanelImpl datePanel;
	private UtilDateModel model;
	private JDatePickerImpl datePicker;
	private JComboBox comboTipoCont;
	
	
	private JButton btnEditarPersona;
	private Controlador controlador;
	private Localidades localidad;
	private TipoDeContacto tcont;

	public VentanaEditar(Controlador controlador, PersonaDTO personaEditar) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 93, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 134, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 175, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 216, 113, 14);
		panel.add(lblDepto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 257, 113, 14);
		panel.add(lblLocalidad);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 298, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblfnac = new JLabel("Fecha de Nacimiento");
		lblfnac.setBounds(10, 339 , 113, 14);
		panel.add(lblfnac);
		
		JLabel lblTipoCont = new JLabel("Tipo De Contacto");
		lblTipoCont.setBounds(10, 380, 113, 14);
		panel.add(lblTipoCont);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		txtNombre.setText(personaEditar.getNombre());
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		txtTelefono.setText(personaEditar.getTelefono());
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 90, 164, 20 );
		txtCalle.setText(personaEditar.getCalle());
		panel.add(txtCalle);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(133, 131, 164, 20);
		txtAltura.setText(personaEditar.getAltura());
		panel.add(txtAltura);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(133, 172, 164, 20);
		txtPiso.setText(personaEditar.getPiso());
		panel.add(txtPiso);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(133, 213, 164, 20);
		txtDepto.setText(personaEditar.getDepto());
		panel.add(txtDepto);

		comboLocalidad = new JComboBox(controlador.getLocalidades());
		comboLocalidad.setBounds(133, 254, 164, 20);
		comboLocalidad.setSelectedItem(personaEditar.getLocalidad());
		panel.add(comboLocalidad);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 295, 164, 20);
		txtEmail.setText(personaEditar.getEmail());
		panel.add(txtEmail);
		
		model = new UtilDateModel();
		model.setValue(personaEditar.getFnac());
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(133, 336, 164, 20);
		panel.add(datePicker);
		
		
		comboTipoCont = new JComboBox(controlador.getTipoContacto());
		comboTipoCont.setBounds(133, 377, 164, 20);
		comboTipoCont.setSelectedItem(personaEditar.getTcont());
		panel.add(comboTipoCont);
		
		btnEditarPersona = new JButton("Editar");
		btnEditarPersona.addActionListener(this.controlador);
		btnEditarPersona.setBounds(208, 418, 89, 23);
		panel.add(btnEditarPersona);
		
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtCalle()
	{
		return txtCalle;
	}
	
	public JTextField getTxtAltura()
	{
		return txtAltura;
	}
	
	public JTextField getTxtPiso()
	{
		return txtPiso;
	}
	
	public JTextField getTxtDepto()
	{
		return txtDepto;
	}
	
	public JTextField getTxtEmail()
	{
		return txtEmail;
	}

	public JButton getBtnEditarPersona() 
	{
		return btnEditarPersona;
	}
		
	public JComboBox getLocalidad()
	{
		return comboLocalidad;
	}
	
	public JComboBox getTipoCont()
	{
		return comboTipoCont;
	}
	
	public JDatePickerImpl getFecha()
	{
		return datePicker;
	}
	
}

