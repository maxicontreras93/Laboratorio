package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TipoDeContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoDeContactoDAO;

public class TipoDeContactoDAOSQL implements TipoDeContactoDAO{

	
	private static final String insert = "INSERT INTO tipocontacto(idTipoContacto, TipoContacto) VALUES(?, ?)";
	private static final String delete = "DELETE FROM tipocontacto WHERE idTipoContacto = ?";
	private static final String readall = "SELECT * FROM tipocontacto";
	
	public boolean insert(TipoDeContactoDTO tcont)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tcont.getIdTipoContacto());
			statement.setString(2, tcont.getTipoContacto());
			if(statement.executeUpdate() > 0) //Si se ejecutÛ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(TipoDeContactoDTO tcont_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(tcont_a_eliminar.getIdTipoContacto()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut√≥ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<TipoDeContactoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoDeContactoDTO> tcont = new ArrayList<TipoDeContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tcont.add(new TipoDeContactoDTO(resultSet.getInt("idTipoContacto"), resultSet.getString("TipoContacto")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tcont;
	}
}
