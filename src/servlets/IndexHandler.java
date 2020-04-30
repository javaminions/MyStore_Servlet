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
		if(navSelection!=null) {
			navHandler(navSelection, request, response);
		}
		
		
		String footerSelection = request.getParameter("footerSelection");
		System.out.println(footerSelection);
		if(footerSelection!=null) {
			footerHandler(footerSelection, request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void navHandler(String navSelection, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(navSelection.equalsIgnoreCase("profile")){
			request.getRequestDispatcher("views/UserProfile.jsp").forward(request, response);
		} 
		if(navSelection.equalsIgnoreCase("orders")) {
			request.getRequestDispatcher("views/Orders.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("cart")) {
			request.getRequestDispatcher("views/Cart.jsp").forward(request, response);
		}
		if(navSelection.equalsIgnoreCase("logout")) {
			request.getRequestDispatcher("views/Logout.jsp").forward(request, response);
		}
	}
	
	private void footerHandler(String footerSelection, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(footerSelection.equalsIgnoreCase("contactus")) {
			request.getRequestDispatcher("views/ContactUs.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("aboutus")) {
			request.getRequestDispatcher("views/AboutUs.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("testimonials")) {
			request.getRequestDispatcher("views/Testimonials.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("press")) {
			request.getRequestDispatcher("views/Press.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("payments")) {
			request.getRequestDispatcher("views/Payments.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("shipping")) {
			request.getRequestDispatcher("views/Shipping.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("return")) {
			request.getRequestDispatcher("views/Return.jsp").forward(request, response);
		}
		if(footerSelection.equalsIgnoreCase("faq")) {
			request.getRequestDispatcher("views/FAQ.jsp").forward(request, response);
		}
	}

}
