
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section id="what-we-do" class="what-we-do">
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<a href="<c:url value="/user/sweaterView"/>">
					
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="do-box text-center">
								<i class="lnr lnr-inbox"> <img class="img-i"
									src="<c:url value="/resources/images/sweater.jpg"/>" alt="User">
								</i>
								<h3>Sweater</h3>
								<p>
								<h4>The best</h4>
								</p>
							</div>
						</div>
				
				</a>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<a href="<c:url value="/user/shoesView"/>">
						<div class="do-box text-center">
							<i class="lnr lnr-leaf"> <img class="img-i"
								src="<c:url value="/resources/images/shoes.png"/>" alt="User">
							</i>
							<h3>Shoes</h3>
							<p>
							<h4>The Best Price</h4>
							</p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>