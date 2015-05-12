
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

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>
	<!-- 循环 -->
	<c:forEach items="${sessionScope.orderslist}" var="order"
					varStatus="vs">
		<tr>
			<td><a href="../ViewOrderServlet?orderid=${order.orderid}">${order.orderid}</a></td>
			<td>${order.orderdate}</td>
			<td>${order.totalprice}</td>
		</tr>
		</c:forEach>
</table>

</div>

<div id="Footer">

<div id="PoweredBy">&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
</div>

<div id="Banner">
          IncludeBottom.html
        </div>

</div>

</body>
</html>


