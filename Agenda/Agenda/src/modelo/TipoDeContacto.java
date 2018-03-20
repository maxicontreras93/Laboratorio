package modelo;

import java.util.List;

import dto.TipoDeContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.TipoDeContactoDAO;

public class TipoDeContacto {
	
	private TipoDeContactoDAO tipoContacto;
	
	public TipoDeContacto(DAOAbstractFactory metodo_persistencia)
	{
		this.tipoContacto = metodo_persistencia.createTipoDeContactoDAO();
	}
	
	public void agregarTipoDeContacto(TipoDeContactoDTO nuevoTipoContacto)
	{
		this.tipoContacto.insert(nuevoTipoContacto);
	}
	
	public void borrarTipoContacto(TipoDeContactoDTO tipocontacto_a_borrar)
	{
		this.tipoContacto.delete(tipocontacto_a_borrar);
	}
	
	public List<TipoDeContactoDTO> obtenerTipoDeContacto()
	{
		return this.tipoContacto.readAll();
	}
}
