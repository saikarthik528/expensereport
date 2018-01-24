<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Users Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
	cellpadding: 10;
	cellspacing: 10;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	cellpadding: 10;
	cellspacing: 10;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
	cellpadding: 10;
	cellspacing: 10;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

a.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 10px 15px 10px 8px;
}

a.btn {
	background-color: #f44336;
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 10px 15px 10px 8px;
}

.table {
	border: 1px;
}

.th {
	width: 10%;
}

.value {
	margin: 10px 15px 10px 8px;
}
</style>
</head>
<body>
	<h1>Add a User</h1>

	<c:url var="addAction" value="/userDetails/add"></c:url>

	<form:form action="${addAction}" commandName="userDetails">
		<table>
			<c:if test="${!empty userDetails.userName}">
				<tr>
					<td><form:label path="userId">
							<spring:message text="USERID" />
						</form:label></td>
					<td><form:input path="userId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userId" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="FirstName" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="LastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="userName">
						<spring:message text="UserName" />
					</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="passwprd">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephoneNum">
						<spring:message text="TelephoneNum" />
					</form:label></td>
				<td><form:input path="telephoneNum" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty userDetails.name}">
						<input type="submit" value="<spring:message text="Edit User"/>" />
					</c:if> <c:if test="${empty userDetails.name}">
						<input type="submit" value="<spring:message text="Add User"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Users List</h3>

	<c:if test="${!empty listUserDetails}">
		<table class="tg">
			<tr>
				<th width="80">User Id</th>
				<th width="120">User Name</th>
				<th width="120">First Name</th>
				<th width="60">Action</th>

			</tr>
			<c:forEach items="${listUserDetails}" var="phone">
				<tr>
					<td>${userDetails.userId}</td>
					<td>${userDetails.userName}</td>
					<td>${userDetails.firstName}</td>
					<td><a href="<c:url value='/edit/${userDetails.userId}' />"
						class="button">Edit</a> <a
						href="<c:url value='/remove/${userDetails.userId}' />" class="btn">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>