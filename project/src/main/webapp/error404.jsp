<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error404</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container" style="margin-top: 20px">
		<div class="jumbotron">
			<h1>Errore 404  <span class="glyphicon glyphicon-remove-circle"
					style="font-size: 35px"></span></h1>
			<p>
				Pagina non trovata
			</p>
		</div>
		<button type="submit" class="btn btn-primary"
			onclick="location.href = 'index.jsp';">
			<span class="glyphicon glyphicon-home" style="font-size: 15px"></span>&nbsp;Torna
			alla Home
		</button>
	</div>
</body>
</html>