package main;

import modelo.Agenda;
import modelo.Localidades;
import modelo.TipoDeContacto;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Localidades local = new Localidades(new DAOSQLFactory());
		TipoDeContacto tcont = new TipoDeContacto(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo, local, tcont);
		controlador.inicializar();
	}
}
