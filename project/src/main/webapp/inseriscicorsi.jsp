<%@page import="com.milano.businesscomponent.model.Docente"%>
<%@page import="com.milano.businesscomponent.DocenteBC"%>
<%
	String username = (String) session.getAttribute("username");
	if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="CDN.html" %>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta charset="ISO-8859-1">
	<title>Inserisci corsi</title>
<script src="js/validazionecorso.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container-fluid">
	<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
		<div class="page-header">
			<h3><strong>Inseririsci nuovo corso</strong></h3>
		</div>
		<form action="/<%= application.getServletContextName()%>/InserisciCorso" method="post"
		class="form-horizontal" id="corsoForm">
		
		<div class="form-group">
			<label class="col-md-1 control-label">Nome corso</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-list-alt"></i>
					</span>
					<input type="text" name="nome" id="nome" placeholder="Nome corso..." class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoNome"></div>
		</div>

		<div class="form-group">
			<label class="col-md-1 control-label">Data inizio corso</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group date" id="dp1">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-calendar"></i>
					</span>
					<input type="text" name="dataInizio" id="dataInizio" placeholder="dd/MM/yyyy" class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoDataInizio"></div>
		</div>

		<div class="form-group">
			<label class="col-md-1 control-label">Data fine corso</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group date" id="dp2">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-calendar"></i>
					</span>
					<input type="text" name="dataFine" id="dataFine" placeholder="dd/MM/yyyy" class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoDataFine"></div>
		</div>


	
		<div class="form-group">
			<label class="col-md-1 control-label">Costo corso</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-euro"></i>
					</span>
					<input type="text" name="costo" id="costo" placeholder="Costo corso..." class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoCosto"></div>
		</div>
		
		<div class="form-group">
			<label class="col-md-1 control-label">Aula corso</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-home"></i>
					</span>
					<input type="text" name="aula" id="aula" placeholder="Aula..." maxlength="5" class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoAula"></div>
		
		</div>

		<div class="form-group">
			<label class="col-md-1 control-label">Codice docente</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<select name="codDocente" class="col-md-3 form-control">
					<%
					  DocenteBC dBC = new DocenteBC();
					  Docente[] docenti = dBC.getAll();
					  for (Docente d : docenti) {
					%>
					  <option value="<%=d.getCodDocente()%>">
					  		<%= d.getCodDocente() %>
					  </option>
					<% } %>	
					</select>			
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoCodDocente"></div>
		</div>
		

			
		<div class="row">
			<div class="col-md-4  col-md-offset-1">
				<button type="submit" class="btn btn-primary">
					Aggiungi&nbsp;<span class="glyphicon glyphicon-ok"></span>
				</button>
			</div>
		</div>
	</form>
	</div>	
	</div>
	</div>
	<script type="text/javascript">
	$(function () {
        $("#dp1").datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true,
            startDate: '01/01/1900',
            endDate: '01/01/3000'
        }).on('changeDate',function (e) {
                $('#corsoForm').bootstrapValidator('revalidateField', 'dataInizio');
        }).on('hide', function () {
                console.log("ad");
                $("#dp2").datepicker("setStartDate",
                    new Date($('#dp1').datepicker('getDate'))
                );
                $("#dp1").datepicker({ dateFormat: "dd/mm/yy" });
        });
    });

    $(function () {
        $("#dp2").datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true,
            startDate: '01/01/1900',
            endDate: '01/01/3000'
        }).on('changeDate',
            function (e) {
                $('#corsoForm').bootstrapValidator('revalidateField', 'dataInizio');
        })
    });
	
	</script>
</body>
<jsp:include page="footer.html"/>
</html>
<%
	} else {
	response.sendRedirect("accessonegato.jsp");
	}
%>