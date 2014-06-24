package AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOLayer.AdminCategoryDAO;
import Exceptions.MyException;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean status = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catgId = request.getParameter("catgId");
		AdminCategoryDAO adminDAO = new AdminCategoryDAO();
		HttpSession adminSession = request.getSession(false);
		
		try {
			status = adminDAO.remove(Integer.parseInt(catgId));
		} catch (NumberFormatException e) {
			adminSession.setAttribute("exception",e.getMessage());
		} catch (MyException e) {
			adminSession.setAttribute("exception",e.getMessage());
		}
		
		if(status==true){
			adminSession.setAttribute("message", "Your Category has been deleted Successfully.");
		}else{
			adminSession.setAttribute("message", "Error !!! Your Category has not been deleted.");
		}
		response.sendRedirect("adminjsp/AdminHome.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
