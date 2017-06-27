package fr.gtm.proxibanque.presentation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.xml.crypto.Data;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import fr.gtm.proxibanque.domain.Client;
import fr.gtm.proxibanque.service.ConseillerClientCRUDService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MaServlet
 */
public class ListeClientServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeClientServlet2() {
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
		HttpSession maSession = request.getSession();
		ConseillerClientCRUDService conseillerClientCRUDService= new ConseillerClientCRUDService();
		ArrayList<Client> listeClients= conseillerClientCRUDService.lire(1);
		System.out.println(listeClients);
		if (listeClients != null) {
			maSession.setAttribute("listeClients", listeClients);
			dispatcher = request.getRequestDispatcher("ListeClients2.jsp");
		}else{
			dispatcher = request.getRequestDispatcher("ListeClients2.jsp");
		}
	
		dispatcher.forward(request, response);
	}
}