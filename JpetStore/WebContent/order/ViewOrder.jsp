
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
<ul class="messages">
	<li>Thank you, your order has been submitted.</li>
</ul>
<div id="BackLink">
	<a href="../catalog/Main.jsp">Return to Main Menu</a>
</div>

<div id="Catalog">

	<table>
		<tbody>
			<tr>
				<th align="center" colspan="2">Order # ${sessionScope.orderbean.orderid} ${sessionScope.orderbean.orderdate}</th>
			</tr>
			<tr>
				<th colspan="2">Payment Details</th>
			</tr>
			<tr>
				<td>Card Type:</td>
				<td>${sessionScope.orderbean.cardtype}</td>
			</tr>
			<tr>
				<td>Card Number:</td>
				<td>5555 5555 5555</td>
			</tr>
			<tr>
				<td>Expiry Date (MM/YYYY):</td>
				<td>${sessionScope.orderbean.orderdate}</td>
			</tr>
			<tr>
				<th colspan="2">Billing Address</th>
			</tr>
			<tr>
				<td>First name:</td>
				<td>${sessionScope.orderbean.billtofirstname}</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>${sessionScope.orderbean.billtolastname}</td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td>${sessionScope.orderbean.billaddr1}</td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td>${sessionScope.orderbean.billaddr2}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${sessionScope.orderbean.billcity}</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>${sessionScope.orderbean.billstate}</td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td>${sessionScope.orderbean.billzip}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${sessionScope.orderbean.billcountry}</td>
			</tr>
			<tr>
				<th colspan="2">Shipping Address</th>
			</tr>
			<tr>
				<td>First name:</td>
				<td>${sessionScope.orderbean.shiptofirstname}</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>${sessionScope.orderbean.shiptolastname}</td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td>${sessionScope.orderbean.shipaddr1}</td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td>${sessionScope.orderbean.shipaddr2}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${sessionScope.orderbean.shipcity}</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>${sessionScope.orderbean.shipstate}</td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td>${sessionScope.orderbean.shipzip}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${sessionScope.orderbean.shipcountry}</td>
			</tr>
			<tr>
				<td>Courier:</td>
				<td>${sessionScope.orderbean.courier}</td>
			</tr>
			<tr>
				<td colspan="2">Status: P</td>
			</tr>
			<tr>
				<td colspan="2">
					<table>
						<tbody>
							<tr>
								<th>Item ID</th>
								<th>Description</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Total Cost</th>
							</tr>
                    <c:forEach items="${sessionScope.lineitemlist}" var="lineitem"
					               varStatus="vs">
							<tr>
								<td><a href="../catalog/Category.html">${lineitem.itemid}</a></td>
								<td>${lineitem.descn}</td>

								<td>${lineitem.quantity}</td>
								<td>${lineitem.listprice}</td>
								<td>${lineitem.unitprice}</td>
							</tr>
					</c:forEach>

							<tr>
								<th colspan="5">Total: ${sessionScope.total}</th>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>

		</tbody>
	</table>

</div>

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
