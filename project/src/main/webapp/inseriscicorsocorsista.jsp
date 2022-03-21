<%@page import="com.milano.businesscomponent.CorsistaBC"%>
<%@page import="com.milano.businesscomponent.CorsoBC"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%@page import="com.milano.businesscomponent.model.CorsoCorsista"%>
<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%
String username = (String) session.getAttribute("username");
if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@include file="CDN.html"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width, initial-scale= 1">
<link rel="stylesheet" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Corso Corsisti</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
				<div class="page header">
					<h3>Inserimento nel Corso di un Corsista</h3>
					<div class="table responsive">
						<form
							action="/<%=application.getServletContextName()%>/inseriscicorsocorsista"
							method="post">
							<div class="row">
							<table class="table table-striped">
								<tr class="row">
									<td class="col-md-4"><select name="corsi" class="form-control" >
											<%
											String corsoDefault = request.getParameter("corso");
											corsoDefault = "java";
											CorsoBC cBC = new CorsoBC();
											Corso[] corsi = cBC.getAll();
											for (Corso c : corsi)
												if (!corsoDefault.equals(c.getNomeCorso())) {
											%>
											<option value="<%=c.getCodCorso()%>"><%=c.getNomeCorso()%></option>
											<%
											} else {
											%>
											<option value="<%=c.getCodCorso()%>" selected><%=c.getNomeCorso()%></option>
											<%
											}
											%>
									</select></td>
									<td class="col-md-4"><select name="corsisti" class="col-md-3 form-control">
											<%
											CorsistaBC csBC = new CorsistaBC();
											Corsista[] corsisti = csBC.getAll();
											for (Corsista cs : corsisti) {
											%>
											<option value="<%=cs.getCodCorsista()%>"><%=cs.getNomeCorsista()%>
												<%=cs.getCognomeCorsista()%></option>
											<%
											}
											%>
									</select></td>
									<td><input type="submit"
										value="Inserisci Corsista nel Corso" class="col-md-4 btn btn-primary">
									</td>
								</tr>
							</table>
							</div>
						</form>
					</div>
				</div>
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
