<%@include file="../jsp/fragments/header.jspf"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li>New account / Sign in</li>
				</ul>

				<c:if test="${not empty flashMessage}">
					<div class="alert alert-${flashKind} }alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
						${flashMessage}
					</div>
				</c:if>

				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						Invalid username and password.
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
					</div>

				</c:if>

				<c:if test="${param.logout != null}">
					<div class="alert alert-danger">
						You have been logged out.
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
					</div>

				</c:if>
				
				

			</div>
						<div class="col-md-6mine">
				<div class="box">
					<h1>Login</h1>

					<p class="lead">Already our customer?</p>


					<div class="row text-center">
						<div class="col-md-4 col-sm-12">
							<button type="button" class="btn btn-primary btn-block">Facebook</button>
						</div>
						<div class="col-md-4 col-sm-12">
							<button type="button" class="btn btn-info btn-block">Twitter</button>
						</div>
						<div class="col-md-4 col-sm-12">
							<button type="button" class="btn btn-danger btn-block">Google+</button>
						</div>
					</div>

					<hr>
					<li><c:url var="logoutUrl" value="/logout" /> <form:form
							id="logoutForm" action="${logoutUrl}" method="post">
						</form:form> <a href="#"
						onclick="document.getElementById('logoutForm').submit()"><span
							class="glyphicon glyphicon-log-out"></span> Sign out</a></li>

					<p class="text-muted">Pellentesque habitant morbi tristique
						senectus et netus et malesuada fames ac turpis egestas. Vestibulum
						tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
						Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
						vitae est. Mauris placerat eleifend leo.</p>

					<hr>


					<%-- 										<form:form role="form" method="post"> --%>
					<!-- 											<div class="form-group"> -->
					<!-- 												<label for="email">Email</label> <input type="text" -->
					<!-- 													class="form-control" id="email"> -->
					<!-- 											</div> -->
					<!-- 											<div class="form-group"> -->
					<!-- 												<label for="password">Password</label> <input type="password" -->
					<!-- 													class="form-control" id="password"> -->
					<!-- 											</div> -->
					<!-- 											<div class="text-center"> -->
					<!-- 												<button type="submit" class="btn btn-primary"> -->
					<!-- 													<i class="fa fa-sign-in"></i> Log in -->
					<!-- 												</button> -->
					<!-- 											</div> -->
					<%-- 										</form:form> --%>

					<form:form action="/login" role="form" method="post">

						<div class="form-group">
							<label for="username">Email address</label> <input id="username"
								name="username" type="email" class="form-control"
								placeholder="Enter email" />
							<p class="help-block">Enter your email address.</p>
						</div>

						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								id="password" name="password" class="form-control"
								placeholder="Password" />
							<form:errors cssClass="error" path="password" />
						</div>

<!-- 						<button type="submit" class="btn btn-primary">Sign In</button> -->
						<div class="text-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-sign-in"></i> Log in
							</button>
						</div>

					</form:form>
				</div>
			</div>


		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->


</div>

<!-- *** FOOTER ***
 _________________________________________________________ -->
<%@include file="../jsp/fragments/footer.jspf"%>
<!-- /#footer -->

<!-- *** FOOTER END *** -->




<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
<%@include file="../jsp/fragments/copyright.jspf"%>
<!-- *** COPYRIGHT END *** -->

</body>

</html>