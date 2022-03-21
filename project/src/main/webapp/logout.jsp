
<%
session.invalidate();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Logout</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container" style="margin-top: 20px">
		<div class="jumbotron">
			<h1>
				Logout <span class="glyphicon glyphicon-remove-circle"
					style="font-size: 35px"></span>
			</h1>
			<p>Disconnesso</p>
		</div>
		<button type="submit" class="btn btn-primary"
			onclick="location.href = 'index.jsp';">
			<span class="glyphicon glyphicon-home" style="font-size: 15px"></span>&nbsp;Torna
			alla Home
		</button>
	</div>
</body>
</html>