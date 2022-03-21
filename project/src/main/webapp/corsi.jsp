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
				<div class="row">
					<div class="span12">
						<div class="menu">
							<div class="panel-group" id="accordion" role="tablist"
								aria-multiselectable="true">
								<!--modello accordion-->
								<%
								List<Corso> corsi = Arrays.asList(AdminFacade.getInstance().getAllCorso());
								List<Corso> corsiDisponibili = AdminFacade.getInstance().corsiDisponibili();
								List<Corsista> corsisti = Arrays.asList(AdminFacade.getInstance().getAllCorsista());
								
								for (Corso corso : corsi) {
									List<Corsista> corsistiInCorso = Arrays
									.asList(AdminFacade.getInstance().getAllCorsistiByCodCorso(corso.getCodCorso()));
									
									boolean disabled =  corso.isTerminato() || !corsiDisponibili.contains(corso);
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
												<%=corso.getNomeCorso()%> <%= disabled ? "TERMINATO" : "" %>
											</div>
											<div style="margin-top: 10px;">
												<button type="button" class="btn btn-primary"
													data-toggle="modal" data-target="#flipFlop">
													Gestisci corso</button>
											</div>

										</div>

									</div>
									<div id="collapse<%=corso.getCodCorso()%>"
										class="panel-collapse collapse" role="tabpanel"
										aria-labelledby="<%=corso.getCodCorso()%>">
										<div class="panel-body">
											<form id="<%=corso.getCodCorso()%>"
												action="/<%=application.getServletContextName()%>/inseriscicorsista.jsp?corso=<%=corso.getCodCorso()%>"
												method="POST">
												<div class="input-group mb-3">
													<div class="input-group-prepend">
														<label>Aggiungi corsista:</label>
													</div>
													<select <%= disabled ? "disabled" : "" %> class="custom-select" id="inputGroupSelect01"
														name="corsista"
														aria-placeholder="Seleziona corsista...">
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
													</select> 
													<input <%= disabled ? "disabled" : "" %> style="margin-left: 20px;" type="submit"
														class="btn btn-success" value="Aggiungi nuovo" />
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
														<td><%=c.getCodCorsista()%></td>
														<td><%=c.getNomeCorsista()%></td>
														<td><%=c.getCognomeCorsista()%></td>
														<td><form method="POST"
																action="/<%=application.getServletContextName()%>/rimuovicorsocorsista?corso=<%=corso.getCodCorso()%>&corsista=<%=c.getCodCorsista()%>">
																<input type="submit" class="btn btn-danger" value="Rimuovi"/>
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
								<div class="modal fade" id="flipFlop" tabindex="-1"
									role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="modalLabel">Gestione corso
													</h4>
											</div>
											<div class="modal-body">
												<button type="button" class="btn btn-danger">Ferma
													corso</button>
												<button type="button" class="btn btn-primary">Modifica
													corso</button>
												<h3>Informazioni corso</h3>
												<p>Lorem ipsum dolor sit amet consectetur, adipisicing
													elit. Voluptas repellendus nihil in amet nemo qui quia
													cupiditate hic. Sed dolorem impedit in fuga expedita
													quaerat ipsum perferendis veritatis debitis similique.</p>
												<h3>Commenti corso</h3>
												<p>Lorem, ipsum dolor sit amet consectetur adipisicing
													elit. Et alias sapiente inventore, fugit accusamus repellat
													dicta voluptas, ad blanditiis reiciendis nostrum officiis,
													ipsam temporibus libero! Ullam enim qui ratione autem eaque
													assumenda. Corporis tempore in et culpa ipsum sint magni,
													doloremque provident vero repellat, aspernatur ex aut
													tempora eum veritatis!</p>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
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
		</div>
		<!--MODAL GESTIONE CORSO-->

		<script>
			$("select").change(
					function(event) {
						var button = $(this).parent().find("input")
						var form = $(button).closest("form");
						if ($(this).find(":selected").val() == 0) {
							$(button).val("Aggiungi nuovo");
							$(form).attr(
									"action",
									"/<%=application.getServletContextName()%>/inseriscicorsista.jsp?corso="
											+ $(form).attr("id"))
							$(form).attr("method", "GET");
						} else {
							$(button).val("Aggiungi");
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