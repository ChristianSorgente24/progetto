<% 

	String username = (String) session.getAttribute("username");
	if(username != null) {
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
<%@include file="CDN.html" %>
<body>
<jsp:include page="nav.jsp"/>
<jsp:include page="sidebar.jsp"/>

<div class="container">
	<div class="page-header">
	<h3><strong>Statistiche </strong></h3>
	</div>
	<%
		int ncorsisti = AdminFacade.getInstance().numeroCorsistiTotali();
		String corso = AdminFacade.getInstance().corsoPiuFrequentato();
		Date ultimoCorso = AdminFacade.getInstance().inizioUltimoCorso();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Double mediaCorsi = AdminFacade.getInstance().durataMediaCorsi();
		LinkedList<Docente> docenteMax = AdminFacade.getInstance().docenteMaxCorsi();
	%>
	 <table class="table table-striped">
	    <tbody>
	      <tr>
	        <td>Totale corsisti: </td>
	        <td><%= ncorsisti %> </td>
	      </tr>
	      <tr>
	        <td>Corso pi&ugrave; frequentato: </td>
	        <%
	        	if(corso!= null){
	        %>
	        		<td><%= corso %></td>
	        <%
	        	} else {
	        %>
	        		<td>non esiste nessun corso </td>
	        <% 
	        	}
	        %>
	        
	      </tr>
	      <tr>
	        <td>Inizio ultimo corso: </td>
	        <td><%= formato.format(ultimoCorso) %></td>
	      </tr>
	       <tr>
	        <td>Durata media dei corsi: </td>
	        <td><%= mediaCorsi %></td>
	      </tr>
	      
	       <tr>
	        <td>Docente con pi&ugrave; corsi: </td>
	        <% if (docenteMax.size()>1) { %>
	        <td>	 	
	        	<table class="table table-striped">
	        		<thead>
	        			 <tr>
		        			<th>Nome</th>
	      					<th>Cognome</th>
	        				<th>CV</th>
	        				<th>Codice</th>
	        			</tr>
	        		</thead>
	        		 <tbody>
	        		 	<tr>
	        		 	 <%
	        		 	 	for(int i=0; i<docenteMax.size(); i++) {
	        		 	 %>
	        		 		<td><%= docenteMax.get(i).getNomeDocente() %></td>
	        		 		<td><%= docenteMax.get(i).getCognomeDocente() %></td>
	        		 		<td><%= docenteMax.get(i).getCvDocente() %></td>
	        		 		<td><%= docenteMax.get(i).getCodDocente() %></td>
	        		 	<%
	        		 	 	}
	        		 	%>
	        		 	</tr>
	        		 </tbody>
	        	</table>
	        </td>
	       	 <% } else { %>
	       	 	<td><%= docenteMax.get(0).getNomeDocente() %></td>	
	        	<td><%= docenteMax.get(0).getCognomeDocente() %></td>
	        	<td><%= docenteMax.get(0).getCvDocente() %></td>
	        	<td><%= docenteMax.get(0).getCodDocente() %></td>
	        <% } %>
	      </tr>
	      
	    </tbody>
	  </table>


</div>

</body>
</html>
<%
	}else {
		response.sendRedirect("accessoNegato.jsp");
	}
%>