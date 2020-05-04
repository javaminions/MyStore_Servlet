package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Product;
import pojo.ProductIO;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			ServletContext sc = getServletContext();

			HttpSession session = request.getSession();
			String path = sc.getRealPath("/WEB-INF/products.txt");
	        ArrayList<Product> products = ProductIO.getProducts(path);
	        
			String filteredCategory = request.getParameter("filterCategory");
       
			if(filteredCategory != null && filteredCategory != "") {
				session.setAttribute("filteredCategory", filteredCategory); 
				System.out.println("filtered category is: " + filteredCategory);
			}

            //request.setAttribute("products", products);
            String url = "/views/categories.jsp";
        
        sc.getRequestDispatcher(url)
                .forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
