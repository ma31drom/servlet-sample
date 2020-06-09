<!DOCTYPE html>
<%@page import="by.pvt.UserInfo"%>
<html lang="en" dir="ltr">
<head>
<title>Basic 88</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
</head>
<body>
	<div class="wrapper row1">
		<header id="header" class="clear">
			<div id="hgroup">
				<h1>
					<a href="#">Basic 88</a>
				</h1>
				<h2>Free HTML5 Website Template</h2>
			</div>
			<nav>
				<ul>
					<jsp:useBean id="userinfo" class="by.pvt.UserInfo"></jsp:useBean>
					<jsp:setProperty property="*" name="userinfo" />

					<li>
						<%
							UserInfo logged = (UserInfo) session.getAttribute("loggedUser");
							if (logged == null) {
								if (session.isNew()) {
									out.write("Hello first time!");
								} else {
									out.write("Anonymous! hello again!");
								}
							} else {
								out.write("Hello " + logged.getUsername() + "!");
							}
						%>

					</li>
					<li><a href="#">Text Link</a></li>
					<li><a href="#">Text Link</a></li>
					<li><a href="#">Text Link</a></li>
					<li class="last"><a href="#">Text Link</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<!-- content -->
	<div class="wrapper row2">
		<div id="container" class="clear">
			<!-- Slider -->
			<section id="slider">

				<%
					if (userinfo.getUsername() != null) {
						out.write("<a href=\"#\"><img src=\"images/demo/960x360.gif\" alt=\"\"></a>");
					} else {
						out.write("<form action=\"in\" method=\"post\">"
								+ "User Name: <input type=\"text\" name=\"username\"><br>"
								+ "User Password: <input type=\"password\" name=\"password\"><br>"
								+ "User Age: <input type=\"text\" name=\"age\"><br> "
								+ "<input type=\"submit\" value=\"enter\"> </form>");
					}
				%>






			</section>
			<!-- main content -->
			<div id="homepage">
				<!-- Services -->
				<section id="services" class="clear">
					<article class="one_third">
						<figure>
							<img src="images/demo/290x180.gif" width="290" height="180"
								alt="">
							<figcaption>
								<h2>Indonectetus facilis</h2>
								<p>Nullamlacus dui ipsum conseque loborttis non euisque
									morbi penas dapibulum orna.</p>
								<footer class="more">
									<a href="#">Read More &raquo;</a>
								</footer>
							</figcaption>
						</figure>
					</article>
					<article class="one_third">
						<figure>
							<img src="images/demo/290x180.gif" width="290" height="180"
								alt="">
							<figcaption>
								<h2>Indonectetus facilis</h2>
								<p>Nullamlacus dui ipsum conseque loborttis non euisque
									morbi penas dapibulum orna.</p>
								<footer class="more">
									<a href="#">Read More &raquo;</a>
								</footer>
							</figcaption>
						</figure>
					</article>
					<article class="one_third lastbox">
						<figure>
							<img src="images/demo/290x180.gif" width="290" height="180"
								alt="">
							<figcaption>
								<h2>Indonectetus facilis</h2>
								<p>Nullamlacus dui ipsum conseque loborttis non euisque
									morbi penas dapibulum orna.</p>
								<footer class="more">
									<a href="#">Read More &raquo;</a>
								</footer>
							</figcaption>
						</figure>
					</article>
				</section>
				<!-- / Services -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- Introduction -->
				<section id="intro" class="last clear">
					<article>
						<figure>
							<img src="images/demo/450x250.gif" width="450" height="250"
								alt="">
							<figcaption>
								<h2>Indonectetus facilis leo nibh</h2>
								<p>
									This is a W3C compliant free website template from <a
										href="https://www.os-templates.com/"
										title="Free Website Templates">OS Templates</a>. For full
									terms of use of this template please read our <a
										href="https://www.os-templates.com/template-terms">website
										template licence</a>.
								</p>
								<p>
									You can use and modify the template for both personal and
									commercial use. You must keep all copyright information and
									credit links in the template and associated files. For more
									HTML5 templates visit <a href="https://www.os-templates.com/">free
										website templates</a>.
								</p>
								<footer class="more">
									<a href="#">Read More &raquo;</a>
								</footer>
							</figcaption>
						</figure>
					</article>
				</section>
				<!-- / Introduction -->
			</div>
			<!-- / content body -->
		</div>
	</div>
	<!-- Footer -->
	<div class="wrapper row3">
		<div id="footer" class="clear">
			<!-- Section One -->
			<section class="one_quarter">
				<h2 class="title">Link Block</h2>
				<nav>
					<ul>
						<li><a href="#">Lorem ipsum dolor sit</a></li>
						<li><a href="#">Amet consectetur</a></li>
						<li><a href="#">Praesent vel sem id</a></li>
						<li><a href="#">Curabitur hendrerit est</a></li>
						<li class="last"><a href="#">Sed a nulla urna</a></li>
					</ul>
				</nav>
			</section>
			<!-- Section Two -->
			<section class="one_quarter">
				<h2 class="title">Link Block</h2>
				<nav>
					<ul>
						<li><a href="#">Lorem ipsum dolor sit</a></li>
						<li><a href="#">Amet consectetur</a></li>
						<li><a href="#">Praesent vel sem id</a></li>
						<li><a href="#">Curabitur hendrerit est</a></li>
						<li class="last"><a href="#">Sed a nulla urna</a></li>
					</ul>
				</nav>
			</section>
			<!-- Section Three -->
			<section class="one_quarter">
				<h2 class="title">Link Block</h2>
				<nav>
					<ul>
						<li><a href="#">Lorem ipsum dolor sit</a></li>
						<li><a href="#">Amet consectetur</a></li>
						<li><a href="#">Praesent vel sem id</a></li>
						<li><a href="#">Curabitur hendrerit est</a></li>
						<li class="last"><a href="#">Sed a nulla urna</a></li>
					</ul>
				</nav>
			</section>
			<!-- Section Four -->
			<section class="one_quarter lastbox">
				<h2 class="title">Link Block</h2>
				<nav>
					<ul>
						<li><a href="#">Lorem ipsum dolor sit</a></li>
						<li><a href="#">Amet consectetur</a></li>
						<li><a href="#">Praesent vel sem id</a></li>
						<li><a href="#">Curabitur hendrerit est</a></li>
						<li class="last"><a href="#">Sed a nulla urna</a></li>
					</ul>
				</nav>
			</section>
			<!-- / Section -->
		</div>
	</div>
	<!-- Copyright -->
	<div class="wrapper row4">
		<footer id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="https://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
		</footer>
	</div>
</body>
</html>
