<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Release Employee from Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }
        .back-btn {
            display: inline-block;
            padding: 8px 16px;
            background: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            position: absolute;
            top: 20px;
            right: 20px;
            font-weight: bold;
            font-size: 14px;
        }
        .back-btn:hover {
            background: #217dbb;
        }
        h2 {
            text-align: center;
            margin-top: 60px;
            color: #2c3e50;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.2);
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #2c3e50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .btn-release {
            background-color: #e74c3c;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            cursor: pointer;
        }
        .btn-release:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<!-- Back to Dashboard -->
<a href="${pageContext.request.contextPath}/admin/employee_module" class="back-btn">← Back to Dashboard</a>

<h2>Employee Assigned Projects</h2>

<table>
    <thead>
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Project ID</th>
            <th>Project Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${empProjectList}">
            <tr>
                <td>${emp.userId}</td>
                <td>${emp.name}</td>
                <td>${emp.email}</td>
                <td>${emp.dept}</td>
                <td>${emp.project.projectId}</td>
                <td>${emp.project.projectName}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/employee/release-project" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="${emp.userId}" />
                        <input type="hidden" name="projectId" value="${emp.project.projectId}" />
                        <button type="submit" class="btn-release">Release</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
