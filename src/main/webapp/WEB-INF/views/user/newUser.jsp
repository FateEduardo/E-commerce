
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
	<div data-ng-controller="adminController" data-ng-init="dataUser()" >
    <div class="panel panel-default">
      <div class="panel-heading">
			<ol class="breadcrumb">
			  <li><a href="<c:url value="/admin/home"/>">Home</a></li>
		
			  <li class="active"></li>
			</ol>
      </div>
      <div class="panel-body">
			<div class="container-center ">
				<form class="well"  name="myForm" data-ng-submit="newUser()">
					<div class="container">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg reg_name"
									data-ng-model="user.username" placeholder="username*"  name="username"  required>
							</div>
							<div class="col-sm-3">
								 <input type="text" class="form-control input-group-lg"
									 data-ng-model="user.name" name="name"  placeholder="name*" data-ng-required="true">
							</div>
						</div>
			
						<br/>
						<br/>
						<div class="form-group">
							<div class="col-sm-6">
							  <input type="password" class="form-control input-group-lg"
								 data-ng-model="user.password" name="password" placeholder="password*" data-ng-required="true">
							</div>
						</div>
						
						<br/>
						<br/>
						<div class="form-group">
								<div class="col-sm-6">
									<select name="status" data-ng-model="user.status"   class="form-control" required>
									<option value="true">Active</option>	
									<option value="false">Not Active</option>
									</select>
								</div>
							</div>
						<br/>
						<br/>
							<div class="form-group">
								<div class="col-sm-6">
										<select name="role" data-ng-model="user.role" data-ng-options="role as role.description for role in userRole" class="form-control" required>
									
									</select>
								</div>
							</div>
						<br /> 
						<br />	
						<div class="form-group">
							<div class="col-sm-6 container-button">
							 <button type="submit" class="btn btn-info" data-ng-click="submitted= true;" >Submit</button>
								
							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
    </div>
    {{user}}
  </div>
	