
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section id="what-we-do" class="what-we-do">
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<a href="<c:url value="/User/addView"/>">
					
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="do-box text-center">
								<i class="lnr lnr-inbox"> <img class="img-i"
									src="<c:url value="/resources/images/user.png"/>" alt="User">
								</i>
								<h3>User</h3>
								<p>
								<h4>Create a new user.</h4>
								</p>
							</div>
						</div>
				
				</a>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<a href="<c:url value="/Cart/addView"/>">
						<div class="do-box text-center">
							<i class="lnr lnr-leaf"> <img class="img-i"
								src="<c:url value="/resources/images/cart.png"/>" alt="User">
							</i>
							<h3>Cart</h3>
							<p>
							<h4>Create a new cart.</h4>
							</p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>