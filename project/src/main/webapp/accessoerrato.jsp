<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Accesso negato</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="jumbotron">
			<h1>
				Accesso errato <span class="glyphicon glyphicon-remove-circle"
					style="font-size: 35px"></span>
			</h1>
			<p>Password e/o Username errati</p>
		</div>
		<button type="submit" class="btn btn-primary"
			onclick="window.history.back()">
			<span class="glyphicon glyphicon-chevron-left" style="font-size: 15px"></span>&nbsp;Torna
			Indietro
		</button>
	</div>
</body>
</html>