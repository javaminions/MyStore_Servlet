package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//For Registration
		String action = request.getParameter("action");
		if(action.equals("register")) {
			registerUser(request, response);
		} else if (action.equals("signin")) {
			signInUser(request,response);
		} else if (action.equals("registerPage")) {
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		} else if (action.equals("signinPage")) {
			request.getRequestDispatcher("views/signin.jsp").forward(request, response);
		}
		
		
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void navHandler(String navSelection, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(navSelection.equalsIgnoreCase("register")){
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
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

	private void registerUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
	
		HttpSession session = request.getSession();
		
		//UserName Cookie
		session.setAttribute("userName", userName);
		Cookie unc = new Cookie("userNameCookie", userName);
		unc.setPath("/");
		unc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(unc);
		
		
		//Password Cookie
		session.setAttribute("password", password);
		Cookie pc = new Cookie("passwordCookie", password);
		pc.setPath("/");
		pc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(pc);
		
		//Email Cookie
		session.setAttribute("email", email);
		Cookie ec = new Cookie("emailCookie", email);
		ec.setPath("/");
		ec.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(ec);
		
		//First Name Cookie
		session.setAttribute("firstName", firstName);
		Cookie fnc = new Cookie("firstNameCookie", firstName);
		fnc.setPath("/");
		fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(fnc);
		
		//Last Name Cookie
		session.setAttribute("lastName", lastName);
		Cookie lnc = new Cookie("lastNameCookie", lastName);
		lnc.setPath("/");
		lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(lnc);
		
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
	

	private void signInUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie [] cookies = request.getCookies();
		
		if (request.getParameter("userName").equals(getCookieValue(cookies,"userNameCookie")) 
				&& request.getParameter("password").equals(getCookieValue(cookies, "passwordCookie")))  {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		
	}
	
	
    public static String getCookieValue(
            Cookie[] cookies, String cookieName) {
        
        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
