<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>New Category</title>

<jsp:include page="AdminBar.jsp" />
</head>
<body>
	<div align="center">
		<h2>Add New Category</h2>
		<form action="../AddCategoryServlet" method="post">

			Category Name:<input type="text" name="catg-name" required="true" />
			<input type="submit" value="Add New Category" />
		</form>
	</div>
</body>
</html>