<!DOCTYPE html>
<%@page import="by.pvt.models.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="translations" var="messages" />

<html lang="en" dir="ltr">
<head>
<title>Basic 88</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
</head>

<c:set var="today" scope="page" value="${requestScope.currentDate}" />

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
					<jsp:useBean id="userinfo" class="by.pvt.models.UserInfo"></jsp:useBean>
					<jsp:setProperty property="*" name="userinfo" />



					<li>Hello <c:out value="${sessionScope.loggedUser}"
							default="Anonymous" />!
					</li>
					<li><a href="#">Text Link</a></li>
					<li><a href="#">Text Link</a></li>
					<li><a href="#">Text Link</a></li>
					<li class="last">Today is <c:out value="${today}" /></li>
				</ul>
			</nav>
		</header>
	</div>
	<!-- content -->
	<div class="wrapper row2">
		<div id="container" class="clear">
			<!-- Slider -->
			<section id="slider">
				<!--<c:if test="${sessionScope.loggedUser == null}">-->
				<form action="in" method="post">
					<fmt:message key="login.username" bundle="${messages}" />
					: <input type="text" name="username"><br>
					<fmt:message key="login.password" bundle="${messages}" />
					: <input type="password" name="password"><br>
					<fmt:message key="login.age" bundle="${messages}" />
					: <input type="text" name="age"><br> <input
						type="submit"
						value="<fmt:message key="login.submit" bundle="${messages}" />">
				</form>
				<!--</c:if>-->
			</section>
			<!-- main content -->
			<div id="homepage">
				<!-- Services -->
				<!-- / Services -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- ########################################################################################## -->
				<!-- Introduction -->

				<c:forEach var="newsRecord" items="${requestScope.news}">
					<section id="intro" class="last clear">
						<article>
							<figure>
								<img src="${newsRecord.imgUrl}" width="450" height="250" alt="">
								<figcaption>
									<h2>${newsRecord.header}</h2>
									<p>${newsRecord.text}</p>
									<footer class="more">
										<a href="#">Read More &raquo;</a>
									</footer>
								</figcaption>
							</figure>
						</article>
						<br />
					</section>
				</c:forEach>



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
