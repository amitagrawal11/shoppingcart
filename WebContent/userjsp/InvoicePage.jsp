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
	List<Product> selectedProducts = (List<Product>) request.getSession().getAttribute("selectedProducts");
	String price = session.getAttribute("totalPrice").toString();
	double totalPrice = 0;
	if(price != null){
		totalPrice = Double.parseDouble(price);	
	}
	
%>

</head>

<body>
	<div align="center" id="edit">
		<form action="../AddToCartServlet" method="post">
			<table border="1">
				<caption>
					<h3>
						<u>Invoice Page</u>
					</h3>
				</caption>
				<tr>
					<!-- <th width="150">Select Products</th> -->
					<!-- <th width="200">Product Image</th> -->
					<th width="100">Product Name</th>
					<th width="100">Product Price</th>
					<th width="300">Product Description</th>
				</tr>
				<%
					if (selectedProducts != null) {
						for (Product cproduct : selectedProducts) {
				%>
				<tr>
					<!-- <td align="center"></td> -->
					<%-- <td align="center"><%=cproduct.getProductImage()%></td> --%>
					<td align="center"><%=cproduct.getProductName()%></td>
					<td align="center">Rs. <%=cproduct.getProductPrice()%></td>
					<td align="center"><%=cproduct.getProductDesc()%></td>
				</tr>
				<%
					}
					} else {
						response.setContentType("text/html");
						out.print("<h2>No product is selected.</h2>");
					}
				%>
				<tr>
					<td colspan="3" align="center"><h4>Total Price: <%=totalPrice%>Rs</h4></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>