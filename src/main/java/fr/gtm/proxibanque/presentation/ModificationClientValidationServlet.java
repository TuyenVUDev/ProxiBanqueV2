package fr.gtm.proxibanque.presentation;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import javassist.expr.Cast;

import java.io.IOException;


/**
 * Servlet implementation class MaServlet
 */


@WebServlet(name="ModificationClientValidationServlet", urlPatterns = "/ModificationClientValidationServlet" )
public class ModificationClientValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationClientValidationServlet() {
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

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		int idClient = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher dispatcher;
		ConseillerClientCRUDService clientCrudService = new ConseillerClientCRUDService();
		Client clientModifie = new Client(nom, prenom, adresse, email, 1);
		boolean rep=clientCrudService.modification(idClient, clientModifie);

		if (rep==true){
			dispatcher=request.getRequestDispatcher("ListeClientsServlet");
		}else{
			dispatcher=request.getRequestDispatcher("ListeClientsServlet");
		}
		
		dispatcher.forward(request,response);
	}
}