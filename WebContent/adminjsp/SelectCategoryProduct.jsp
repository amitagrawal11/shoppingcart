<%@page import="DAOLayer.AdminCategoryDAO"%>
<%@page import="DAOLayer.AdminInterfaceDAO,Model.Category"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Select Category For Product List</title>
<jsp:include page="AdminBar.jsp" />

<%
	AdminCategoryDAO dao = new AdminCategoryDAO();
	List<?> categories = (List<?>) dao.readAll();
%>
</head>
<body>
	<div align="center">
		<h2>Select Category For Product List</h2>
	</div>
	<div align="center">
		<form action="../GetProductListByCategory" method="post">
					Category :<select name="category" required="true">
							<%
								Category category = new Category();
								for (Object obj : categories) {
									category = (Category) obj;
							%>
							<option><%=category.getCatgName()%></option>
							<%
								}
							%>
					</select>
				<input value="Submit Category" type="submit" />
		</form>
	</div>
</body>
</html>
