package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Cart;
import pojo.LineItem;
import pojo.Product;
import utility.CookieMonster;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = null;
		if(request.getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getAttribute("cart");
		}
		
		String action = null;
		if(request.getParameter("action")!=null) {
			action = request.getParameter("action");
			actionHandler(cart, action, request, response);
			return;
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void actionHandler(Cart cart, String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(action.equalsIgnoreCase("showall")) {
			request.getRequestDispatcher("/views/Cart.jsp").forward(request, response);
			return;
		}
		if(action.equalsIgnoreCase("addtocart")) {
			addToCart(cart, request, response);
			return;
		}
		
	}
	
	private void addToCart(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("prodcode");
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");
		Product productToAdd = null;
		for(Product product: products) {
			if(product.getCode().equalsIgnoreCase(code)) {
				productToAdd = product;
				System.out.println(product.toString());
			} else {
				//product not found, error 
				//products should have been loaded correctly by now 
			}
		}
		
		if(cart.getItemCount()==0) {
			//add to cart
			LineItem lineItem = new LineItem(1, productToAdd);
			cart.addLineItem(lineItem);
			request.setAttribute("cart", cart);
			request.setAttribute("cartCount", 1);
			
			String[] stringified = CookieMonster.stringify(lineItem);
			
			Cookie c = new Cookie(stringified[0], stringified[1]);
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/");
			response.addCookie(c);
			request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
		} else {
			//check if item exists and then add to cart or add +1 to count 
			
		}
		
	}
	
	private void initializeCart() {
		//read cookies
		//if there are product matches set the cart line items 
	}
	
}
