
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
	<div data-ng-controller="adminController" data-ng-init="findUser()" >
    <div class="panel panel-default">
      <div class="panel-heading">
			<ol class="breadcrumb">
			  <li><a href="<c:url value="/admin/home"/>">Home</a></li>
			  <li><a href="<c:url value="/admin/listUserView"/>">List</a></li>
			  <li class="active"></li>
			</ol>
      </div>
      <div class="panel-body">
			<div class="container-center ">
				<form class="well"  name="myForm" data-ng-submit="editUser()">
					<div class="container">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg reg_name"
									data-ng-value="user.username"data-ng-model="user.username"  name="username" readonly="readonly" required>
							</div>
							<div class="col-sm-3">
								 <input type="text" class="form-control input-group-lg"
									data-ng-value="user.name" data-ng-model="user.name" name="name"  placeholder="name*" data-ng-required="true">
							</div>
						</div>
			
						<br/>
						<br/>
						<div class="form-group">
							<div class="col-sm-6">
							  <input type="password" class="form-control input-group-lg"
									data-ng-value="" data-ng-model="user.password" name="password" placeholder="Password*" data-ng-required="true">
							</div>
						</div>
						
						<br/>
						<br/>
						<div class="form-group">
								<div class="col-sm-6">
									<select name="status" data-ng-model="user.status" data-ng-options="status as status for status in listStatus "  class="form-control" required>
								
									</select>
								</div>
							</div>
						<br/>
						<br/>
							<div class="form-group">
								<div class="col-sm-6">
										<select name="role" data-ng-model="user.role.user_roleid" data-ng-options="role.user_roleid as role.description for role in userRole" class="form-control" required>
									
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
  </div>
	
	
