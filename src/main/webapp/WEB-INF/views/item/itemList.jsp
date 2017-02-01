
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div data-ng-controller="adminController" data-ng-init="lisItem()">
	<div class="panel panel-default">
	
		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/admin/home"/>">Home</a></li>
				<li class="active">Item List</li>
			</ol>
			<div class="form-group">
				<div class="col-sm-3">
					<select name="category" data-ng-model="categoryItem"
						data-ng-options="category as category.description for category in categories "
						class="form-control" required="required">

					</select>
				</div>
				<div class="col-sm-6 container-button">
					<button type="submit" class="btn btn-info"
						data-ng-click="filterCategory(categoryItem.description)">SEARCH</button>

				</div>
				<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg reg_name"
									data-ng-model="find"  name="id" >
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
				<tr data-ng-repeat="item in itemList | filter:test">
					<td ><a data-ng-bind="item.id" data-ng-click="saveItem(item.id)" data-ng-href="<c:url value="/admin/editItemView"/>"></a></td>
					<td data-ng-bind="item.features"></td>
					<td data-ng-bind="item.description"></td>
					<td data-ng-bind="item.price | currency"></td>
					<td data-ng-bind="item.stock"></td>
					<td data-ng-show="item.actice">Active</td>
					<td data-ng-show="!item.actice">Disable</td>
					<td ><button  class="btn btn-info" data-ng-click="deleteItem(item.id)" >Delete</button></td>
				</tr>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

