
<%
String username = (String) session.getAttribute("username");
if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<jsp:useBean id="corsista"
	class="com.milano.businesscomponent.model.Corsista" scope="session" />
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Corsisti</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
				<div class="page-header">
					<h3>
						<span><strong>Elenco Corsisti</strong></span>
					</h3>
				</div>
				<a style="margin-bottom: 20px;" href="inseriscicorsista.jsp"
					class="btn btn-success"> Nuovo Corsista <span
					class="glyphicon glyphicon-plus"></span>
				</a>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID Corsista</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Precedenti Formativi</th>
						</tr>
					</thead>
					<tbody>
						<%
						Corsista[] d = AdminFacade.getInstance().getAllCorsista();
						for (int i = 0; i < d.length; i++) {
						%>
						<tr
							onclick="window.location='corsista.jsp?corsista=<%=d[i].getCodCorsista()%>';"
							style="cursor: pointer">
							<td><%=d[i].getCodCorsista()%></td>
							<td><%=d[i].getNomeCorsista()%></td>
							<td><%=d[i].getCognomeCorsista()%></td>
							<td style="padding-left: 15px">
								<%
								if (d[i].getPrecedentiFormativi() == 1) {
								%> <span class="glyphicon glyphicon-check"></span> <%
 }
 %>
							</td>
							<td><a
								href="/<%=application.getServletContextName()%>/rimuoviCorsista?codCorsista=<%=d[i].getCodCorsista()%>"
								class="btn btn-danger"> Elimina Corsista <span
									class="glyphicon glyphicon-minus"></span>
							</a>
							<a
								href="/<%=application.getServletContextName()%>/modificacorsista.jsp?corsista=<%=d[i].getCodCorsista()%>"
								class="btn btn-primary"> Modifica Corsista <span
									class="glyphicon glyphicon-wrench"></span>
							</a>
							</td>

						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.html" />
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>
