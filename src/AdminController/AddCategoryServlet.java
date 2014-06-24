package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import DAOLayer.AdminCategoryDAO;
import Exceptions.MyException;
import Model.Category;


@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {

	private boolean status = false;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Category newCategory = new Category();
		AdminCategoryDAO adminDAO = new AdminCategoryDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String categoryName = request.getParameter("catg-name");
		HttpSession adminSession = ((HttpServletRequest)request).getSession(false);
		
		if(categoryName != null){
			newCategory.setCatgName(categoryName);
			try {
			status = adminDAO.add(newCategory);
			} catch (MyException me) {
				adminSession.setAttribute("exception", me);				
			} catch(Exception e){
				e.printStackTrace();
			}
			if(status == true){
				adminSession.setAttribute("message","You Have Succesfully Added new Category !!!" );
				response.sendRedirect("adminjsp/AdminHome.jsp");
			} else {
				adminSession.setAttribute("message","Error !!!!!!You Have Added Duplicate Category !!!" );
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}
		}else{
			out.println("<script>alert('Write Category Name Again !!!')</script>");
			response.sendRedirect("AdminLogin.jsp");
		}
	}
}
