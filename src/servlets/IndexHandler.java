package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexHandler")
public class IndexHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String navSelection = request.getParameter("navSelection");
		System.out.println(navSelection);
		if(navSelection.equalsIgnoreCase("profile")){
			request.getRequestDispatcher("views/UserProfile.jsp").forward(request, response);
		} 
		if(navSelection.equalsIgnoreCase("orders")) {
			request.getRequestDispatcher("views/Orders.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("cart")) {
			request.getRequestDispatcher("views/").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("logout")) {
			request.getRequestDispatcher("views/").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void trafficDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
