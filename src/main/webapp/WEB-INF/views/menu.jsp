
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div data-ng-controller="loginController" data-ng-init="login()">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" data-ng-href="#">Academy</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a
						data-ng-href="<c:url value="/Cart/home"/>">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">List <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a data-ng-href="<c:url value="/Cart/ListView"/>">Item</a></li>
							<li><a data-ng-href="<c:url value="/User/ListView"/>">User</a></li>
						</ul></li>
				</ul>
				<ul data-ng-show="user!=null" class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#"
						  >{{user.name}} <span class=""></span></a>
					</li>

				</ul>
				<ul data-ng-show="user==null" class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Login <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<div class="container">
									<!-- form here -->
									<br />
									<form class="well" name='f'
										action='/academy/j_spring_security_check' method='POST'>
										<div class="container">
											<div class="form-group">
												<div class="col-sm-6">
													<input type="text" class="form-control input-group-lg"
														name="j_username" placeholder="User Name"
														data-ng-required="true">



												</div>
											</div>

											<br /> <br />
											<div class="form-group">
												<div class="col-sm-6">
													<input type="password" class="form-control input-group-lg"
														name="j_password" placeholder="Password*"
														data-ng-required="true">

												</div>


											</div>
											<br /> <br />
											<div class="form-group">
												<div class="col-sm-6">
													<button name="submit" type="submit" class="btn btn-info"
														data-ng-disabled="f.$invalid">Submit</button>
												</div>


											</div>
										</div>
									</form>
								</div> <!-- /container -->
							</li>

						</ul></li>

				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</div>

