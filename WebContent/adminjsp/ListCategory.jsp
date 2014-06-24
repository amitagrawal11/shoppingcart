<%@page import="DAOLayer.AdminInterfaceDAO"%>
<%@page import="Model.Category"%>
<%@page import="DAOLayer.AdminCategoryDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Categories</title>
<jsp:include page="AdminBar.jsp" />
<%
	AdminCategoryDAO adminDAO = new AdminCategoryDAO();
	List<?> categories = adminDAO.readAll();
	Category catg = new Category();
%>
</head>
<body>
	<div align="center" id="edit">
		<table border="1">
			<tr>
				<!-- <th width="100">Category ID</th> -->
				<th width="200">Category Name</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<%
				for (Object obj : categories) {
					catg = (Category) obj;
			%>
			<tr>
				<%-- <td align="center"><%=catg.getCatgId()%></td> --%>
				<td align="center"><%=catg.getCatgName()%></td>
				<td align="center"><a href="../adminjsp/EditCategory.jsp?catgId=<%=catg.getCatgId()%>"><button
							type="button">Edit</button></a></td>
				<td align="center"><a
					href="../DeleteCategoryServlet?catgId=<%=catg.getCatgId()%>"><button
							type="button">Delete</button></a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>