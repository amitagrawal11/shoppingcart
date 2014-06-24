<%@page import="Model.Product"%>
<%@page import="DAOLayer.AdminProductDAO"%>
<%@page import="java.util.List"%>
<%@ page import="java.io.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Categories</title>
<style>
body {
	background: url(../images/bg.png) repeat;
}
</style>
<%
	List<?> products = (List<?>) request.getSession().getAttribute("products");
	List<Product> selectedProducts = (List<Product>) request.getSession().getAttribute("selectedProducts");
	
	Product product = new Product();
%>
</head>
<body>
	<div align="center" id="edit">
		<form action="../AddToCartServlet" method="post">
			<table border="1">
			<%
				if (products != null) {
			%>
				<tr>
					<th width="150">Select Products</th>
					<!-- <th width="200">Product Image</th> -->
					<th width="100">Product Name</th>
					<th width="100">Product Price</th>
					<th width="300">Product Description</th>
				</tr>
				<%
					
						for (Object obj : products) {
							product = (Product) obj;
				%>
				<tr>
					<td align="center"><input type="checkbox" name="productBox"
						value="<%=product.getProductId()%>"></td>
					<%-- <td align="center"><%=product.getProductImage()%></td> --%>
					<td align="center"><%=product.getProductName()%></td>
					<td align="center">Rs. <%=product.getProductPrice()%></td>
					<td align="center"><%=product.getProductDesc()%></td>
				</tr>
				<%		}
						request.getSession().setAttribute("products", null);
					
					}else if(selectedProducts != null){
						for (Product cproduct : selectedProducts) {
				%>		
					<tr>
					<td align="center"></td>
					<%-- <td align="center"><%=cproduct.getProductImage()%></td> --%>
					<td align="center"><%=cproduct.getProductName()%></td>
					<td align="center">Rs. <%=cproduct.getProductPrice()%></td>
					<td align="center"><%=cproduct.getProductDesc()%></td>
				</tr>
				<%
						}
					}else {
						out.print("Please select One category.");
					}
				if(products != null){
				%>
				
				<tr>
					<td colspan="4" align="center"><input type="submit"
						value="Add To Cart">
					</td>
				</tr>
				<%
				}
				
				%>
			</table>
		</form>
	</div>
</body>
</html>






