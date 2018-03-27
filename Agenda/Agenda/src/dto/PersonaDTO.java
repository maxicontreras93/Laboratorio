package dto;

import java.sql.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private String localidad;
	private String email;
	private Date fnac;
	private String tcont;
	private char inicial;
	
	public PersonaDTO(int idPersona, String nombre, String telefono, String calle, String altura, String piso, String depto,
			String localidad, String email, Date fnac, String tcont)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.localidad = localidad;
		this.email = email;
		this.fnac = fnac;
		this.tcont = tcont;
		setInicial();
	}
	
	public String getTcont() {
		return tcont;
	}

	public void setTcont(String tcont) {
		this.tcont = tcont;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public char getInicial() {
		return inicial;
	}

	public void setInicial() {
		this.inicial = this.nombre.charAt(0);
	}

	
	
}
