package dto;

public class LocalidadesDTO {
	
	private int idLocalidad;
	private String localidad;
	


	public LocalidadesDTO(int idLocalidad,String localidad)
	{
		this.idLocalidad = idLocalidad;
		this.localidad = localidad;
	}
	
	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
