package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Heroe;

public class HeroeDAO extends Conexion<Heroe> implements GenericDAO<Heroe> {
 
	 public HeroeDAO() { 
		 super(Heroe.class);
	 }
}