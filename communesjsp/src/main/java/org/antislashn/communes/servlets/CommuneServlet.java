package org.antislashn.communes.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.services.CommunesServices;

/**
 * Servlet implementation class CommuneServlet
 */
@WebServlet("/CommuneServlet")
public class CommuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommunesServices service = (CommunesServices) getServletContext().getAttribute(Constantes.COMMUNE_SERVICE);
		
		String cp = request.getParameter("cp");
		
		String page = "";
		
		if(cp==null || cp.isEmpty()) {
			page = "/index.jsp";
		}
		else
		{
			List<Commune> communes = service.getCommunesByCodePostal(cp);
			request.setAttribute("communes", communes);
			page = "/show-communes.jsp";
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
