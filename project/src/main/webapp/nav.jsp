<div class="navbar navbar-fixed-top navbar-default" role="navigation"
	style="background-color: #3c3d41;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp" style="color: #FFFFFFCC;"
				onmouseover="this.style.color='#FFFFFFB3'"
				onmouseout="this.style.color='#FFFFFFCC'">Project Betacom</a>
		</div>
		<div class="collapse navbar-collapse navbar-right">
			<ul class="nav navbar-nav">
				<%
				String admin = (String) session.getAttribute("username");
				if (admin == null) {
				%>
				<li><a href="login.jsp"  style="color: #FFFFFFCC;"
					onmouseover="this.style.color='#FFFFFFB3'"
					onmouseout="this.style.color='#FFFFFFCC'"> <span
						class="glyphicon glyphicon-log-in"></span> Login
				</a></li>
				<%
				} else {
				%>
				<li><a href="#" style="color: #FFFFFFCC;cursor:default"> <span
						class="glyphicon glyphicon-user"></span> <%=admin%>
				</a></li>
				<li><a href="logout.jsp" style="color: #FFFFFFCC;"
					onmouseover="this.style.color='#FFFFFFB3'"
					onmouseout="this.style.color='#FFFFFFCC'"> <span
						class="glyphicon glyphicon-off"></span> Logout
				</a></li>
				<%
				}
				%>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</div>
<!-- /.navbar -->