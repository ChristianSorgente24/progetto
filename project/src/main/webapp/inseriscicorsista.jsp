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
<title>Inserisci Corsista</title>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<jsp:include page="nav.jsp"/>
	<div class="container-fluid">
		<div class="page-header">
			<h3>Inserire i dati per un nuovo corsista</h3>
		</div>
		<form action="/<%= application.getServletContextName()%>/InserisciCorsista" method="post"
		class="form-horizontal">
		
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="nomeCorsista" placeholder="Nome..." required class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label"></div>
			</div>
			
			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="cognomeCorsista" placeholder="Cognome..." required class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label"></div>
			</div>
			
			<div class="form-group">
				<label class="col-md-1 control-label">Precedenti formativi</label>
				<div class="col-md-4 inputGroupContainer">
					<label for="precedentiFormativi">Si</label>
					<input type="radio" name="precedentiFormativi" value="1">
					<label for="precedentiFormativi">No</label>
					<input type="radio" name="precedentiFormativi" value="0">
				</div>
				<div class="col-md-7 control-label"></div>
			</div>
			
			
			
			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-primary">
						Aggiungi&nbsp;<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
	<footer><jsp:include page="footer.html"/></footer>
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>
