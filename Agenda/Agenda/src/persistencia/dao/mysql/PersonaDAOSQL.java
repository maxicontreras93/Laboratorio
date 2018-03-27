package persistencia.dao.mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, calle, altura, piso, depto, localidad , email, fnac, tcont) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas ORDER BY localidad";
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getCalle());
			statement.setString(5, persona.getAltura());
			statement.setString(6, persona.getPiso());
			statement.setString(7, persona.getDepto());
			statement.setString(8, persona.getLocalidad());
			statement.setString(9, persona.getEmail());
			statement.setDate(10, (Date) persona.getFnac());
			statement.setString(11, persona.getTcont());
			if(statement.executeUpdate() > 0) //Si se ejecutÛ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),
						resultSet.getString("Calle"), resultSet.getString("Altura"), resultSet.getString("Piso"), resultSet.getString("Depto"),
						resultSet.getString("Localidad"), resultSet.getString("Email"), resultSet.getDate("Fnac"), resultSet.getString("Tcont")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	public PersonaDTO readOne(PersonaDTO persona_a_leer) 
	{
		PersonaDTO persona = null;
		Statement stmt = null;
		Conexion conexion = Conexion.getConexion();
		try {
			stmt = (Statement) conexion.getSQLConexion().createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT  * FROM personas WHERE idPersona =="+persona_a_leer.getIdPersona());
			persona = new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),
					resultSet.getString("Calle"), resultSet.getString("Altura"), resultSet.getString("Piso"), resultSet.getString("Depto"),
					resultSet.getString("Localidad"), resultSet.getString("Email"), resultSet.getDate("Fnac"), resultSet.getString("Tcont"));	
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persona;
	}


}