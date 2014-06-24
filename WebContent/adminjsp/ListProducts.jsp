<%@page import="Model.Product"%>
<%@page import="DAOLayer.AdminProductDAO"%>
<%@page import="java.util.List"%>
 <%@ page import="java.io.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Categories</title>
<jsp:include page="AdminBar.jsp" />
<%
	List<?> products = (List<?>) request.getSession().getAttribute(
			"products");
	Product product = new Product();
%>
</head>
<body>
	<div align="center" id="edit">
		<table border="1">
			<tr>
				<!-- <th width="300">Product Image</th> -->
				<!-- <th width="80">Product ID</th> -->
				<th width="150">Product Name</th>
				<th width="100">Product Price</th>
				<th width="200">Product Description</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<%
				for (Object obj : products) {
					product = (Product) obj;
			%>
			<tr>
				<%-- <td align="center"><%= product.getProductImage() %></td> --%>
				<%-- <td align="center"><%=product.getProductId()%></td> --%>
				<td align="center"><%=product.getProductName()%></td>
				<td align="center">Rs. <%=product.getProductPrice()%></td>
				<td align="center"><%=product.getProductDesc()%></td>
				<td align="center"><a
					href="../EditProductServlet?productId=<%=product.getProductId()%>">
						<button type="button">Edit</button>
				</a></td>
				<td align="center"><a
					href="../DeleteProductServlet?productId=<%=product.getProductId()%>">
						<button type="button">Delete</button>
				</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>