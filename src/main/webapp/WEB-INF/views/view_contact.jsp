<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Assigned Contacts</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #2c3e50;
        }
        .form-box {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="number"] {
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
            width: 200px;
            margin-right: 10px;
        }
        .btn-submit {
            padding: 8px 15px;
            border: none;
            border-radius: 6px;
            background-color: #3498db;
            color: white;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #2980b9;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #2c3e50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-data {
            text-align: center;
            font-style: italic;
            color: #888;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>👤 View Assigned Contact Persons</h2>

    <!-- Form to input client ID -->
    <div class="form-box">
        <form action="${pageContext.request.contextPath}/admin/view/contact" method="get">
            <input type="text" name="userId" placeholder="Enter Client ID" required>
            <button type="submit" class="btn-submit">🔍 View</button>
        </form>
    </div>

    <!-- Show table if data available -->
    <c:if test="${not empty contactPersons}">
        <table>
            <thead>
                <tr>
                    <th>Contact Person Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Designation</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cp" items="${contactPersons}">
                    <tr>
                        <td>${cp.name}</td>
                        <td>${cp.email}</td>
                        <td>${cp.phone}</td>
                        <td>${cp.designation}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- If no data found -->
    <c:if test="${empty contactPersons and param.clientId ne null}">
        <p class="no-data">❌ No contact persons assigned for this client.</p>
    </c:if>
</div>
</body>
</html>
