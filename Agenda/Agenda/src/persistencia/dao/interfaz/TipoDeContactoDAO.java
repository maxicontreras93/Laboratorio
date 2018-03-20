package persistencia.dao.interfaz;

import java.util.List;

import dto.TipoDeContactoDTO;

public interface TipoDeContactoDAO {
	
	public boolean insert(TipoDeContactoDTO tipoContacto);
	
	public boolean delete(TipoDeContactoDTO tipoContacto);
	
	public List<TipoDeContactoDTO> readAll();
}
