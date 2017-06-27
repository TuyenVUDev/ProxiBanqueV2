package fr.gtm.proxibanque.presentation;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import javassist.expr.Cast;

import java.io.IOException;


/**
 * Servlet implementation class MaServlet
 */


@WebServlet(name="ModificationClientServlet", urlPatterns = "/ModificationClientServlet" )
public class ModificationClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	public void traitement(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		
		int idClient = Integer.parseInt(request.getParameter("id"));
		
		
		ConseillerClientCRUDService ccCRUD = new ConseillerClientCRUDService();
		Client client = ccCRUD.lireById(idClient);
	
		HttpSession session = request.getSession();
		session.setAttribute("client", client);
	

		
		dispatcher=request.getRequestDispatcher("ModificationClient.jsp");
	
		
		dispatcher.forward(request,response);
	}
}