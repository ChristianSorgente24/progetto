<%@page import="com.milano.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%
String titolo = null;
String descrizione = null;

if (exception instanceof ClassNotFoundException) {
	titolo = "Driver not found";
	descrizione = exception.getMessage();
} else if (exception instanceof DAOException) {
	titolo = "DAOException";
	descrizione = exception.getMessage();
} else if (exception instanceof NullPointerException) {
	titolo = "Record not found";
	descrizione = exception.getMessage();
} else {
	titolo = exception.getClass().getName();
	descrizione = exception.getMessage();
}
%>

<!DOCTYPE html>
<html>

<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container" style="margin-top: 20px">
		<div class="panel panel-danger">
			<div class="panel-heading">
			<h1><%=titolo%>
				<span class="glyphicon glyphicon-remove-circle"
					style="font-size: 35px"></span>
			</h1>
			
				<strong><%= descrizione %></strong>
			</div>
		</div>
		
		<button type="submit" class="btn btn-primary"
			onclick="location.href = 'index.jsp';">
			<span class="glyphicon glyphicon-home" style="font-size: 15px"></span>&nbsp;Torna
			alla Home
		</button>
	</div>
</body>
</html>