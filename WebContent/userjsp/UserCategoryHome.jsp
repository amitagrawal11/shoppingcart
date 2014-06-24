<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="DAOLayer.AdminCategoryDAO, java.util.*, Model.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>
<%
	String userName = (String)request.getSession().getAttribute("userSession");
	AdminCategoryDAO userDao = new AdminCategoryDAO();
	List<?> categories = userDao.readAll();
%>

<style>
body {
	background: url(../images/bg.png) repeat;
}
</style>
</head>

<body>
	<div align="center">
	<table border="1">
		<tr>
		<th width="150" align="center">Select Category</th></tr>
		<%
			for(Object obj : categories){
				Category catg = (Category)obj;
		%>
		<tr><td align="center"><a href="../GetProductListByCategoryId?catgId=<%=catg.getCatgId()%>" target="mainFrame"><%= catg.getCatgName() %></a></td></tr>		
		<%
			}
		%>
		</table>
	</div>
</body>
</html>