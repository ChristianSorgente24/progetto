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
	<div class="container" style="margin-top: 20px">
		<div class="jumbotron">
			<h1>
				Accesso negato <span class="glyphicon glyphicon-remove-circle"
					style="font-size: 35px"></span>
			</h1>
			<p>Non hai effettuato il login</p>
		</div>
		<button type="submit" class="btn btn-primary"
			onclick="location.href = 'login.jsp';">
			<span class="glyphicon glyphicon-log-in" style="font-size: 15px"></span>&nbsp;
			login
		</button>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>