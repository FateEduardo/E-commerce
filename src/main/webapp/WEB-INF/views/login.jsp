<br/>
<div class="container-center" data-ng-controller="loginController" >
				<form class="well" name="myForm" data-ng-submit="login()">
					<div class="container">
						<div class="form-group">
							<div class="col-sm-6">
								<input type="text" class="form-control input-group-lg"
									placeholder="User Name" data-ng-required="true"
									data-ng-model="username">
<!-- 																	data-ng-value="" data-ng-model="user.password" name="password" -->


</div>
						</div>

						<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<input type="password" class="form-control input-group-lg"
									data-ng-value="" data-ng-model="password" name="password"
									placeholder="Password*" data-ng-required="true">
							</div>


						</div>
								<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<button type="submit" class="btn btn-info"
									data-ng-click="submitted= true;"
									data-ng-disabled="myForm.$invalid">Submit</button>
							</div>


						</div>
					</div>
				</form>
</div>
