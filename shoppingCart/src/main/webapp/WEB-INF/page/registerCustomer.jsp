<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<style>
body {
    
    background-image: url("resources/images/cakes/img/yellow.gif");
    background-size: cover;
}
div {
    border-radius: 15px;
   
    padding: 20px;
}
.container {
    
    color:#666;
    padding:5px;
    border-radius:10px;
    position: relative;
    border:1px solid #fff;
    margin:20;
    top: 10;
    bottom:10;
    right:50;
    left:20;
    width: 1000px;
    height: 1700px;
}
.form- {
    background-color:#eee;
    color:#666;
    padding:20px;
    border-radius:10px;
    position: relative;
    border:1px solid #fff;
    margin:80 auto;
    top: 30;
    right: 10;
    bottom: 10;
    left: 20;
    
    box-shadow: 6px 6px 5px darkgray, 0 0 8px red,0 0 5px lightgray;
}
h2.well{
color : black;
align-center;
box-shadow: 5px 5px 5px darkgray, 0 0 5px red,0 0 5px lightgray;
}
.align-center {
    
color: black;
font-weight: bold;
    text-align:center;
}
input[type=submit]:hover {
    background-color: #45a049;
}
</style>
</head>
<body>
<div class="container-wrapper">
<!-- <div class="container">
 -->
<div ><center><h2 class="well">Sign in</h2></center></div>
<table align="center" > 
<c:url var="url" value="/registerCustomer"></c:url>

<form:form action="${url }" commandName="customer" method="post" class="form-horizontal">

<div class="form-group">
<div class="row">
<div class="col-sm-6">
	<label  for="firstname">FIRST NAME:</label>
      <form:input class="form-control" path="firstname" placeholder="Enter the first name"/>
      </div>


<div class="col-sm-6">
<label for="lastname">LAST NAME:</label>
      
        <form:input class="form-control" path="lastname" placeholder="Enter the last name"/>
      </div>

</div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="email">EMAIL:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="email" placeholder="Enter email"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-2" for="phoneNumber">CONTACT NUMBER:</label>
      <div class="col-sm-10">
        <form:input class="form-control" path="phoneNumber" placeholder="Enter phoneNumber"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-2" for="users.username">USER NAME:</label>
      <div class="col-sm-10">
        <form:input class="form-control" path="users.username" placeholder="Enter username"/>
      </div>
</div>
 <div class="form-group">
<label class="control-label  col-sm-2" for="users.password">PASSWORD:</label>
      <div class="col-sm-10">
        <form:input class="form-control" type="password" path="users.password" placeholder="Enter password"/>
      </div>
</div>
<strong>Billing Address</strong>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.apartmentNumber">APARTMENT NUMBER:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.apartmentNumber" placeholder="Enter apartmentNumber"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.streetName">STREET NAME:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.streetName" placeholder="Enter StreetName"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.city">CITY:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.city" placeholder="Enter city"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.state">STATE:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.state" placeholder="Enter state"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.country">COUNTRY:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.country" placeholder="Enter country"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="billingAddress.zip">ZIP:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="billingAddress.zip" placeholder="Enter zip"/>
      </div>
</div>
<strong>Shipping Address</strong>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.apartmentNumber">APARTMENT NUMBER:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.apartmentNumber" placeholder="Enter apartmentNumber"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.streetName">STREET NAME:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.streetName" placeholder="Enter StreetName"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.city">CITY:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.city" placeholder="Enter city"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.state">STATE:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.state" placeholder="Enter state"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.country">COUNTRY:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.country" placeholder="Enter country"/>
      </div>
</div>
<div class="form-group">
<label class="control-label  col-sm-4" for="shippingAddress.zip">ZIP:</label>
      <div class="col-sm-8">
        <form:input class="form-control" path="shippingAddress.zip" placeholder="Enter zip"/>
      </div>
</div>
<div class="align-center">
<input type="submit" value="register">
</div>
</form:form>
</table>
</div>
</div>

</body>
</html>
