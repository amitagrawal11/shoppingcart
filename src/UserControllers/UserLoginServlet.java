package UserControllers;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOLayer.AdminDbDAO;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formUsername = request.getParameter("form-username");
		String formPassword = request.getParameter("form-password");
		
		HttpSession userSession = request.getSession(false);
		RequestDispatcher forwardUser = null;

		if (formUsername != null && formPassword != null ) {
			try {
				if (AdminDbDAO.getUserAuthenticate(formUsername, formPassword)) {
					userSession = request.getSession(true);
					userSession.setAttribute("userSession", formUsername);
					userSession.setAttribute("userStatus", "true");
					userSession.setAttribute("user", "user");
					response.sendRedirect("userjsp/UserHome.jsp");
				} else {
					userSession.setAttribute("status", "false");
					forwardUser = getServletContext().getRequestDispatcher("/Login.jsp");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('Please make sure you enter UserID/Pass as \"User : Password\".')</script>");
					forwardUser.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("Login.jsp");
		}
	}
}
