package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadesDTO;

public interface LocalidadesDAO {

	
	public boolean insert(LocalidadesDTO localidad);
	
	public boolean delete(LocalidadesDTO localidad);
	
	public List<LocalidadesDTO> readAll();
}
