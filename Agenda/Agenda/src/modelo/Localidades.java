package modelo;

import java.util.List;

import dto.LocalidadesDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadesDAO;

public class Localidades {
	
	private LocalidadesDAO localidades;
	
	public Localidades(DAOAbstractFactory metodo_persistencia)
	{
		this.localidades = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarLocalidad(LocalidadesDTO nuevaLocalidad)
	{
		this.localidades.insert(nuevaLocalidad);
	}
	
	public void borrarLocalidad(LocalidadesDTO localidad_a_eliminar)
	{
		this.localidades.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadesDTO> obtenerLocalidades()
	{
		return this.localidades.readAll();
	}
}
