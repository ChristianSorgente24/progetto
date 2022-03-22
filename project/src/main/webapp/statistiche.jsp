<%
	String username = (String) session.getAttribute("username");
	if (username != null) {
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.milano.businesscomponent.model.Docente"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Date"%>
<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
</head>
<%@include file="CDN.html"%>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
				<div class="page-header">
					<h3>
						<strong>Statistiche </strong>
					</h3>
				</div>
				<%
				int ncorsisti = AdminFacade.getInstance().numeroCorsistiTotali();
				String corso = AdminFacade.getInstance().getByCodCorso(Long.parseLong(AdminFacade.getInstance().corsoPiuFrequentato())).getNomeCorso();
				Date ultimoCorso = AdminFacade.getInstance().inizioUltimoCorso();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Double mediaCorsi = AdminFacade.getInstance().durataMediaCorsi();
				LinkedList<String> docenteMax = AdminFacade.getInstance().docenteMaxCorsi();
				%>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td>Totale corsisti:</td>
							<td><%=ncorsisti%></td>
						</tr>
						<tr>
							<td>Corso pi&ugrave; frequentato:</td>
							<%
							if (corso != null) {
							%>
							<td><%=corso%></td>
							<%
							} else {
							%>
							<td>Non sono presenti corsi</td>
							<%
							}
							%>

						</tr>
						<tr>
							<td>Inizio ultimo corso:</td>
							<td><%=formato.format(ultimoCorso)%></td>
						</tr>
						<tr>
							<td>Durata media dei corsi:</td>
							<td><%=mediaCorsi.intValue()%> giorni lavorativi</td>
						</tr>

						<tr>
							<td>Docente con pi&ugrave; corsi:</td>
							<td><%= docenteMax.getFirst() %></td>

						</tr>

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