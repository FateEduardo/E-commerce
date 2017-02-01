
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
	<div data-ng-controller="adminController" data-ng-init="findItem()" >
    <div class="panel panel-default">
      <div class="panel-heading">
			<ol class="breadcrumb">
			  <li><a href="<c:url value="/admin/home"/>">Home</a></li>
			  <li><a href="<c:url value="/admin/listItemView"/>">List</a></li>
			  <li class="active"></li>
			</ol>
      </div>
      <div class="panel-body">
			<div class="container-center ">
				<form class="well"  name="myForm" data-ng-submit="editItem()">
					<div class="container">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="number" class="form-control input-group-lg reg_name"
									data-ng-value="item.id"data-ng-model="item.id"  name="id" readonly="readonly" required>
							</div>
							<div class="col-sm-3">
								 <input type="text" class="form-control input-group-lg"
									data-ng-value="item.features" data-ng-model="item.features" name="features"  placeholder="Features*" data-ng-required="true">
							</div>
						</div>
			
						<br/> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<input type="text" class="form-control input-group-lg"
									data-ng-value="item.description"
									data-ng-model="item.description" name="description"
									placeholder="Description*" data-ng-required="true">
							</div>
						</div>

						<br /> <br />
						<div class="form-group">
						<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg"
									data-ng-value="item.price | currency"
									data-ng-model="item.price | currency" name="description"
									placeholder="Price*" data-ng-required="true">
							</div>
							<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg"
									data-ng-value="item.stock"
									data-ng-model="item.stock" name="stock"
									placeholder="Stock*" data-ng-required="true">
							</div>
							
						</div>
						<br /> <br />
						<div class="form-group">
														<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg"
									data-ng-value="item.active"
									data-ng-model="item.active" name="active"
									placeholder="Stock*" data-ng-required="true" readonly="readonly">
							</div>					
							</div>
						<br /> 
						<br />	

					</div>
				</form>
			</div>
		</div>
    </div>
  </div>
	
	
