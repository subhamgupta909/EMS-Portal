<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contact Person List</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        th, td {
            padding: 12px 15px;
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
        .btn {
            padding: 6px 12px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
        }
        .btn-edit {
            background-color: #27ae60;
            color: white;
        }
        .btn-edit:hover {
            background-color: #1e8449;
        }
        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }
        .btn-delete:hover {
            background-color: #c0392b;
        }
        .actions {
            display: flex;
            gap: 10px;
            justify-content: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>📋 Contact Person List</h2>
    
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Designation</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cp" items="${contactPersonList}">
                <tr>
                    <td>${cp.name}</td>
                    <td>${cp.email}</td>
                    <td>${cp.phone}</td>
                    <td>${cp.designation}</td>
                    <td class="actions">
                        <a href="${pageContext.request.contextPath}/admin/contact/edit?id=${cp.id}" 
                           class="btn btn-edit">✏ Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/contact/delete?id=${cp.id}" 
                           class="btn btn-delete"
                           onclick="return confirm('Are you sure you want to delete this contact?');">
                           🗑 Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
