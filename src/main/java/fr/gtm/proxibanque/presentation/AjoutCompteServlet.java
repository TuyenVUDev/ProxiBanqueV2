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

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class MaServlet
 */


@WebServlet(name="AjoutCompteServlet", urlPatterns = "/AjoutCompteServlet" )
public class AjoutCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCompteServlet() {
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
		
		RequestDispatcher dispatcher;
		
		ConseillerCompteCRUDService compteCrudService = new ConseillerCompteCRUDService();
		List<Compte> ListeCompte = compteCrudService.lire();
		
		for(Compte compte:ListeCompte){
			System.out.println(compte);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("ListeCompte", ListeCompte);

		dispatcher=request.getRequestDispatcher("CreationCompte.jsp");
	
		
		dispatcher.forward(request,response);
	}
}