package fr.gtm.proxibanque.presentation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.AuthentificationService;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;
import fr.gtm.proxibanque.service.GerantCRUDService;

import java.io.IOException;

/**
 * Servlet implementation class MaServlet
 */

@WebServlet(name = "AuthentificationServlet", urlPatterns = "/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		GerantCRUDService gerantCRUDService= new GerantCRUDService();
		

		RequestDispatcher dispatcher;

		AuthentificationService authentificationService = new AuthentificationService();
		
		boolean authentification = false;
		boolean rep = authentificationService.authentification(login, password);
		HttpSession session = request.getSession();
	
		int idConseiller=gerantCRUDService.lire().stream().filter(c -> c.getLogin().equals(login)).map(c -> c.getId()).findAny().get();
		session.setAttribute("idConseiller", idConseiller);
		
		if (rep == true) {
			dispatcher = request.getRequestDispatcher("ListeClientsServlet");
			System.out.println("authentification ok");
			authentification=true;
			session.setAttribute("authentification", authentification);

		} else {
			dispatcher = request.getRequestDispatcher("indexEchoue.html");
			System.out.println("authentification échouée");
		}

		dispatcher.forward(request, response);
	}
}