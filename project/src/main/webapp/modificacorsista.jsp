<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@page import="com.milano.businesscomponent.CorsistaBC"%>
<%
String username = (String) session.getAttribute("username");
if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica corso</title>
<script src="js/validazionecorso.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<%
		Corsista c = AdminFacade.getInstance().getByCodCorsista(Long.parseLong(request.getParameter("corsista")));
	%>
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
				<div class="page-header">
					<h3>
						<strong>Modifica del corso</strong>
					</h3>
				</div>
				<form
					action="/<%=application.getServletContextName()%>/ModificaCorsisti"
					method="post" class="form-horizontal" id="corsoForm">
					<div class="form-group">
						<label class="col-md-1 control-label">Nome corsista</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-list-alt"></i>
								</span> <input type="text" name="nome" id="nome"
									value="<%=c.getNomeCorsista()%>"
									class="form-control"> <input type="hidden"
									name="codice"
									value="<%=c.getCodCorsista()%>">
							</div>
						</div>
						<div class="col-md-7 control-label" id="infoNome"></div>
					</div>
					<div class="form-group">
						<label class="col-md-1 control-label">Cognome corsista</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-list-alt"></i>
								</span> <input type="text" name="cognome" id="cognome"
									value="<%=c.getCognomeCorsista()%>"
									class="form-control">
							</div>
						</div>
						<div class="col-md-7 control-label" id="infoCognome"></div>
					</div>
					<div class="form-group">
						<% if (c.getPrecedentiFormativi()==0){%>
							<div class="col-md-4 inputGroupContainer">
								<label>Precedenti formativi:</label> <input type="radio"
									name="precedentiFormativi" value="1"> <label
									for="precedentiFormativi">Si</label> <input type="radio"
									name="precedentiFormativi" value="0" checked="checked" required> <label
									for="precedentiFormativi">No</label>
							</div>
						<%} else { %>
							<div class="col-md-4 inputGroupContainer">
								<label>Precedenti formativi:</label> <input type="radio"
									name="precedentiFormativi" value="1" checked="checked"> <label
									for="precedentiFormativi">Si</label> <input type="radio"
									name="precedentiFormativi" value="0" required> <label
									for="precedentiFormativi">No</label>
							</div>
						<% } %>
					</div>
						<div class="col-md-7 control-label" id="infoPF"></div>
					<div class="row">
						<div class="col-md-4  col-md-offset-1">
							<button type="submit" class="btn btn-primary">
								Modifica&nbsp;<span class="glyphicon glyphicon-ok"></span>
							</button>
						</div>
					</div>
				</form>
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