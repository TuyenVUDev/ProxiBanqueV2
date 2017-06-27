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

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class MaServlet
 */


@WebServlet(name="ListeClientsServlet", urlPatterns = "/ListeClientsServlet" )
public class ListeClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * x     * @see HttpServlet#HttpServlet()
     */
    public ListeClientsServlet() {
        super();
    }

	/**
	 * Servlet permettant d'instancier la liste de client du conseiller connecté.
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
		
		ConseillerClientCRUDService clientCrudService = new ConseillerClientCRUDService();
		List<Client> LC = clientCrudService.lire(1);
		
		for(Client client:LC){
			System.out.println(client);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("ListSH", LC);
		//request.setAttribute("ListeClients", ListeClients);

		
		dispatcher=request.getRequestDispatcher("ListeClients.jsp");
		
		dispatcher.forward(request,response);
	}
}