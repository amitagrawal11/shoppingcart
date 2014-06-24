
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserHome JSP</title>
<style>
body {
	margin: 0px;
	background: url(../images/bg.png) repeat;
}
 a{
 	list-style: none;'
 }
#ux-header {
	line-height: 100px;
	min-width: 998px;
	background-color: rgb(40, 40, 40);
	color: rgb(207, 207, 207);
	margin-top: -21px;
}
</style>
<%
	String userName = (String)request.getSession().getAttribute("userSession");
%>
</head>
<body>
	<div id="header" >
		<div id="ux-header">
			<h1 align="center">Welcome	<%=userName%></h1>
		</div>
		<div align="right">
			<a href='../UserLogoutServlet' target="_parent">Logout User</a>
		</div>
	</div>
</body>
</html>