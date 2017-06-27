package fr.gtm.proxibanque.presentation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;

import java.io.IOException;

/**
 * Servlet implementation class MaServlet
 */

@WebServlet(name = "SupprimerClientServlet", urlPatterns = "/SupprimerClientServlet")
public class SupprimerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerClientServlet() {
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

		String id = request.getParameter("id");
		int idClient = Integer.parseInt(id);

		RequestDispatcher dispatcher;
		ConseillerClientCRUDService clientCrudService = new ConseillerClientCRUDService();
		boolean rep = clientCrudService.suppression(idClient);

		dispatcher = request.getRequestDispatcher("ListeClientsServlet");

		dispatcher.forward(request, response);
	}
}