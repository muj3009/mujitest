<%@include file="../jsp/fragments/header.jspf"%>
<div id="all">

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li>New account / Sign in</li>
					<li><c:url var="logoutUrl" value="/logout" /><a href="#"
						onclick="document.getElementById('logoutForm').submit()"> Sign out</a></li>
				</ul>

				<c:if test="${not empty flashMessage}">
					<div class="alert alert-${flashKind} }alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
						${flashMessage}
					</div>
				</c:if>

			</div>


 			<div class="col-md-12"> 
				<div class="box">
					<h1>New account</h1>

					<p class="lead">Not our registered customer yet?</p>
					<p>With registration with us new world of fashion, fantastic
						discounts and much more opens to you! The whole process will not
						take you more than a minute!</p>
					<p class="text-muted">
						If you have any questions, please feel free to <a href="contact">contact
							us</a>, our customer service center is working for you 24/7.
					</p>

				
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
			
			
													<form:form modelAttribute="signupForm" method="post">
														<div class="form-group">
															<form:label path="email" for="email">Email Address</form:label>
															<form:input path="email" type="text" class="form-control"
					 										id="email" placeholder="Email Address" />
					 										<form:errors cssClass="error" path="email" />
					 										  
														</div>
														<div class="form-group">
															<form:label path="Name" for="name">Name</form:label>
															<form:input path="Name" type="text" class="form-control"
					 			 								id="name" placeholder="Name" />
					 			 								<form:errors cssClass="error" path="name" /> 
														</div>
														<div class="form-group">
															<form:label path="password" for="password">Password</form:label>
															<form:input path="password" type="password" class="form-control"
					 			 								id="password" placeholder="Password" />
					 			 								<form:errors cssClass="error" path="password" />  
														</div>
														<div class="text-center">
															<button type="submit" class="btn btn-primary">
																<i class="fa fa-user-md"></i> Register
															</button>
														</div>
													</form:form>

					
				</div>
 			</div> 


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
