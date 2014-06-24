package Filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="AdminFilter", urlPatterns={"/AddCategoryServlet","/AddProductServlet",
		"/DeleteCategoryServlet","/DeleteProductServlet","/UpdateCategoryServlet","/EditProductServlet",
		"/GetProductListByCategory","/GetProductListByCategory","/UpdateProductServlet","/adminjsp/AddCategory.jsp",
		"/adminjsp/AddProduct.jsp","/adminjsp/AdminHome.jsp", "/adminjsp/EditProduct.jsp","/adminjsp/ListCategory.jsp",
		"/adminjsp/ListProducts.jsp","/adminjsp/SelectCategoryProduct.jsp","/adminjsp/EditCategory.jsp"})
public class AdminFilter extends AdminGenericFilter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
	ServletException{
		
		HttpSession adminSession = ((HttpServletRequest)request).getSession(false);
		String admin_status = (String )adminSession.getAttribute("admin_status");
		String adminAttr = (String)adminSession.getAttribute("admin_sessionattr");
		String admin = (String)adminSession.getAttribute("admin");
		response.setContentType("text/html");
		
		if(adminSession != null && (adminAttr != null && admin_status != "false" )&& admin.equals("admin")){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) response).sendRedirect("../AdminLogin.jsp");
		}
	}
}
