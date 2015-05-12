
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

<div id="Catalog"><form>

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><stripes:text name="order.shipToFirstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><stripes:text name="order.shipToLastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><stripes:text size="40" name="order.shipAddress1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><stripes:text size="40" name="order.shipAddress2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><stripes:text name="order.shipCity" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><stripes:text size="4" name="order.shipState" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><stripes:text size="10" name="order.shipZip" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><stripes:text size="15" name="order.shipCountry" /></td>
		</tr>


	</table>

	<stripes:submit name="newOrder" value="Continue" />

</form></div>

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