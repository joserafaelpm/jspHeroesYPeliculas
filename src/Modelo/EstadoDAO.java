package Modelo;

import Entidades.Estado;
import Util.Conexion;
import Util.GenericDAO;

public class EstadoDAO extends Conexion<Estado> implements GenericDAO<Estado> {
	
	public EstadoDAO() { 
		 super(Estado.class);
	 }

}
