
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div data-ng-controller="userController" data-ng-init="shoesFilter()">

	<div class="panel panel-default">

		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/"/>">Home</a></li>
				<li class="active">Item List</li>
			</ol>
			<div class="form-group">
				<div class="col-sm-3">
					<select   data-ng-model="cost"class="form-control">
				    <option value="0"> >0</option>
				    <option value="50"> >50</option>
					<option value="100"> >100</option>
					<option value="200"> >200</option>
					</select>
				</div>

				<div class="col-sm-6 container-button">
					<button type="submit" class="btn btn-info"
						data-ng-click="filterCategory(categoryItem.description)">SEARCH</button>

				</div>


			</div>
		</div>

		<br/>
<br/>
<br/>
<br/>
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
				<tr data-ng-repeat="item in itemList |price:cost ">
					<td ><a data-ng-bind="item.id" data-ng-click="saveItem(item.id)" data-ng-href="<c:url value="/admin/editItemView"/>"></a></td>
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

