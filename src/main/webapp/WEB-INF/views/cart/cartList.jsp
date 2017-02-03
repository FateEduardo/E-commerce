
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div data-ng-controller="userController" data-ng-init="listOrder()">
	<div class="panel panel-default">
	<div >{{items}}</div>
		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/"/>">Home</a></li>
				<li class="active">Item List</li>
			</ol>
			<div class="form-group">
				<div class="col-sm-3">
					<select data-ng-model="cost" class="form-control">
						<option value="0">>0</option>
						<option value="50">>50</option>
						<option value="100">>100</option>
						<option value="200">>200</option>
					</select>
				</div>
			</div>
		</div>

		<br /> <br /> <br /> <br />
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>Cart Id</th>
						<th>Shipping Amount</th>
						<th>Cart Amount</th>
						<th>Status</th>
					</tr>
				</thead>
				<tr data-ng-repeat="cart in cartList  ">
					<td><a data-ng-bind="cart.id"></a></td>
					<td data-ng-bind="cart.shippingAmount | currency"></td>
					<td data-ng-bind="cart.cartAmount | currency"></td>
					<td data-ng-show="icart.status">Active</td>
					<td data-ng-show="!cart.status">Disable</td>
					<td><button class="btn btn-info"
							data-ng-click="addItemOrder()">Cart</button></td>
				</tr>
				<tbody>
				</tbody>
			</table>
			<br/><br/>
			<table class="table">
				<thead>
					<tr>
						<th>Item Id</th>
						<th>Features</th>
						<th>Description</th>
						<th>Price</th>
						<th>Stock</th>
						<th>Active</th>
					</tr>
				</thead>
					<tr data-ng-repeat="item in itemList |price:cost ">
					<td ><a data-ng-bind="item.id" ></a></td>
					<td data-ng-bind="item.features"></td>
					<td data-ng-bind="item.description"></td>
					<td data-ng-bind="item.price | currency"></td>
					<td data-ng-bind="item.stock"></td>
					<td data-ng-show="item.actice">Active</td>
					<td data-ng-show="!item.actice">Disable</td>
					<td ><button  class="btn btn-info" data-ng-click="deleteItem(item.id)" >Cart</button></td>
				</tr>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

