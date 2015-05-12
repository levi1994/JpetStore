
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
		

		<div id="Welcome">
			<div id="WelcomeContent">
        			Welcome to MyPetStore!
			</div>
		</div>

		<div id="Main">
			<div id="Sidebar">
				<div id="SidebarContent">
					<a href="../ProductServlet?category=FISH"><img src="../images/fish_icon.gif" /></a>
					<br/> Saltwater, Freshwater <br/>
					<a href="../ProductServlet?category=DOGS"><img src="../images/dogs_icon.gif" /></a>
					<br /> Various Breeds <br />
					<a href="../ProductServlet?category=CATS"><img src="../images/cats_icon.gif" /></a>
					<br /> Various Breeds, Exotic Varieties <br />
					<a href="../ProductServlet?category=REPTILES"><img src="../images/reptiles_icon.gif" /></a>
					<br /> Lizards, Turtles, Snakes <br />
					<a href="../ProductServlet?category=BIRDS"><img src="../images/birds_icon.gif" /></a>
					<br /> Exotic Varieties
				</div>
			</div>

			<div id="MainImage">
				<div id="MainImageContent">
					<map name="estoremap">
						<area alt="Birds" coords="72,2,280,250" href="Category.jsp" shape="rect" />
						<area alt="Fish" coords="2,180,72,250" href="../ProductServlet?category=FISH" shape="rect" />
						<area alt="Dogs" coords="60,250,130,320" href="../ProductServlet?category=DOGS" shape="rect" />
						<area alt="Reptiles" coords="140,270,210,340" href="../ProductServlet?category=REPTILES" shape="rect" />
						<area alt="Cats" coords="225,240,295,310" href="../ProductServlet?category=CATS" shape="rect" />
						<area alt="Birds" coords="280,180,350,250" href="../ProductServlet?category=BIRDS" shape="rect" />
					</map>
					<img height="355" src="../images/splash.gif" align="middle" usemap="#estoremap" width="350" />
				</div>
			</div>
			<div id="Separator">&nbsp;</div>
		</div>
		
</div>
<div>
   <jsp:include page="../common/IncludeBottom.jsp"></jsp:include>
</div>

</body>
</html>