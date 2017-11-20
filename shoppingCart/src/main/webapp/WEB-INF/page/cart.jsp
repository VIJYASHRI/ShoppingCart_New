<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>


<script src="<c:url value="/resources/js/controller.js"></c:url>">
</script>

<style>
body{
background-image: url("resources/images/15377511-shopping-cart-in-the-parking-lot-of-a-supermarket-Stock-Photo.jpg");
   background-repeat: no-repeat;

  background-size:cover;
}
   div.panel{
 
      background: rgba(130,130,130,.9);
}
#myInput {
 
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
div.panel{
 
      background: rgba(130,130,130,.9);
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 5px;
 
}
img{
  border-radius: 50%;
  
}
#myTable tr {
  border-bottom: 1px solid #ddd;
  
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>
</head>
<body>
<div ng-app="app" ng-controller="ProductController">
<div ng-init="getCart(${cartId})">

<div class="container">
<div class="panel panel-default" class="sansserif">
<div class="panel-heading">
<center><b>YOUR CART</b></center></div>
   <div class="panel-body">

<a href="<c:url value='/clearCart'/>" class="pull-left">
<span class="btn btn-danger" onclick="alert('your cart is empty now \n you can add products to your cart\n thank you')">Clear Cart</span></a>
<a href="<c:url value="/order/${cartId}"></c:url>" class="pull-right" >
<span class="btn btn-success" >Checkout</span></a>
<table id="myTable">
<tr>
<th>Name</th>
<th>Quantity</th>
<th>Total Price</th>
<th>Remove Product</th>
</tr>

<c:forEach var="cartItem" items="${cartList}">
<tr>
<td>${cartItem.product.productname}</td>
<td><a href="<c:url value='/decreaseQuantity/${cartItem.id}'/>">
<span class="label label-warning" class="bt-xs">-</span>
</a>
&nbsp; &nbsp;${cartItem.quantity}&nbsp;&nbsp;<a href="<c:url value='/increaseQuantity/${cartItem.id}'/>">
<span class="label label-success" class="btn-xs">+</span></a></td>
<td>${cartItem.totalPrice}</td>
<td><a href="<c:url value='/removeFromCart/${cartItem.id}'/>" class="pull-left">
<span class="label label-danger" class="glyphicon glyphicon-remove" onclick="alert('your product is successfully deleted from the cart \n you can add products to your cart\ngo to product list and choose your product\n thank you')">Remove</span>
</a></td>
</tr>
</c:forEach>

<!-- <tr ng-repeat="cartItem in cart.cartItems">
<td>{{cartItem.product.name}}</td>
<td>{{cartItem.quantity}}</td>
<td>{{cartItem.totalPrice}}</td>
</tr>

<tr>
<td>Remove</td>
</tr> 
Total Price : {{calculateGrandTotal()}} -->

</table>
<tr><td>
<h2 style="padding-left: 550px;">Total price: ${grandTotal}</h2>
</td></tr>
</div></div>
</div>
<%-- <script src="<c:url value="/resources/js/controller.js"></c:url>"></script> --%>
</div>
</div>
</body>
</html>