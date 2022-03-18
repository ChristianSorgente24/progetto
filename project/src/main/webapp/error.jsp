<%@page import="com.milano.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>

<body>
	<%
	if (exception instanceof ClassNotFoundException) {
	%>
	<h3>Driver non found</h3>
	<p>
		<%=exception.getMessage()%>
	</p>
	<%
	} else if (exception instanceof DAOException) {
	%>
	<h3>DAOException</h3>
	<p>
		<%=exception.getMessage()%>
	</p>
	<%
	} else {
	%>

	<h3><%=exception.getClass().getName()%></h3>
	<p>
		<%=exception.getMessage()%>
		<%
		exception.printStackTrace(new PrintWriter(out));
		%>
	</p>
	<%
	}
	%>
</body>
</html>