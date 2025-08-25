<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>Search Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }
        .container {
            width: 80%;
            margin: 40px auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0,0,0,0.15);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #2c3e50;
        }
        form {
            text-align: center;
            margin-bottom: 30px;
        }
        input[type="text"] {
            padding: 10px;
            width: 280px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        button {
            padding: 10px 18px;
            margin: 8px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            color: white;
        }
        .btn-project { background: #3498db; }
        .btn-client { background: #27ae60; }
        .btn-employee { background: #e67e22; }
        .btn-project:hover { background: #217dbb; }
        .btn-client:hover { background: #1e8449; }
        .btn-employee:hover { background: #ca6f1e; }

        /* New styles for Edit/Delete buttons */
        .btn-edit {
            background: #28a745;
            padding: 6px 12px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
        }
        .btn-edit:hover {
            background: #218838;
        }
        .btn-delete {
            background: #dc3545;
            padding: 6px 12px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
        }
        .btn-delete:hover {
            background: #c82333;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            text-align: center;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        th {
            background: #2c3e50;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        .back-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 8px 16px;
            background: #e74c3c;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }
        .back-btn:hover {
            background: #c0392b;
        }
        .section-title {
            margin-top: 25px;
            margin-bottom: 10px;
            font-weight: bold;
            font-size: 18px;
            color: #34495e;
        }
    </style>
</head>
<body>
<div class="container">

    <a href="${pageContext.request.contextPath}/admin/project_module" class="back-btn">← Back to Dashboard</a>

    <h2>Search Project by ID</h2>

    <!-- Search Form -->
    <form action="${pageContext.request.contextPath}/admin/project/search-id" method="get">
        <input type="text" name="projectId" placeholder="Enter Project ID" required />

        <!-- 3 Buttons -->
        <button type="submit" name="action" value="viewProject" class="btn-project">View Project</button>
        <button type="submit" name="action" value="viewClient" class="btn-client">View Client</button>
        <button type="submit" name="action" value="viewEmployees" class="btn-employee">View Employees</button>
    </form>


    <!-- Project Details -->
    <c:if test="${not empty project}">
        <div class="section-title">Project Details</div>
        <table>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Extended End Date</th>
          
                <th>Actions</th>
            </tr>
            <tr>
                <td>${project.projectId}</td>
                <td>${project.projectName}</td>
                <td>
                    <c:if test="${not empty project.startDate}">
                        <fmt:formatDate value="${project.startDate}" pattern="dd-MM-yyyy" />
                    </c:if>
                    <c:if test="${empty project.startDate}">N/A</c:if>
                </td>
                <td>
                    <c:if test="${not empty project.endDate}">
                        <fmt:formatDate value="${project.endDate}" pattern="dd-MM-yyyy" />
                    </c:if>
                    <c:if test="${empty project.endDate}">N/A</c:if>
                </td>
                                <td>
                    <c:if test="${not empty project.extendedEndDate}">
                        <fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MM-yyyy" />
                    </c:if>
                    <c:if test="${empty project.extendedEndDate}">N/A</c:if>
                </td>
                
                <td>
                    <a href="${pageContext.request.contextPath}/project/edit?projectId=${project.projectId}" class="btn-edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/project/delete?projectId=${project.projectId}" class="btn-delete"
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                </td>
            </tr>
        </table>
    </c:if>

    <!-- Client Details -->
    <c:if test="${not empty client}">
        <div class="section-title">Client Details</div>
        <table>
            <tr>
                <th>Client ID</th>
                <th>Client Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${client.userId}</td>
                <td>${client.name}</td>
                <td>${client.email}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/client/edit?userId=${client.userId}" class="btn-edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/client/delete?userId=${client.userId}" class="btn-delete"
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                </td>
            </tr>
        </table>
    </c:if>

    <!-- Employees List -->
    <c:if test="${not empty employeeList}">
        <div class="section-title">Employees Working on this Project</div>
        <table>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Phone</th>
                <th>Date of Joining</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="emp" items="${employeeList}">
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
                        <c:if test="${empty emp.dateOfJoining}">N/A</c:if>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employee/edit?userId=${emp.userId}" class="btn-edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/employee/delete?userId=${emp.userId}" class="btn-delete"
                           onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
</body>
</html>
