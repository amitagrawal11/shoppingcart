package UserControllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOLayer.AdminDbDAO;
import Model.User;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String formUsername = request.getParameter("form-username");
		String formPassword = request.getParameter("form-password");
		String formEmail = request.getParameter("form-email");
		String formMobno = request.getParameter("form-mobno");

		if(formUsername != null && formPassword != null && formEmail != null && formMobno != null){
			try{
				User newUser = new User();
				newUser.setUsername(formUsername);
				newUser.setPassword(formPassword);
				newUser.setEmailid(formEmail);
				newUser.setMobno(formMobno);

				boolean isUserRegistered = AdminDbDAO.addNewUser(newUser);
				
				response.setContentType("text/html");
				if(isUserRegistered == true){
					out.print("<h3>You are Registered Successfully!!!!!!</h3>");
					out.print("<a href='Login.jsp'>Go To Login Page</a>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}else{
			response.sendRedirect("Register.jsp");
		}
	}
}
