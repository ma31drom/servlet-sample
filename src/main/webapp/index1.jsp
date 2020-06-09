<!DOCTYPE html>
<%@page import="org.testng.TestNG"%>
<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@page import="java.util.Date"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>By PVT Servlet Demo</title>
</head>
<body>



	<%!private AtomicInteger counter = new AtomicInteger(0);%>

	<%
		out.writeln(TestNG.DEFAULT_COMMAND_LINE_SUITE_NAME);

		out.writeln(String.valueOf(counter.incrementAndGet()));
	%>
	<%@include file="module.jsp"%>
	<%
		out.write(String.valueOf(hello));
	%>



</body>
</html>