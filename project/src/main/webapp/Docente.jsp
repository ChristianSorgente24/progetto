<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Docente"%>
<% 
	String username = (String) session.getAttribute("username");
	if(username != null){
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@include file="CDN.html"%>

<jsp:useBean id="docente" class= "com.milano.businesscomponent.model.Docente" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Docenti</title>

</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
		<div class="page header">
			<h3>Docenti</h3>
		</div>
		<div class ="table responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Cv</th>
						<th>Codice</th>
					</tr>
				</thead>
				<tbody>
					<%
						Docente[] d = AdminFacade.getInstance().getAll();
						for(int i =0;i<d.length; i++){
					%>
					<tr>
						<td><%=d[i].getNomeDocente()%></td>
						<td><%=d[i].getCognomeDocente()%></td>
						<td><%=d[i].getCvDocente()%></td>
						<td><%=d[i].getCodDocente()%></td>
						<td>
						<form action="/<%=application.getServletContextName()%>/aggiungi" method="post">
						<input type="hidden" name="id" value ="<%=d[i].getNomeDocente()%>">
						<input type="hidden" name="marca" value ="<%=d[i].getCognomeDocente()%>">
						<input type="hidden" name="modello" value ="<%=d[i].getCvDocente()%>">
						<input type="hidden" name="prezzo" value ="<%=d[i].getCodDocente()%>">
						</td>
						</tr>
						<% 
							}
						%>
				</tbody>
				</form>	
			</table>
		</div>
</div>
<hr>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%} else {
	response.sendRedirect("accessonegato.jsp");
} %>