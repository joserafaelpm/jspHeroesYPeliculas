package Controlador;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Clasificacion;
import Entidades.Pelicula;
import Modelo.ClasificacionDAO;
import Modelo.PeliculaDAO;

@WebServlet("/PeliculaServlet/*")
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeliculaDAO pDAO;
	private ClasificacionDAO cDAO;
    
    public PeliculaServlet() {
        super();
        pDAO = new PeliculaDAO();
        cDAO = new ClasificacionDAO();
    }


    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
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
			String nombre = request.getParameter("nombre");
		BigDecimal anolanzamiento = new  BigDecimal(request.getParameter("anolanzamiento"))  ;
			BigDecimal anosecuencia = new  BigDecimal(request.getParameter("anosecuencia"));
			String sinopsis = request.getParameter("sinopsis");
			String clasificacionBean = request.getParameter("clasificacionBean");
			Pelicula pe = new Pelicula();
			Clasificacion clasi = cDAO.find(clasificacionBean);
			pe.setNombre(nombre);
			pe.setAnolanzamiento(anolanzamiento);
			pe.setAnosecuencia(anosecuencia);
			pe.setSinopsis(sinopsis);
			pe.setClasificacionBean(clasi);
			// eDAO.update(obj);
			pDAO.insert(pe);
			request.getRequestDispatcher("registrarPelicula.jsp").forward(request, response);
		}
		
		protected void buscar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id")); 
			Pelicula pe = new Pelicula();
			pe.setId(id);
			Pelicula aux = pDAO.find(pe.getId());
		    System.out.println(aux.getId());
			request.getSession().setAttribute("pelicula", aux);
			request.getRequestDispatcher("registrarPelicula.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado");
		}
		
		protected void eliminar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Pelicula pe = new Pelicula();
			Pelicula aux = pDAO.find(id);
			pe.setId(id);
			pDAO.delete(aux);
			request.getRequestDispatcher("listaPelicula.jsp").forward(request, response);
		}
		
		protected void actualizar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));			
			String nombre = request.getParameter("nombre");
			BigDecimal anolanzamiento = new  BigDecimal(request.getParameter("anolanzamiento"))  ;
			BigDecimal anosecuencia = new  BigDecimal(request.getParameter("anosecuencia"));
			String sinopsis = request.getParameter("sinopsis");
			String clasificacionBean = request.getParameter("clasificacionBean");
			Pelicula pe = new Pelicula();
			Clasificacion clasi = cDAO.find(clasificacionBean);
			pe.setId(id);
			pe.setNombre(nombre);
			pe.setAnolanzamiento(anolanzamiento);
			pe.setAnosecuencia(anosecuencia);
			pe.setSinopsis(sinopsis);
			pe.setClasificacionBean(clasi);
			// eDAO.update(obj);
			pDAO.update(pe);
			request.getRequestDispatcher("listaPelicula.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
					Integer id =Integer.parseInt(request.getParameter("id"));
					Pelicula pe = new Pelicula();
					pe.setId(id);
					Pelicula aux = pDAO.find(pe.getId());
					request.getSession().setAttribute("pelicula", aux);
					request.getRequestDispatcher("registrarPelicula.jsp").forward(request, response);
				//	response.sendRedirect("registroEmpleado.jsp");
		}
	
	
}
