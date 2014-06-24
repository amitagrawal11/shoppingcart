package AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminCategoryDAO;
import DAOLayer.AdminProductDAO;
import Exceptions.MyException;
import Model.Category;


@WebServlet("/GetProductListByCategory")
public class GetProductListByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCategoryDAO adminCatgDAO = new AdminCategoryDAO();
		AdminProductDAO adminProdDAO = new AdminProductDAO();
		String catgName = request.getParameter("category");
		Category category = null;
		try {
			category = adminCatgDAO.getCategoryByName(catgName);
		} catch (MyException e) {
			request.getSession().setAttribute("exception",e.getMessage());
		}
		List<?> products = null;
		try {
			products = adminProdDAO.getProductsByCatg(category);
		} catch (MyException e) {
			request.getSession().setAttribute("exception",e.getMessage());
		}
		request.getSession().setAttribute("products",products);
		response.sendRedirect("adminjsp/ListProducts.jsp");
	}

}
