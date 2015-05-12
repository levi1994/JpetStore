
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	<a href="Category.html">Return
		to Category</a>
</div>

<div id="Catalog">

	<h2>Product Name</h2>

	<table>
		<tr>
			<th>Item ID</th>
			<th>Product ID</th>
			<th>Description</th>
			<th>List Price</th>
			<th>&nbsp;</th>
		</tr>
		<!-- list -->
		<c:forEach items="${sessionScope.productInfo}" var="productIn"
					varStatus="vs">
		<tr>
			<td><a href="#">${productIn.itemid}</a></td>
			<td>${productIn.productid}</td>
			<td>${productIn.descn}</td>
			<td>${productIn.listprice}</td>
			<td><a class="Button" href="../AddCartServlet?itemid=${productIn.itemid}">Add
					to Cart</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td></td>
		</tr>
	</table>
</div>

</div>

<div>
   <jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
</div>

</body>
</html>





