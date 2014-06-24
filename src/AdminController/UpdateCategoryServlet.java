package AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminCategoryDAO;
import Exceptions.MyException;
import Model.Category;


@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catgId = request.getParameter("catgId");
		String catgName = request.getParameter("catgName");
		boolean status = false;
		
		if(catgId != null && catgName != null){
			Category category = new Category();
			category.setCatgId(Integer.parseInt(catgId));
			category.setCatgName(catgName);
			try {
				status = new AdminCategoryDAO().update(category);
			} catch (MyException e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			if(status == true){
				request.getSession().setAttribute("message", "Selected Category has been Updated Successfully");
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}else{
				request.getSession().setAttribute("message", "Error !!! Selected Category has not been Updated.");
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}
		}
		
	}

}
