package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOLayer.AdminCategoryDAO;
import DAOLayer.AdminProductDAO;
import Exceptions.MyException;
import Model.Category;
import Model.Product;


@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		boolean status = false;
		Category category = new Category();
		AdminProductDAO adminProDAO = new AdminProductDAO();
		AdminCategoryDAO adminCatgDAO = new AdminCategoryDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String productName= request.getParameter("product_name");
		String productPrice = request.getParameter("product_price");
		String productDesc = request.getParameter("product_desc");
		String productCatg = request.getParameter("category");
		/*byte[] productImage = request.getParameter("product_image").getBytes();*/
		HttpSession adminSession = request.getSession(false);

		if(productName != null && productPrice != null && productDesc != null){
			product.setProductName(productName);
			product.setProductPrice(Double.parseDouble(productPrice));
			product.setProductDesc(productDesc);
			/*product.setProductImage(productImage);*/
			try {
				category = adminCatgDAO.getCategoryByName(productCatg);
			} catch (MyException e) {
				adminSession.setAttribute("exception",e.getMessage());
			}
			product.setCategory(category);

			try {
				status = adminProDAO.add(product);
			} catch (Exception e) {
				adminSession.setAttribute("exception",e);
				e.printStackTrace();
			}
			if(status == true){
				adminSession.setAttribute("message","You Have Succesfully Added new Product !!!" );
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}else{
				adminSession.setAttribute("message","Error !!! You Have Added duplicate Product !!!" );
				response.sendRedirect("adminjsp/AdminHome.jsp");
			}
		}else{
			out.println("<script>alert('Write Product Details Again !!!')</script>");
			response.sendRedirect("AdminLogin.jsp");
		}


	}

}
