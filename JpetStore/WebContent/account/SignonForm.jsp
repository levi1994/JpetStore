
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="StyleSheet" href="../css/jpetstore.css" type="text/css"
	media="screen" />

<meta name="generator"
	content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
<title>JPetStore Demo</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
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

		<script>
			function reloadImage() {
				//document.getElementById("btn").disabled=true;
				document.getElementById("imgservlet").src = 'validation';
			}
		</script>


		<div id="Catalog">
			<form action="../LoginServlet" method="post" name="LoginForm"
				onsubmit="return validateLogin()">
				<p>Please enter your username and password.</p>
				</p>
				<p>
					Username:<input type="text" name="username" /><br /> Password:<input
						type="password" name="password" /><br />
					<!--  Validation Code:<input type="text" name="validationCode"/>
			<img src="validation" id="imgservlet" onclick="reloadImage()"/>
			-->
					<!--  <input type="button" value="changeImage" onclick="reloadImage()" id="btn">-->
				</p>
				<input type="submit" name="signon" value="Login" />
			</form>
			<script language="javaScript">
				function validateLogin() {
					var sUserName = document.LoginForm.username.value;
					var sPassword = document.LoginForm.password.value;
					if (sUserName == "") {
						alert("please input your username");
						return false;
					}
					if (sPassword == "") {
						alert("please input your password");
						return false;
					}
				}
			</script>

			Need a user name and password? <a href="NewAccountForm.jsp">Register
				Now!</a>

		</div>

	</div>

<div>
   <jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
</div>

</body>
</html>


