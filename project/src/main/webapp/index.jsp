<%
	String username = (String) session.getAttribute("username");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>	
	<jsp:include page="nav.jsp"/>
	<%
		if(username != null) {
	%>
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9" style="padding:0; margin:0">
				<jsp:include page="side-toggle.html" />
	<% 
		}
	%>
	<div id="IMGsample">
		<img src ="images/sample course.jpg" style="position:relative"/>
	</div>
	<%
		if(username != null) {
	%>
			</div>
		</div>
	</div>
	<% 
		}
	%>
	<jsp:include page="footer.html"/>
</body>
	
</html>