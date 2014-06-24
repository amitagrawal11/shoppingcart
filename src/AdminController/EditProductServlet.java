package AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminProductDAO;
import Exceptions.MyException;
import Model.Product;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		Product product = new Product();
		
		if(productId != null && !(productId.equals(""))){	
			try {
				product = new AdminProductDAO().getProductById(Integer.parseInt(productId));
			} catch (NumberFormatException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			} catch (MyException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			request.getSession().setAttribute("product", product);
			response.sendRedirect("adminjsp/EditProduct.jsp");
		}else{
			request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
			response.sendRedirect("adminjsp/AdminHome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
