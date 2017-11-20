<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Billing Address</th>
					<th>Shipping Address</th>
                   <th>Action</th>    <!-- Action = view/edit/delete -->
				</tr>
			</thead>
			<c:forEach var="c" items="${viewCustomer}">
				<tr>
					
					 <td>${c.users.username }</td>
					<td>${c.email }</td>
					<td>${c.phoneNumber }</td>
					<td>${c.billingAddress}</td>
					<td>${c.shippingAddress }</td>
										
					<td>
					
					 <security:authorize access="hasRole('ROLE_ADMIN')">
					<c:url var="delete" value="/deletecustomer/${c.id }"></c:url>
					<a href="${delete }"><span class="glyphicon glyphicon-remove"></span></a>
					</security:authorize>
					 <security:authorize access="hasRole('ROLE_USER'),('ROLE_ADMIN')">
					 <c:url var="viewCustomer" value="/viewcustomer?id=${c.id }"></c:url>
				
					<a href="${viewCustomer }"><span class="glyphicon glyphicon-info-sign"></span></a>
					
				    </security:authorize></td>
				</tr>
			</c:forEach>
		</table>

			
	</div>
</body>
</html>