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

@WebServlet(name = "AjoutCompteValidationServlet", urlPatterns = "/AjoutCompteValidationServlet")
public class AjoutCompteValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutCompteValidationServlet() {
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

		RequestDispatcher dispatcher;

		int idClient = Integer.parseInt(request.getParameter("id"));
		Boolean cC = request.getParameter("compteCourant") != null;
		Boolean cE = request.getParameter("compteEpargne") != null;
		ConseillerCompteCRUDService compteCrudService = new ConseillerCompteCRUDService();
		String scc = request.getParameter("soldecc");
		String sce = request.getParameter("soldece");
		double soldecc;
		double soldece;

		if (!scc.equals("")) {
			soldecc = Double.parseDouble(request.getParameter("soldecc"));
		} else {
			soldecc = 0;
		}
		if (!sce.equals("")) {
			soldece = Double.parseDouble(request.getParameter("soldece"));
		} else {
			soldece = 0;
		}

		if (cC) {
			Compte compte1 = new Compte("courant", soldecc);
			compteCrudService.ajout(compte1);
		}
		if (cE) {
			Compte compte2 = new Compte("epargne", soldece);
			compteCrudService.ajout(compte2);
		}

		dispatcher = request.getRequestDispatcher("AjoutCompteServlet");

		dispatcher.forward(request, response);
	}
}