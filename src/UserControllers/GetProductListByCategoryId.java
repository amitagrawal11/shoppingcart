package UserControllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminProductDAO;
import Exceptions.MyException;


@WebServlet("/GetProductListByCategoryId")
public class GetProductListByCategoryId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catgId = request.getParameter("catgId");
		if(catgId != null){
			AdminProductDAO adminProdDAO = new AdminProductDAO();
			List<?> products = null;
			try {
				products = adminProdDAO.getProductsByCatg(Integer.parseInt(catgId));
			} catch (NumberFormatException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			} catch (MyException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			request.getSession().setAttribute("products",products);
			response.sendRedirect("userjsp/UserProductHome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
