package fr.gtm.proxibanque.presentation;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.domain.Compte;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import fr.gtm.proxibanque.service.ConseillerCompteCRUDService;
import fr.gtm.proxibanque.service.ConseillerService;

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class MaServlet
 */


@WebServlet(name="RelierCompteClientServlet", urlPatterns = "/RelierCompteClientServlet" )
public class RelierCompteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelierCompteClientServlet() {
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

		int idClient = Integer.parseInt(request.getParameter("id"));
		int idCompte = Integer.parseInt(request.getParameter("idC"));
		
		RequestDispatcher dispatcher;
		
		ConseillerService conseillerService = new ConseillerService();
		conseillerService.associationCompte(idCompte, idClient);
		
		
		dispatcher=request.getRequestDispatcher("ListeClientsServlet");
	
		
		dispatcher.forward(request,response);
	}
}