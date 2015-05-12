
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

		<script type="text/javascript">
	var xmlHttpRequest;
	function createXMLHttpRequest() 
	{
		if (window.XMLHttpRequest) //非IE浏览器
		{
			xmlHttpRequest = new XMLHttpRequest();
		} 
		else if (window.ActiveObject)//IE6以上浏览器 
		{
			xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
		} 
		else //IE6及以下浏览器
		{
			xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
		}
	}
	
	function usernameIsExist()
	{
		var username = document.userInfo.username.value;
		sendRequest("usernameValidation?username="+username);
	}

	function sendRequest(url){
		createXMLHttpRequest();
		xmlHttpRequest.open("GET", url, true);
		xmlHttpRequest.onreadystatechange = processResponse;
		xmlHttpRequest.send(null);
	}
	
	function processResponse(){
		if(xmlHttpRequest.readyState == 4){
			if(xmlHttpRequest.status == 200){
				var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("info")[0].firstChild.data;
				var div1 = document.getElementById("usernameInfo");
				if(responseInfo == "Exist"){
					div1.innerHTML="<font color='red'>The User ID is Exist</font>";
				}
				else{
					div1.innerHTML="<font color='green'>The User ID is Available</font>";
				}
			}
		}
	}
	
</script>

		<div id="Catalog">

			<form action="../RegisterServlet" method="post" name="userInfo"
				id="userInfo" onsubmit="return validateRegister()">

				<h3>User Information</h3>

				<table>
					<tr>
						<td>User ID:</td>
						<td><input type="text" name="username" id="username"
							onblur="usernameIsExist();" />
							<div id="usernameInfo"></div></td>
					</tr>
					<tr>
						<td>New password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Repeat password:</td>
						<td><input type="password" name="repeatedPassword" /></td>
					</tr>
				</table>

				<!-- <include file="IncludeAccountFields.html" /> -->

				<input type="submit" name="newAccount"
					value="Save Account Information" />

			</form>
			<script language="javaScript">
				function validateRegister() {
					var username = document.userInfo.username.value;
					var sPassword1 = document.userInfo.password.value;
					var sPassword2 = document.userInfo.repeatedPassword.value;
					if(username==""||sPassword1==""||sPassword2==""){
						alert("please complete the form");
						return false;
					}
					if (sPassword1 != sPassword2) {
						alert("The passwords entered are not the same");
						return false;
					}
				}
			</script>
		</div>

	</div>

<div>
   <jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
</div>

</body>
</html>