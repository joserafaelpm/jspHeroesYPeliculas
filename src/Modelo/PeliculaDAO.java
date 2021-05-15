package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Pelicula;

public class PeliculaDAO extends Conexion<Pelicula> implements GenericDAO<Pelicula> {
 
	 public PeliculaDAO() { 
		 super(Pelicula.class);
	 }
}