
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.levi.jpstore.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="StyleSheet" href="../css/jpetstore.css" type="text/css"
	media="screen" />

<meta name="generator"
	content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
<title>JPetStore Demo</title>
<meta content="text/html; charset=windows-1252"
	http-equiv="Content-Type" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

	<div>
		<jsp:include page="../common/top.jsp"></jsp:include>
	</div>

	<div id="Content">

		<div id="BackLink">
			<a href="../catalog/Main.html">Return to Main Menu</a>
		</div>

		<div id="Catalog">

			<div id="Cart">

				<h2>Shopping Cart</h2>
				<form action="" method="post">
					<table>
						<tr>
							<th><b>Item ID</b></th>
							<th><b>Product ID</b></th>
							<th><b>Description</b></th>
							<th><b>In Stock?</b></th>
							<th><b>Quantity</b></th>
							<th><b>List Price</b></th>
							<th><b>Total Cost</b></th>
							<th>&nbsp;</th>
						</tr>
						<tr>
							<td colspan="8"><b>Your cart is empty.</b></td>
						</tr>
						<c:forEach items="${sessionScope.cartlist}" var="cart"
					varStatus="vs">
						<tr>
							<td><a href="#">${cart.itemid}</a></td>
							<td>${cart.productid}</td>
							<td>${cart.descn}</td>
							<td>true</td>
							<td><input type="text" size="3" name="" value="${cart.amount}" /></td>
							<td>${cart.listprice}</td>
							<td>${cart.unitprice}</td>
							<td><a href="../RemoveCartServlet?itemid=${cart.itemid}" class="Button">Remove</a></td>
						</tr>
						</c:forEach>
						<tr>
							<td colspan="7">Sub Total: ${sessionScope.cartlistsum}
							 <input onclick="../CartServlet"
								class="Button" type="submit" value="Update Cart" />
							</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>

				<a href="../CheckOutOrderServlet">Proceed to Checkout</a>
			</div>

	<!-- 		<div id="MyList">
				判断
				<include file="IncludeMyList.html" />
			</div> -->

			<div id="Separator">&nbsp;</div>
		</div>

	</div>

		<div>
			<jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
		</div>
</body>
</html>