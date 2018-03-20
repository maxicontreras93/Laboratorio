/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadesDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoDeContactoDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	@Override
	public PersonaDAO createPersonaDAO() 
	{
				return new PersonaDAOSQL();
	}

	@Override
	public LocalidadesDAO createLocalidadDAO() {

		return new LocalidadesDAOSQL();
	}

	@Override
	public TipoDeContactoDAO createTipoDeContactoDAO() {
	
		return new TipoDeContactoDAOSQL();
	}

}
