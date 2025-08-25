<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>My Projects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background: linear-gradient(135deg, #ffecd2, #fcb69f);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }
        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 40px;
        }
        .logout-btn {
            background: #ff4b5c;
            border: none;
            color: white;
            font-weight: bold;
            padding: 8px 18px;
            border-radius: 25px;
            transition: 0.3s;
        }
        .logout-btn:hover {
            background: #e60023;
        }
        .container {
            margin-top: 40px;
        }
        .table {
            background: #fff;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }
        .table thead {
            background: linear-gradient(135deg, #ff9966, #ff5e62);
            color: white;
        }
        .table td, .table th {
            padding: 15px;
            vertical-align: middle;
        }
        .project-name {
            font-weight: 600;
            color: #ff5e62;
        }
    </style>
</head>
<body>

    <!-- 🔹 Top Bar -->
    <div class="top-bar">
        <h3 class="text-dark">My Projects</h3>
        <a href="${pageContext.request.contextPath}/logout">
            <button class="logout-btn">Logout</button>
        </a>
    </div>

    <!-- 🔹 Projects Table -->
    <div class="container">
        <table class="table table-bordered text-center">
            <thead>
                <tr>
                    <th>Project ID</th>
                    <th>Project Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Extended End Date</th>
                    <th>Employees Assigned</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${projects}">
                    <tr>
                        <td>${project.projectId}</td>
                        <td class="project-name">${project.projectName}</td>
                        <td><fmt:formatDate value="${project.startDate}" pattern="dd-MMM-yyyy"/></td>
                        <td><fmt:formatDate value="${project.endDate}" pattern="dd-MMM-yyyy"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${project.extendedEndDate != null}">
                                    <fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MMM-yyyy"/>
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:forEach var="emp" items="${project.employees}">
                                <span class="badge text-bg-primary">${emp.name}</span>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
