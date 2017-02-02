<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
					<li class="active">
					<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
					
					<a	data-ng-href="<c:url value="/"/>">Home</a></li>
						</sec:authorize>
							<sec:authorize ifAnyGranted="ROLE_ADMIN">
					
					<a	data-ng-href="<c:url value="/admin/home"/>">Home</a></li>
						</sec:authorize>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">List <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<sec:authorize ifAnyGranted="ROLE_ADMIN">
								<li><a data-ng-href="<c:url value="/admin/listItemView"/>">Item</a></li>
								<li><a data-ng-href="<c:url value="/admin/listUserView"/>">User</a></li>
							</sec:authorize>
							<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
										<li><a data-ng-href="<c:url value="user/listItemView"/>">All</a></li>
								<li><a data-ng-href="<c:url value="/admin/listItemView"/>">Shoes</a></li>
								<li><a data-ng-href="<c:url value="/admin/listUserView"/>">Sweater</a></li>
							
							</sec:authorize>
						</ul></li>
				</ul>
				<ul data-ng-show="user!=null" class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#"
						  >{{user.name}} <span class=""></span></a>
					</li>

				</ul>
			 <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
				<ul class="nav navbar-nav navbar-right">
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
</sec:authorize>
<sec:authorize  ifNotGranted="ROLE_ANONYMOUS">
 <a href="<c:url value="/j_spring_security_logout" />" class="navbar-brand navbar-right">Logout</a>
</sec:authorize>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</div>

