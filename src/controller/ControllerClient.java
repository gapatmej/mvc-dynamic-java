package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Client;
import services.ServiceClient;

/**
 * Servlet implementation class ControllerClient
 */
@WebServlet("/ControllerClient")
public class ControllerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceClient serviceClient = new ServiceClient();
		String action = request.getParameter("action");
		RequestDispatcher requestDispatcher = null;
		int idClient =0;
		try {
			switch (action) {
			case "list":
				requestDispatcher = request.getRequestDispatcher("pages/client/list.jsp");
				request.setAttribute("clients", serviceClient.findAll());
				break;
			case "client":
				requestDispatcher = request.getRequestDispatcher("pages/client/client.jsp");
				request.setAttribute("client", new Client());
				break;
			case "create":
				requestDispatcher = request.getRequestDispatcher("ControllerClient?action=list");
				serviceClient.create(getClientRequest(request));
				break;
			case "update":
				requestDispatcher = request.getRequestDispatcher("ControllerClient?action=list");
				serviceClient.update(getClientRequest(request));
				break;
			case "edit":
				idClient = Integer.valueOf(request.getParameter("idClient"));
				requestDispatcher = request.getRequestDispatcher("pages/client/client.jsp");
				request.setAttribute("client", serviceClient.findById(idClient));
				break;
			case "delete":
				idClient = Integer.valueOf(request.getParameter("idClient"));
				requestDispatcher = request.getRequestDispatcher("ControllerClient?action=list");
				serviceClient.delete(idClient);
				break;
			case "search":
				String word = request.getParameter("word");
				requestDispatcher = request.getRequestDispatcher("pages/client/list.jsp");
				request.setAttribute("clients", serviceClient.search(word));
				break;
			default:
				requestDispatcher = request.getRequestDispatcher("ControllerClient?action=list");
				break;
			}
			
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			requestDispatcher = request.getRequestDispatcher("ControllerClient?action=list");
		}
		requestDispatcher.forward(request, response);
	}
	
	private Client getClientRequest(HttpServletRequest request) {
		return new Client(Integer.valueOf(request.getParameter("idClient")),
				request.getParameter("name"),
				request.getParameter("lastName"),
				Integer.valueOf(request.getParameter("age")),
				Date.valueOf(request.getParameter("dateBirth")),
				request.getParameter("email"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
