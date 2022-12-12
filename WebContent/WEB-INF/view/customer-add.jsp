<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link style="text/css"
	      rel = "stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" 
    />
	<title>Add Customer</title>
</head>
<body>
	<div id="wrapper">
		<div id = "header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>
	
	<div id = "container">
		<h3>Save Customer</h3>
		<div id = "content">
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			    <form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>First Name : </label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						
						<tr>
							<td><label>Last Name : </label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						
						<tr>
							<td><label>Email Name : </label></td>
							<td><form:input path="email"/></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			<p>
			  <a href = "${pageContext.request.contextPath}/customers/list">Back To Customers List</a>
			</p>
		</div>
	</div>
</body>
</html>