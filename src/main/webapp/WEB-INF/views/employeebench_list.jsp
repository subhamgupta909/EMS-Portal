<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee List - EMS</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f9;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	margin: 20px 0;
	color: #2c3e50;
}

.container {
	width: 90%;
	margin: auto;
	background: white;
	padding: 20px;
	box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

.header-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 15px;
}

.btn-dashboard {
	background-color: #6c757d;
	color: white;
	padding: 8px 14px;
	border-radius: 5px;
	text-decoration: none;
	font-size: 14px;
}
.btn-dashboard:hover {
	background-color: #5a6268;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 15px;
	font-size: 14px;
}

table th, table td {
	border: 1px solid #ddd;
	padding: 10px 12px;
	text-align: center;
}

table th {
	background-color: #007BFF;
	color: white;
	font-weight: bold;
}

table tr:nth-child(even) {
	background-color: #f9f9f9;
}

table tr:hover {
	background-color: #e6f2ff;
}

.btn {
	padding: 6px 12px;
	font-size: 13px;
	border-radius: 5px;
	border: none;
	cursor: pointer;
	text-decoration: none;
	color: white;
}

.btn-edit {
	background-color: #28a745;
}

.btn-delete {
	background-color: #dc3545;
}

.btn-edit:hover {
	background-color: #218838;
}

.btn-delete:hover {
	background-color: #c82333;
}

.message {
	padding: 10px;
	text-align: center;
	border-radius: 5px;
	margin-bottom: 10px;
}

.success {
	background-color: #d4edda;
	color: #155724;
}

.error {
	background-color: #f8d7da;
	color: #721c24;
}
</style>
</head>
<body>

	<div class="container">
		<div class="header-bar">
			<h2>Employee Bench List</h2>
<a href="${pageContext.request.contextPath}/admin/employee_module" class="btn-dashboard">← Back to Dashboard</a>
		</div>

		<!-- Success/Error Messages -->
		<c:if test="${not empty successMessage}">
			<div class="message success">${successMessage}</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<div class="message error">${errorMessage}</div>
		</c:if>

		<table>
			<thead>
				<tr>
					<th>Emp ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Dept</th>
					<th>Phone</th>
					<th>Date of Joining</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empBenchList}">
					<tr>
						<td>${emp.userId}</td>
						<td>${emp.name}</td>
						<td>${emp.email}</td>
						<td>${emp.dept}</td>
						<td>${emp.phone}</td>
						<td>
							<c:if test="${not empty emp.dateOfJoining}">
								<fmt:formatDate value="${emp.dateOfJoining}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty emp.dateOfJoining}">
								N/A
							</c:if>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/admin/employee/edit?userId=${emp.userId}" class="btn btn-edit">Edit</a>
							<a href="${pageContext.request.contextPath}/admin/employee/delete?userId=${emp.userId}" class="btn btn-delete"
								onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
