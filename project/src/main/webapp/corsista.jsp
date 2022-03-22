
<%@page import="com.milano.businesscomponent.model.Corso"%>
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
<title>Corsista</title>
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
						<%
							long codCorsista = Long.parseLong(request.getParameter("corsista"));
						%>
						<span><strong>Elenco corsi frequentati da <%=AdminFacade.getInstance().getByCodCorsista(codCorsista).getNomeCorsista() %> <%=AdminFacade.getInstance().getByCodCorsista(codCorsista).getCognomeCorsista() %></strong></span>
					</h3>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nome Corso</th>
							<th>Data Inizio</th>
							<th>Data Fine</th>
						</tr>
					</thead>
					<tbody>
						<%
						Corso[] c = AdminFacade.getInstance().getCorsi(codCorsista);
						for (int i = 0; i < c.length; i++) {
						%>
						<tr>
							<td><%=c[i].getNomeCorso()%></td>
							<td><%=c[i].getDataInizioCorso()%></td>
							<td><%=c[i].getDataFineCorso()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<button type="submit" class="btn btn-primary"
					onclick="location.href = 'corsisti.jsp';" style="margin-bottom: 10px;">
					<span class="glyphicon glyphicon-arrow-left" style="font-size: 15px"></span>&nbsp;Torna alla Lista Corsisti
				</button>
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