<br/>
<div class="container-center" data-ng-controller="loginController">
	<form class="well" name='f' action='/academy/j_spring_security_check'
		method='POST'>
		<div class="container">
			<div class="form-group">
				<div class="col-sm-6">
					<input type="text" class="form-control input-group-lg"
						name="j_username" placeholder="User Name" data-ng-required="true">



				</div>
			</div>

			<br /> <br />
			<div class="form-group">
				<div class="col-sm-6">
					<input type="password" class="form-control input-group-lg"
						name="j_password" placeholder="Password*" data-ng-required="true">

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
</div>
