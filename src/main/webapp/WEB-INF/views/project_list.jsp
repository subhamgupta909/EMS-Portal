<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Client List - EMS</title>
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
			<h2>Project List</h2>
<a href="${pageContext.request.contextPath}/admin/project_module" class="btn-dashboard">← Back to Dashboard</a>
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
					<th>Project ID</th>
					<th>Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Extended End Date</th>
					
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projectList}">
					<tr>
						<td>${project.projectId}</td>
						<td>${project.projectName}</td>
						<td>
							<c:if test="${not empty project.startDate}">
								<fmt:formatDate value="${project.startDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.startDate}">
								N/A
							</c:if>
						</td>
												<td>
							<c:if test="${not empty project.endDate}">
								<fmt:formatDate value="${project.endDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.endDate}">
								N/A
							</c:if>
						</td>
																		<td>
							<c:if test="${not empty project.extendedEndDate}">
								<fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.extendedEndDate}">
								N/A
							</c:if>
						</td>
						
						<td>
							<a href="${pageContext.request.contextPath}/admin/project/edit?projectId=${project.projectId}" class="btn btn-edit">Edit</a>
							<a href="${pageContext.request.contextPath}/admin/project/delete?projectId=${project.projectId}" class="btn btn-delete"
								onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
