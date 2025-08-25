<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ems.entity.User" %>
<%@ page import="com.ems.entity.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>Client & Project Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            margin: 30px auto;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #ccc;
            position: relative;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background: #333;
            color: white;
            padding: 10px;
            text-align: left;
        }
        td {
            padding: 10px;
            background: #fafafa;
        }
        .error {
            color: red;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }

        /* 🔹 Back to Dashboard Button Style */
        .btn-dashboard {
            display: inline-block;
            padding: 8px 16px;
            margin-bottom: 15px;
            background: linear-gradient(135deg, #4CAF50, #2e7d32);
            color: white;
            font-weight: bold;
            text-decoration: none;
            border-radius: 25px;
            transition: 0.3s ease-in-out;
            box-shadow: 0 4px 6px rgba(0,0,0,0.2);
        }
        .btn-dashboard:hover {
            background: linear-gradient(135deg, #43a047, #1b5e20);
            transform: scale(1.05);
            box-shadow: 0 6px 10px rgba(0,0,0,0.25);
        }
    </style>
</head>
<body>
<div class="container">

    <!-- 🔙 Back Button -->
    <a href="${pageContext.request.contextPath}/admin/client_module" class="btn-dashboard">← Back to Dashboard</a>

    <h2>Client & Project Details</h2>

    <!-- Error Message -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <!-- Client Details -->
    <h3>Client Information</h3>
    <table>
        <tr>
            <th>Client ID</th>
            <td>${client.userId}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${client.name}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${client.email}</td>
        </tr>
    </table>

    <!-- Project Details -->
    <h3>Associated Projects</h3>
    <c:if test="${empty projectList}">
        <p style="color:red;">No projects found for this client.</p>
    </c:if>

    <c:if test="${not empty projectList}">
        <table>
            <thead>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
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
                    <td><fmt:formatDate value="${project.startDate}" pattern="dd-MM-yyyy"/></td>
                    <td><fmt:formatDate value="${project.endDate}" pattern="dd-MM-yyyy"/></td>
					<td>
							<c:if test="${not empty project.extendedEndDate}">
								<fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.extendedEndDate}">
								N/A
							</c:if>
						</td>                						<td>
							<a href="${pageContext.request.contextPath}/admin/project/edit?projectId=${project.projectId}" class="btn btn-edit">Edit</a>
							<a href="${pageContext.request.contextPath}/admin/project/delete?projectId=${project.projectId}" class="btn btn-delete"
								onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
						</td>
                
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
