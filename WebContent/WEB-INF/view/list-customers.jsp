<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css"
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id = "wrapper">
		<div id="header">
			<h2>Customer List</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			<input type="button" value="Add Customer"
			onclick="window.location.href='showAddForm'; return false"
			class="add-button"
			/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="customerObj" items="${customers}">
					<c:url var = "updateLink" value = "showFormToUpdate">
						<c:param name="customerId" value="${customerObj.id}"></c:param>
					</c:url>
					
					<c:url var = "deleteLink" value = "delete">
						<c:param name="customerId" value="${customerObj.id}"></c:param>
					</c:url>
					
					<tr>
						 <td>${customerObj.firstName}</td>
						 <td>${customerObj.lastName}</td>
						 <td>${customerObj.email}</td>
						 <td><a href = "${updateLink}">Update</a></td>
						 <td>|</td>
						 <td><a href="${deleteLink}"  onclick="if(!(confirm('Are You Sure With The Deletion Of Customer?'))) return false;">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>