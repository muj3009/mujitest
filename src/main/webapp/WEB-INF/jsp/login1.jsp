
<%@include file="../jsp/fragments/header.jspf"%>


<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="/">Home</a></li>
					<li> <a href="/login">Sign in</a></li>
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
    				
				
	<div class="col-md-12">			
    <div class="box">
	<div class="omb_login">
	
		<h1 class="omb_authTitle">
			Login or <a href="/register">Sign up</a>
		</h1>
		<div class="row omb_row-sm-offset-3">
        <div class="col-xs-12 col-sm-6">
        <p class="lead">Already our customer?</p>
        </div>
        </div>
		<div class="row omb_row-sm-offset-3 omb_socialButtons">
			<div class="col-xs-4 col-sm-2">
				<a href="#" class="btn btn-lg btn-block omb_btn-facebook"> <i
					class="fa fa-facebook visible-xs"></i> <span class="hidden-xs">Facebook</span>
				</a>
			</div>
			<div class="col-xs-4 col-sm-2">
				<a href="#" class="btn btn-lg btn-block omb_btn-twitter"> <i
					class="fa fa-twitter visible-xs"></i> <span class="hidden-xs">Twitter</span>
				</a>
			</div>
			<div class="col-xs-4 col-sm-2">
				<a href="#" class="btn btn-lg btn-block omb_btn-google"> <i
					class="fa fa-google-plus visible-xs"></i> <span class="hidden-xs">Google+</span>
				</a>
			</div>
		</div>
        
        
        
		<!-- 		<div class="row text-center"> -->
		<!-- 			<div class="col-md-4 col-sm-12"> -->
		<!-- 				<button type="button" class="btn btn-primary btn-block">Facebook</button> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-4 col-sm-12"> -->
		<!-- 				<button type="button" class="btn btn-info btn-block">Twitter</button> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-4 col-sm-12"> -->
		<!-- 				<button type="button" class="btn btn-danger btn-block">Google+</button> -->
		<!-- 			</div> -->
		<!-- 		</div> -->



		<div class="row omb_row-sm-offset-3 omb_loginOr">
			<div class="col-xs-12 col-sm-6">
				<hr class="omb_hrOr">
				<span class="omb_spanOr">or</span>
			</div>
		</div>

		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-6">


				<form:form class="omb_loginForm" role="form" autocomplete="on" method="POST">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input id="username" type="text" class="form-control" name="username"
							placeholder="Email address">
					</div>
					<span class="help-block"></span>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input id="password" type="password" class="form-control" name="password"
							placeholder="Password">
					</div>
					<span class="help-block"></span>

					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form:form>


			</div>
		</div>
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-3">
				<label class="checkbox"> <input type="checkbox"
					value="remember-me">Remember Me
				</label>
			</div>
			<div class="col-xs-12 col-sm-3">
				<p class="omb_forgotPwd">
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>
		</div>
	</div>
    </div>


</div>
<%@include file="../jsp/fragments/footer.jspf"%>

<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
<%@include file="../jsp/fragments/copyright.jspf"%>
<!-- *** COPYRIGHT END *** -->