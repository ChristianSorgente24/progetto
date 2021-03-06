<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="CDN.html" %>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta charset="ISO-8859-1">
	<title>Accesso Admin</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container-fluid">
		<div class="page-header">
			<h3>Inserire i dati per effettuare il login</h3>
		</div>
		<form action="/<%= application.getServletContextName()%>/controlloLogin" method="post"
		class="form-horizontal" style="margin-bottom:20px">
		
			<div class="form-group">
				<label class="col-md-1 control-label">Username</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="username" placeholder="Username..." required class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label"></div>
			</div>
			
			<div class="form-group">
				<label class="col-md-1 control-label">Codice</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						<input type="text" name="codadmin" placeholder="Codice..." required class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label"></div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-primary">
						Login&nbsp;<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
	<footer><jsp:include page="footer.html"/></footer>
</body>
</html>