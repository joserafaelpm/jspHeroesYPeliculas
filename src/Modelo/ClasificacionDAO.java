package Modelo;

import Entidades.Clasificacion;
import Util.Conexion;
import Util.GenericDAO;

public class ClasificacionDAO extends Conexion<Clasificacion> implements GenericDAO<Clasificacion> {

	public ClasificacionDAO() { 
		 super(Clasificacion.class);
	 }
}
