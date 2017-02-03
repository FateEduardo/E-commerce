
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div data-ng-controller="userController" data-ng-init="sweaterFilter()">

	<div class="panel panel-default">

		<div class="panel-heading">
			<div>{{items}}</div>
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
						<th>Item Id</th>
						<th>Features</th>
						<th>Description</th>
						<th>Unit price</th>
						<th>Stock</th>
						<th>Status</th>
						<th>Quantity</th>
						<th>Add</th>

					</tr>
				</thead>
				<tr data-ng-repeat="item in itemList |price:cost ">
					<td><a data-ng-bind="item.id"
						data-ng-click="saveItem(item.id)"
						data-ng-href="<c:url value="/admin/editItemView"/>"></a></td>
					<td data-ng-bind="item.features"></td>
					<td data-ng-bind="item.description"></td>
					<td data-ng-bind="item.price | currency"></td>
					<td data-ng-bind="item.stock"></td>
					<td data-ng-show="item.active">Active</td>
					<td data-ng-show="!item.active">Disable</td>
					<td><input type="range" name="range" data-ng-model="quantity"
						min="0" max="{{item.stock}}"> </br><input type="number"
						data-ng-model="quantity"></td>
					<td><button class="btn btn-info"
							data-ng-click="addItemOrder(item)">Cart</button></td>
					<td></td>
				</tr>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

