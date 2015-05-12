<div id="Header">
	<div id="Logo">
		<div id="LogoContent">
			<a href="../catalog/Main.jsp"><img src="../images/logo-topbar.gif" /></a>
		</div>
	</div>

	<div id="Menu">
		<div id="MenuContent">
			<a href="../CartServlet"><img align="middle" name="img_cart"
				src="../images/cart.gif" /></a> <img align="middle"
				src="../images/separator.gif" /> <a
				href="../account/SignonForm.jsp">Sign In</a> <a
				href="../ExitSignServlet">Sign Out</a><img align="middle"
				src="../images/separator.gif" /> <a href="../GetAccountInfoServlet">My
				Account</a> <img align="middle" src="../images/separator.gif" /> <a
				href="../help.jsp">?</a>
		</div>
	</div>

	<div id="Search">
		<div id="SearchContent">
			<form action="../SearchServlet" method="post">
				<input type="text" name="keyword" size="14" /> <input type="submit"
					name="searchProducts" value="Search" />
			</form>
		</div>
	</div>

	<div id="QuickLinks">
		<a href="../ProductServlet?category=FISH"><img src="../images/sm_fish.gif" /></a> <img
			src="../images/separator.gif" /> 
		<a href="../ProductServlet?category=DOGS"><img
			src="../images/sm_dogs.gif" /></a> <img src="../images/separator.gif" />
		<a href="../ProductServlet?category=REPTILES"><img
			src="../images/sm_reptiles.gif" /></a> <img
			src="../images/separator.gif" /> 
		<a href="../ProductServlet?category=CATS"><img
			src="../images/sm_cats.gif" /></a> <img src="../images/separator.gif" />
		<a href="../ProductServlet?category=BIRDS"><img
			src="../images/sm_birds.gif" /></a>
	</div>

</div>
