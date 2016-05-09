<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.5/angular.min.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
    rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
<div class="span9 margin-bottom center"> 
					<h3>Items in your cart</h3>
					</div>
<div class="span9 margin-left10" ng-app="addToCartApp">
	 
	 <div class="row margin-left25" ng-controller = "addToCartCtrl" ng-init="retrieveCart('${cartId}')">
        <table class="table table-bordered table-striped fs13" >
		  <thead>
			  <tr>
				
				<th>ID</th>
				<th>Name</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Price(in Rs.)</th>
				<th>Action</th>
			  </tr>
			</thead>
			<tbody>
				<tr ng-repeat = "items in cart.items">
					 	<td>{{items.product.id}}</td>
						<td>{{items.product.name}}</td>
						<td>{{items.product.price}}</td>
						<td>{{items.quantity}}</td>
						<td>{{items.totalPrice}}</td>
						<td><a href="#" class="btn btn-danger btnAction" ng-click="removeItemFromCart(items.id)">
							<span class="glyphicon glyphicon-remove"></span>remove</a></td>
					</tr>
			  <tr>
                    <td></td>
                    <td></td>
					<td></td>
                    <td>Grand Total(in Rs.)</td>
                    <td>{{GrandTotalOfItems()}}</td>
                    <td></th>
                </tr>	  
			</tbody>
		  </table>
		  
		  
​
          <div class="row">
		  <div class="span3">
             <a href="<spring:url value="/" />" class="btn btn-primary center">Continue Shopping</a>
			</div>	
			<div class="span3">
             <a href="<spring:url value="/order/${cartId}"/>"
                   class="btn btn-success center"><span class="glyphicon-shopping-cart glyphicon"></span> Check out
                </a>
			</div>	  
			<div class="span2">
           <a class="btn btn-danger center" ng-click="clearCartItems()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
			</div>		  
			
        </div>
		</div>
      </div>     
​
</div>

<script>
var cartApp = angular.module ("addToCartApp", []);
cartApp.controller("addToCartCtrl", function ($scope, $http){
	
	 /*
     * retrieveCart method is used to get all cart items at the starting of the application
     */
    $scope.retrieveCart = function (cartId) {
        $scope.cartId = cartId;
        //$scope.refreshCartItems(cartId);
        $scope.refreshCartItems();
    };
    
    
    /*
     * removeItemFromCart method is used to remove a item from the cart
     */
    $scope.removeItemFromCart = function (itemId) {
        $http.put('http://localhost:8080/wscrud2/cart/deleteitem/1').success(function (data) {
            $scope.refreshCartItems();
        });
    };
	 /*
     * addItemToCart method is used to add items into the cart
     */
    $scope.addItemToCart = function (itemId) {
        $http.put('http://localhost:8080/furniturestore/usercart/cart/addItem/'+itemId).success(function () {
            alert("Item added to the cart!")
        });
    };
   
   
    /*
     * GrandTotalOfItems method is called on cart page to calculate grand total for the added items
     */
    $scope.GrandTotalOfItems = function () {
        var grandTotal=0;
        for (var i=0; i<$scope.cart.items.length; i++) {
            grandTotal+=$scope.cart.items[i].totalPrice;
       }
        return grandTotal;
    };
    /*
	 * refreshCartItems method is called by others methods in same controller to refresh the cart
	 */
    $scope.refreshCartItems = function () {
        $http.get('http://localhost:8080/wscrud2/cart/1').success(function (data) {
           $scope.cart=data;
        });
    };
    
    /*
     * clearCartItems method is used to delete all items from the cart
     */
    $scope.clearCartItems = function () {
    	$http['delete']('http://localhost:8080/wscrud2/cart/'+$scope.cartId).success(function (data) {$scope.refreshCartItems()});
    };
});

</script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.5/angular.min.js"></script>

</body>
</html>