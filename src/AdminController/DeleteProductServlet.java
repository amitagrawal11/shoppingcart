package AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminProductDAO;
import Exceptions.MyException;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		if(productId != null && !(productId.equals(""))){
			boolean status = false;
			try {
				status = new AdminProductDAO().remove(Integer.parseInt(productId));
			} catch (NumberFormatException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			} catch (MyException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			if(status == true){
				request.getSession().setAttribute("message", "Selected Product has been deleted Successfully.");
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}else{
				request.getSession().setAttribute("message", "Error !!!! Selected Product has not been deleted !!!");
			}
		}else{
			request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
			response.sendRedirect("adminjsp/AdminHome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
