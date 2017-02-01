
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div data-ng-controller="adminController" data-ng-init="lisItem()">
	<div class="panel panel-default">
		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/admin/home"/>">Home</a></li>
				<li class="active">Item List</li>
			</ol>
		</div>
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
						<th>Delete</th>
					</tr>
				</thead>
				<tr data-ng-repeat="item in itemList">
					<td ><a data-ng-bind="item.id" data-ng-click="save(item.id)" data-ng-href="<c:url value="/admin/editItemView"/>"></a></td>
					<td data-ng-bind="item.features"></td>
					<td data-ng-bind="item.description"></td>
					<td data-ng-bind="item.price | number:2"></td>
					<td data-ng-bind="item.stock"></td>
					<td data-ng-show="item.actice">Active</td>
					<td data-ng-show="!item.actice">Disable</td>
					<td ><button  class="btn btn-info" data-ng-click="deleteItem(item.id)" data-ng-disabled="myForm.$invalid">Delete</button></td>
				</tr>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

