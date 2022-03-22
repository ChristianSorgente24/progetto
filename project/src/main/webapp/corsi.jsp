<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.milano.businesscomponent.model.Docente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.milano.businesscomponent.model.Corsista"%>
<%@page import="com.milano.businesscomponent.model.Corso"%>
<%@page import="com.milano.businesscomponent.facade.AdminFacade"%>
<%
String username = (String) session.getAttribute("username");
if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<html>

<head>
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Lista corsi</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-left">
			<jsp:include page="sidebar.jsp" />
			<div class="col-xs-12 col-sm-9">
				<jsp:include page="side-toggle.html" />
				<div class="span12">
					<div class="menu">
						<a style="margin-left: 20px; margin-bottom: 20px;" 
							href="/<%=application.getServletContextName()%>/inseriscicorsi.jsp" class="btn btn-success">
							Inserisci nuovo corso  <span class="glyphicon glyphicon-plus"></span></a>
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<!--modello accordion-->
							<%
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

							List<Corso> corsi = Arrays.asList(AdminFacade.getInstance().getAllCorso());
							List<Corso> corsiDisponibili = AdminFacade.getInstance().corsiDisponibili();
							List<Corsista> corsisti = Arrays.asList(AdminFacade.getInstance().getAllCorsista());

							for (Corso corso : corsi) {
								List<Corsista> corsistiInCorso = Arrays
								.asList(AdminFacade.getInstance().getAllCorsistiByCodCorso(corso.getCodCorso()));

								boolean disabled = corso.isTerminato() || !corsiDisponibili.contains(corso);
							%>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab"
									id="<%=corso.getCodCorso()%>">
									<div class="panel-title">

										<div role="button" data-toggle="collapse"
											data-parent="#accordion"
											href="#collapse<%=corso.getCodCorso()%>"
											aria-expanded="false"
											aria-controls="collapse<%=corso.getCodCorso()%>">
											<%=corso.getNomeCorso()%>
											<%=disabled ? "TERMINATO" : ""%>
										</div>
										<div style="margin-top: 10px;">
											<button type="button" class="btn btn-primary"
												data-toggle="modal"
												data-target="#flipFlop<%=corso.getCodCorso()%>">
												Gestisci corso <span class="glyphicon glyphicon-cog"></span></button>
										</div>

									</div>

								</div>
								<div id="collapse<%=corso.getCodCorso()%>"
									class="panel-collapse collapse" role="tabpanel"
									aria-labelledby="<%=corso.getCodCorso()%>">
									<div class="panel-body">
										<form id="<%=corso.getCodCorso()%>"
											action="/<%=application.getServletContextName()%>/inseriscicorsista.jsp"
											method="POST">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<label>Aggiungi corsista:</label>
												</div>
												<select <%=disabled ? "disabled" : ""%>
													class="custom-select" id="inputGroupSelect01"
													name="corsista" aria-placeholder="Seleziona corsista...">
													<option value="0">NUOVO CORSISTA</option>
													<%
													for (Corsista c : corsisti) {
														if (!corsistiInCorso.contains(c)) {
													%>
													<option value="<%=c.getCodCorsista()%>"><%=c.getNomeCorsista()%>
														<%=c.getCognomeCorsista()%></option>
													<%
													}
													}
													%>
												</select> <button <%=disabled ? "disabled" : ""%>
													style="margin-left: 20px;" type="submit"
													class="btn btn-success">Aggiungi nuovo <span class="glyphicon glyphicon-plus"></span></button>
											</div>
										</form>
										<table class="table table-striped table-condensed">

											<thead>
												<tr>
													<th>Codice corsista</th>
													<th>Nome</th>
													<th>Cognome</th>
													<th>Opzioni</th>
												</tr>
											</thead>
											<tbody>
												<%
												for (Corsista c : corsisti) {
													if (corsistiInCorso.contains(c)) {
												%>
												<tr>
													<td><a
														href="/<%=application.getServletContextName()%>/corsista?corsista=<%=c.getCodCorsista()%>"><%=c.getCodCorsista()%></a></td>
													<td><%=c.getNomeCorsista()%></td>
													<td><%=c.getCognomeCorsista()%></td>
													<td><form method="POST"
															action="/<%=application.getServletContextName()%>/rimuovicorsocorsista?corso=<%=corso.getCodCorso()%>&corsista=<%=c.getCodCorsista()%>">
															<button type="submit" class="btn btn-danger"
																>Rimuovi <span class="glyphicon glyphicon-minus"></span></button>
														</form></td>
												</tr>
												<%
												}
												}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="modal fade" id="flipFlop<%=corso.getCodCorso()%>"
								tabindex="-1" role="dialog" aria-labelledby="modalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="modalLabel">Gestione corso</h4>
										</div>
										<div class="modal-body">
											<form>
												<button type="submit" formmethod="POST"
													formaction="/<%=application.getServletContextName()%>/rimuovicorso?corso=<%=corso.getCodCorso()%>"
													class="btn btn-danger">Cancella corso</button>
												<button type="submit" formmethod="POST"
													formaction="/<%=application.getServletContextName()%>/modificacorso?corso=<%=corso.getCodCorso()%>"
													class="btn btn-danger">Modifica corso</button>
											</form>
											<h3>Informazioni corso</h3>
											<%
											Docente docente = AdminFacade.getInstance().getByCodDocente(corso.getCodDocente());
											%>
											<ul>
												<li>Codice corso: <%=corso.getCodCorso()%></li>
												<li>Nome corso: <%=corso.getNomeCorso()%></li>
												<li>Data inizio: <%=formato.format(corso.getDataInizioCorso())%></li>
												<li>Data fine: <%=formato.format(corso.getDataFineCorso())%></li>
												<li>Aula corso: <%=corso.getAulaCorso()%></li>
												<li>Docente: <%=docente.getNomeDocente()%> <%=docente.getCognomeDocente()%></li>
											</ul>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Chiudi</button>
										</div>
									</div>
								</div>
							</div>
							<!-- sotto altri-->
							<%
							}
							%>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--MODAL GESTIONE CORSO-->

		<script>
			$("select").change(
					function(event) {
						var button = $(this).parent().find("button")
						var form = $(button).closest("form");
						if ($(this).find(":selected").val() == 0) {
							$(button).html("Aggiungi nuovo <span class=\"glyphicon glyphicon-plus\"></span>");
							$(form).attr(
									"action",
									"/<%=application.getServletContextName()%>/inseriscicorsista.jsp")
							$(form).attr("method", "GET");
						} else {
							$(button).html("Aggiungi <span class=\"glyphicon glyphicon-copy\"></span>");
							$(form).attr(
									"action",
									"/<%=application.getServletContextName()%>/inseriscicorsocorsista?corso="
													+ $(form).attr("id"));
									$(form).attr("method", "POST");
								}
							});
		</script>
	</div>
	<jsp:include page="footer.html" />
</body>

</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>