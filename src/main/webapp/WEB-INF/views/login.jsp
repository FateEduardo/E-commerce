<br/>
<div class="container-center" >
				<form class="well" name='f' action='/academy/j_spring_security_check' method='POST'>
					<div class="container">
						<div class="form-group">
							<div class="col-sm-6">
								<input type="text" class="form-control input-group-lg" name="j_username"
									placeholder="User Name" required
									>
															


</div>
						</div>

						<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<input type="password" class="form-control input-group-lg"
									name="j_password"
									placeholder="Password*" required>
							</div>


						</div>
								<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<input name="submit" type="submit" value="Login"
									data-ng-disabled="myForm.$invalid">
							</div>


						</div>
					</div>
				</form>
</div>
