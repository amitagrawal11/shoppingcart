<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="Exceptions.MyException"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Control Panel</title>
<jsp:include page="AdminBar.jsp" />
<script>
<%
	HttpSession adminSession  = request.getSession(false);
	String msg =(String) adminSession.getAttribute("message");
	MyException exception =(MyException) adminSession.getAttribute("exception");
	
	if(exception != null){
	
%>
		alert("<%=exception.getMessage()%>");
<%
	
	}
	 if(msg != null){
%>
			alert("<%=msg%>");
<%
			exception = null;
			msg = null;
			adminSession.setAttribute("message", msg);
			adminSession.setAttribute("exception", exception);
		}
%>
</script>
</head>
<body>

</body>
</html>