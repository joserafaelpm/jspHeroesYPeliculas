package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Estado;
import Entidades.Genero;
import Entidades.Heroe;
import Modelo.EstadoDAO;
import Modelo.GeneroDAO;
import Modelo.HeroeDAO;

@WebServlet("/HeroesServlet/*")
public class HeroesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HeroeDAO hDAO;
	private GeneroDAO gDAO;
	private EstadoDAO esDAO;
	public HeroesServlet() {
		super();
		hDAO = new HeroeDAO();
		gDAO = new GeneroDAO();
		esDAO = new EstadoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "mostrar":
			this.showForm(request, response);
			break;
			/*	case "/buscar":
			this.buscar(request, response);
			break;	 */
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) { 
		case "buscar":
			this.buscar(request, response);
			break; 	
		case "registrar":
			this.registrar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		default:
			break;
		}
	}

//Metodos

	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String nombre = request.getParameter("nombre");
		String heroe = request.getParameter("heroe");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String fechaAparicion = request.getParameter("fechaAparicion");
		String genero= request.getParameter("genero");
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		String arma = request.getParameter("arma");
		Heroe he = new Heroe();
		Genero generoX = gDAO.find(genero);
		Estado estadoX = esDAO.find(estado);
		he.setNombre(nombre);
		he.setHeroe(heroe);
		he.setGeneroBean(generoX);
		he.setEstadoBean(estadoX);
		he.setDescripcion(descripcion);
		he.setArma(arma);
	
	//	he.setFechanacimiento(fechaNacimiento);
	//	he.setFechaaparicion(fechaAparicion);
		try {
			he.setFechanacimiento(sd.parse(fechaNacimiento));
			he.setFechaaparicion(sd.parse(fechaAparicion));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// eDAO.update(obj);
		hDAO.insert(he);
		request.getRequestDispatcher("registroHeroes.jsp").forward(request, response);
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Heroe he = new Heroe();
		he.setId(id);
		Heroe aux = hDAO.find(he.getId());
	    System.out.println(aux.getId());
		request.getSession().setAttribute("heroe", aux);
		request.getRequestDispatcher("registroHeroes.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Heroe he = new Heroe();
		Heroe aux = hDAO.find(id);
		he.setId(id);
		hDAO.delete(aux);
		request.getRequestDispatcher("listaHeroes.jsp").forward(request, response);
	}
	
	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String nombre = request.getParameter("nombre");
		String heroe = request.getParameter("heroe");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String fechaAparicion = request.getParameter("fechaAparicion");
		String genero= request.getParameter("genero");
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		String arma = request.getParameter("arma");
		Heroe he = new Heroe();
		Genero generoX = gDAO.find(genero);
		Estado estadoX = esDAO.find(estado);
		he.setId(id);
		he.setNombre(nombre);
		he.setHeroe(heroe);
		he.setGeneroBean(generoX);
		he.setEstadoBean(estadoX);
		he.setDescripcion(descripcion);
		he.setArma(arma);
		try {
			he.setFechanacimiento(sd.parse(fechaNacimiento));
			he.setFechaaparicion(sd.parse(fechaAparicion));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// eDAO.update(obj);
		hDAO.update(he);
		request.getRequestDispatcher("listaHeroes.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Heroe he = new Heroe();
		he.setId(id);
		Heroe aux = hDAO.find(he.getId());
	    System.out.println(aux.getId());
		request.getSession().setAttribute("heroe", aux);
		request.getRequestDispatcher("registroHeroes.jsp").forward(request, response);
			//	response.sendRedirect("registroEmpleado.jsp");
	}

}
