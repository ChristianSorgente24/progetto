<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="CDN.html" %>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica riuscita</title>

</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="container-fluid">
		<div class="page-header">
			<h3>Modifica riuscita</h3>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Operazione riuscita</h3>
			</div>
			<div class="panel-body">
				<!--<p>Per iscrivere altri corsicorsisti:
				<a href="inseriscicorsocorsista.jsp">cliccare qui</a></p>-->
				<p>Per tornare alla lista corsi:
				<a href="corsi.jsp">cliccare qui</a></p>
				<p>Per tornare alla lista corsiti:
				<a href="corsisti.jsp">cliccare qui</a></p>
			</div>
		</div>
	</div>	
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>