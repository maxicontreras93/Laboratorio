package persistencia.dao.interfaz;


public interface DAOAbstractFactory 
{
	public PersonaDAO createPersonaDAO();
	public LocalidadesDAO createLocalidadDAO();
	public TipoDeContactoDAO createTipoDeContactoDAO();
}
