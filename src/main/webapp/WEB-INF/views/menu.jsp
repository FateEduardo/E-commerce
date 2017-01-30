   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <a class="navbar-brand" data-ng-href="#">Academy</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a data-ng-href="<c:url value="/Cart/home"/>">Home</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a data-ng-href="<c:url value="/Cart/ListView"/>">Cart</a></li>
                <li><a data-ng-href="<c:url value="/User/ListView"/>">User</a></li>
              </ul>
            </li>
          </ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Login <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="container">
								<form class="form-signin">
									<h2 class="form-signin-heading">Please sign in</h2>
									<label for="username" class="sr-only">User Name</label> <input
										type="email" id="inputEmail" class="form-control"
										placeholder="User Name" required autofocus> 
										<br/>
										<label
										for="inputPassword" class="sr-only">Password</label> <input
										type="password" id="inputPassword" class="form-control"
										placeholder="Password" required>
									<div class="checkbox"></div>
									<button class="btn btn-warning" type="submit">Sign in</button>
								</form>
								<br />
							</div> <!-- /container -->
						</li>

					</ul>
					</li>

			</ul>
		</div><!--/.nav-collapse -->
      </div>
    </nav>          
 
        
