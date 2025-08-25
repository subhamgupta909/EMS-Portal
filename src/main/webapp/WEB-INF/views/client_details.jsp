<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Client Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #9face6);
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
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
        }
        .table td, .table th {
            padding: 15px;
            vertical-align: middle;
        }
    </style>
</head>
<body>

    <!-- 🔹 Top Bar -->
    <div class="top-bar">
        <h3 class="text-dark">Client Details</h3>
        <a href="${pageContext.request.contextPath}/client/logout">
            <button class="logout-btn">Logout</button>
        </a>
    </div>

    <!-- 🔹 Details Table -->
    <div class="container">
        <table class="table table-bordered text-center">
            <thead>
                <tr>
                    <th>Client ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Relationship Date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${clientDetails.userId}</td>
                    <td>${clientDetails.name}</td>
                    <td>${clientDetails.email}</td>
                    <td>
                        <fmt:formatDate value="${clientDetails.relationshipDate}" pattern="dd-MMM-yyyy"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>
