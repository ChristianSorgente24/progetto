<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="listaCorsisti.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="mioMenu">
			<%
			String admin = (String) session.getAttribute("username");
			if(admin == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">
						<span class="glyphicon glyphicon-log-in"></span> Login
				</a></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav">
				<li>
					<span class="glyphicon glyphicon-off"></span> <%=admin%>
				</li>
				<li><a href="logout.jsp">
					<span class="glyphicon glyphicon-off"></span> Logout
				</a></li>
			</ul>
			<%
			}
			%>
		</div>
	</div>
</nav>