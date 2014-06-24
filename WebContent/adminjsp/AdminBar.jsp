<link rel="stylesheet" href="menubar/google_menu.css" type="text/css" />
<script type="text/javascript" src="menubar/jquery.js"></script>
<script type="text/javascript" src="menubar/jquery.google_menu.js"></script>
<script>
	$('document').ready(function() {
		$('.menu').fixedMenu();
	});
</script>
<div class="head">
	<div class="menu">
		<ul>
			<!-- Using class="current" for the link of the current page -->
			<li>
				<!-- Do not add any class for links with dropdown --> <a href="#">Category<span
					class="arrow"></span></a> <!-- Drop Down menu Items -->
				<ul>
					<li><a href="AddCategory.jsp">New Category</a></li>
					<li><a href="ListCategory.jsp">List Category</a></li>
				</ul>
			</li>
			<li>
				<!-- Do not add any class for links with dropdown --> <a href="#">Product<span
					class="arrow"></span></a> <!-- Drop Down menu Items -->
				<ul>
					<li><a href="AddProduct.jsp">New Product</a></li>
					<li><a href="SelectCategoryProduct.jsp">List Product</a></li>
				</ul>
			</li>
		</ul>
		<div align="right">
			<a href='../AdminLogoutServlet'>Logout</a>
		</div>
	</div>
	<br />

	<div align="center">
		<h1>Admin Control Panel</h1>
	</div>
</div>