
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
			<a href="../catalog/Main.jsp">Return to Main Menu</a>
		</div>

		<div id="Catalog">
			Please confirm the information below and then press continue...

			<table>
				<tbody>
					<tr>
						<th align="center" colspan="2"><font size="4"><b>Order</b></font>
							<br> <font size="3"><b> ${sessionScope.date}</b></font></th>
					</tr>
					<tr>
						<th colspan="2">Billing Address</th>
					</tr>
					<tr>
						<td>First name:</td>
						<td>${sessionScope.accountInfo.firstname}</td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td>${sessionScope.accountInfo.lastname}</td>
					</tr>
					<tr>
						<td>Address 1:</td>
						<td>${sessionScope.accountInfo.addr1}</td>
					</tr>
					<tr>
						<td>Address 2:</td>
						<td>${sessionScope.accountInfo.addr2}</td>
					</tr>
					<tr>
						<td>City:</td>
						<td>${sessionScope.accountInfo.city}</td>
					</tr>
					<tr>
						<td>State:</td>
						<td>${sessionScope.accountInfo.state}</td>
					</tr>
					<tr>
						<td>Zip:</td>
						<td>${sessionScope.accountInfo.zip}</td>
					</tr>
					<tr>
						<td>Country:</td>
						<td>${sessionScope.accountInfo.country}</td>
					</tr>
					<tr>
						<th colspan="2">Shipping Address</th>
					</tr>
					<tr>
						<td>First name:</td>
						<td>${sessionScope.supplier.firstname}</td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td>${sessionScope.supplier.lastname}</td>
					</tr>
					<tr>
						<td>Address 1:</td>
						<td>${sessionScope.supplier.addr1}</td>
					</tr>
					<tr>
						<td>Address 2:</td>
						<td>${sessionScope.supplier.addr2}</td>
					</tr>
					<tr>
						<td>City:</td>
						<td>${sessionScope.supplier.city}</td>
					</tr>
					<tr>
						<td>State:</td>
						<td>${sessionScope.supplier.state}</td>
					</tr>
					<tr>
						<td>Zip:</td>
						<td>${sessionScope.supplier.zip}</td>
					</tr>
					<tr>
						<td>Country:</td>
						<td>${sessionScope.supplier.country}</td>
					</tr>

				</tbody>
			</table>


			<a class="Button" href="../SubmitOrderServlet">Confirm</a>
		</div>

	</div>

	<div id="Footer">

		<div id="PoweredBy">
			&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
		</div>

		<div id="Banner">IncludeBottom.html</div>

	</div>

</body>
</html>





