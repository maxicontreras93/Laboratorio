package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import modelo.Localidades;
import modelo.TipoDeContacto;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditar;
import presentacion.vista.VentanaLocalidades;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipoContacto;
import presentacion.vista.Vista;
import dto.LocalidadesDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private List<LocalidadesDTO> localidades_en_tabla;
		private List<TipoDeContactoDTO> tcontacto_en_tabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		private Localidades localidades;
		private TipoDeContacto tipoContacto;
		private VentanaEditar ventanaEditar;
		private VentanaLocalidades ventanaLocalidades;
		private VentanaTipoContacto ventanaTipoContacto;

		
		public Controlador(Vista vista, Agenda agenda, Localidades localidades, TipoDeContacto tipoContacto)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnLocalidades().addActionListener(this);
			this.vista.getBtnTipoContacto().addActionListener(this);
			this.agenda = agenda;
			this.localidades = localidades;
			this.tipoContacto = tipoContacto;
			this.personas_en_tabla = null;
			this.localidades_en_tabla = null;
			this.tcontacto_en_tabla = null;
		
		}
		
		public void inicializar()
		{
			this.llenarTabla();
			this.vista.show();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),
						this.personas_en_tabla.get(i).getCalle(), this.personas_en_tabla.get(i).getAltura(),
						this.personas_en_tabla.get(i).getPiso(), this.personas_en_tabla.get(i).getDepto(),
						this.personas_en_tabla.get(i).getLocalidad(), this.personas_en_tabla.get(i).getEmail(),
						this.personas_en_tabla.get(i).getFnac(), this.personas_en_tabla.get(i).getTcont()};
				this.vista.getModelPersonas().addRow(fila);
			}			
		}
		
		private void llenarTablaLocalidades()
		{
			this.ventanaLocalidades.getModelLocalidades().setRowCount(0);
			this.ventanaLocalidades.getModelLocalidades().setColumnCount(0);
			this.ventanaLocalidades.getModelLocalidades().setColumnIdentifiers(this.ventanaLocalidades.getNombreColumnas());
			
			this.localidades_en_tabla = localidades.obtenerLocalidades();
			for(int i=0; i<this.localidades_en_tabla.size();i++)
			{
				Object[] fila = {this.localidades_en_tabla.get(i).getLocalidad()};
				this.ventanaLocalidades.getModelLocalidades().addRow(fila);
			}
		}
		private void llenarTablaTipoContacto()
		{
			this.ventanaTipoContacto.getModelTipoContacto().setRowCount(0);
			this.ventanaTipoContacto.getModelTipoContacto().setColumnCount(0);
			this.ventanaTipoContacto.getModelTipoContacto().setColumnIdentifiers(this.ventanaTipoContacto.getNombreColumnas());
			
			this.tcontacto_en_tabla = this.tipoContacto.obtenerTipoDeContacto();
			for(int i=0; i<this.tcontacto_en_tabla.size();i++)
			{
				Object[] fila = {this.tcontacto_en_tabla.get(i).getTipoContacto()};
				this.ventanaTipoContacto.getModelTipoContacto().addRow(fila);
			}
			
			
		}
		public String[] getLocalidades()
		{
			List<LocalidadesDTO> local = localidades.obtenerLocalidades();
			String[] obtener = new String[local.size()] ;
			
			for(int i=0; i<local.size();i++)
			{
				obtener[i] = local.get(i).getLocalidad();
				
			}

			return obtener;

			
		}
		
		public String[] getTipoContacto()
		{
			List<TipoDeContactoDTO> tcont = tipoContacto.obtenerTipoDeContacto();
			String[] obtener = new String[tcont.size()];
			for(int i=0; i<tcont.size();i++)
			{
				obtener[i] = tcont.get(i).getTipoContacto();
				
			}
			return obtener;
		}

		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
			}
			else if(e.getSource() == this.vista.getBtnEditar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.ventanaEditar = new VentanaEditar(this ,this.personas_en_tabla.get(fila));
				}
			}
			else if (e.getSource() == this.vista.getBtnLocalidades())
			{
				
				this.ventanaLocalidades = new VentanaLocalidades(this);
				llenarTablaLocalidades();
			}
			
			else if (e.getSource() == this.vista.getBtnTipoContacto())
			{
				this.ventanaTipoContacto = new VentanaTipoContacto(this);
				llenarTablaTipoContacto();
			}
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
				
			}
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			else if (this.ventanaLocalidades != null)
			{
				if (e.getSource()  == this.ventanaLocalidades.getBtnAgregarLocalidad()) {
				LocalidadesDTO nuevaLocalidad = new LocalidadesDTO(0, this.ventanaLocalidades.getTextLoca().getText());
				this.localidades.agregarLocalidad(nuevaLocalidad);
				this.llenarTablaLocalidades();
				this.ventanaLocalidades.dispose();
				this.ventanaLocalidades = null;
				}
				else if (e.getSource() == this.ventanaLocalidades.getBtnBorrarLocalidad())
				{
					int[] filas_seleccionadas = this.ventanaLocalidades.getTablaLocalidades().getSelectedRows();
					for (int fila:filas_seleccionadas)
					{
						this.localidades.borrarLocalidad(this.localidades_en_tabla.get(fila));
					}
					this.llenarTablaLocalidades();
					this.ventanaLocalidades.dispose();
					this.ventanaLocalidades = null;
				}
			}
			

			else if (this.ventanaTipoContacto != null) { 
				if (e.getSource() == this.ventanaTipoContacto.getBtnBorrarTipoContacto())
			{
				int[] filas_seleccionadas = this.ventanaTipoContacto.getTablaTipoContacto().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.tipoContacto.borrarTipoContacto(this.tcontacto_en_tabla.get(fila));
				}
				this.llenarTablaTipoContacto();
				this.ventanaTipoContacto.dispose();
				this.ventanaTipoContacto = null;
			}
				else if (e.getSource() == this.ventanaTipoContacto.getBtnAgregarTipoContacto())
				{
				TipoDeContactoDTO nuevoTipoContacto = new TipoDeContactoDTO(0, this.ventanaTipoContacto.getTxtTcon().getText());
				this.tipoContacto.agregarTipoDeContacto(nuevoTipoContacto);
				this.llenarTablaTipoContacto();
				this.ventanaTipoContacto.dispose();
				this.ventanaTipoContacto = null;
				}
			}
			else if (this.ventanaEditar != null) {
				if(e.getSource() == this.ventanaEditar.getBtnEditarPersona())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				String local = (String) this.ventanaEditar.getLocalidad().getSelectedItem();
				String tcont = (String) this.ventanaEditar.getTipoCont().getSelectedItem();
				java.util.Date utilStartDate = (java.util.Date) ventanaEditar.getFecha().getModel().getValue();
				java.sql.Date date = new java.sql.Date(utilStartDate.getTime());
				PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaEditar.getTxtNombre().getText(), ventanaEditar.getTxtTelefono().getText(),
						ventanaEditar.getTxtCalle().getText(), ventanaEditar.getTxtAltura().getText(), ventanaEditar.getTxtPiso().getText(),
						ventanaEditar.getTxtDepto().getText(), local, ventanaEditar.getTxtEmail().getText(), date, tcont);
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaEditar.dispose();
				this.ventanaEditar = null;
				
			}
			}

			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				String local = (String) this.ventanaPersona.getLocalidad().getSelectedItem();
				String tcont = (String) this.ventanaPersona.getTipoCont().getSelectedItem();
				java.util.Date utilStartDate = (java.util.Date) ventanaPersona.getFecha().getModel().getValue();
				java.sql.Date date = new java.sql.Date(utilStartDate.getTime());
				PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(),
						ventanaPersona.getTxtCalle().getText(), ventanaPersona.getTxtAltura().getText(), ventanaPersona.getTxtPiso().getText(),
						ventanaPersona.getTxtDepto().getText(), local, ventanaPersona.getTxtEmail().getText(), date, tcont);
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
			}
			

			

			
		}

}
