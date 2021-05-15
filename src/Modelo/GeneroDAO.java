package Modelo;

import Entidades.Genero;
import Util.Conexion;
import Util.GenericDAO;

public class GeneroDAO extends Conexion<Genero> implements GenericDAO<Genero> {

	public GeneroDAO() { 
		 super(Genero.class);
	 }
	
}
