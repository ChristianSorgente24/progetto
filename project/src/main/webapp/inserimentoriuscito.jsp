<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="CDN.html" %>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="ISO-8859-1">
<title>Inserimento riuscito</title>

</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="container-fluid">
		<div class="page-header">
			<h3>Inserimento riuscito</h3>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Operazione riuscita</h3>
			</div>
			<div class="panel-body">
				<p>Per iscrivere altri corsicorsisti:
				<a href="inseriscicorsocorsista.jsp">cliccare qui</a></p>
				<p>Per creare altri corsi:
				<a href="inseriscicorsi.jsp">cliccare qui</a></p>
				<p>Per iscrivere altri corsisti:
				<a href="inseriscicorsista.jsp">cliccare qui</a></p>
			</div>
		</div>
	</div>	
	<footer class="footer"><%@include file="footer.html"%></footer>
</html>