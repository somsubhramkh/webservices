<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular.min.js"></script>

</head>

<body ng-app="myCartApp">
<h2>Hello World!</h2>

<script>

var myevents = angular.module('myCartApp', []);

myevents.controller("CartController", function ($scope, $http) {
    $http.get('http://localhost:8080/wscrud2/products').
    success(function (data) {
        $scope.products = data;
    });
});

</script>


 <div ng-controller="CartController" class="container">
    <h1>Events</h1>
    <hr/>
    <div ng-repeat="product in products" class="col-md-6">
      <ul>
      
      <li>{{product.id}}</li>
      <li>{{product.name}}</li>
      <li>{{product.desc}}</li>
      <li>{{product.brand}}</li>
      <li>{{product.price}}</li>
      <li>{{product.category}}</li>
      
     
      </ul>
    </div>
  </div>

</body>
</html>
