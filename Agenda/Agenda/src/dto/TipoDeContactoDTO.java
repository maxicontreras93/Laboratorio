package dto;

public class TipoDeContactoDTO {
	
	
	private int idTipoContacto;
	private String TipoContacto;
	

	public TipoDeContactoDTO(int idTipoContacto, String TipoContacto)
	{
		this.idTipoContacto = idTipoContacto;
		this.TipoContacto = TipoContacto;
	}
	
	public int getIdTipoContacto() {
		return idTipoContacto;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public String getTipoContacto() {
		return TipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		TipoContacto = tipoContacto;
	}
}
