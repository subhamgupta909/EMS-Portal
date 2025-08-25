<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Assign Contact Person to Client</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
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
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #2c3e50;
        }
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 15px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            background-color: #3498db;
            color: white;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>🔗 Assign Contact Person to Client</h2>
        <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-error">${error}</div>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/admin/assign/save" method="post">
        
        <!-- Client Dropdown -->
        <label for="user">Select Client</label>
        <select name="userId" id="user" required>
            <option value="">-- Select Client --</option>
            <c:forEach var="client" items="${clientList}">
                <option value="${client.userId}">${client.name}</option>
            </c:forEach>
        </select>
        
        <!-- Contact Person Dropdown -->
        <label for="contactPerson">Select Contact Person</label>
        <select name="id" id="contactPerson" required>
            <option value="">-- Select Contact Person --</option>
            <c:forEach var="cp" items="${contactPersonsList}">
                <option value="${cp.id}">${cp.name} (${cp.email})</option>
            </c:forEach>
        </select>
        
        <button type="submit" class="btn">✅ Assign</button>
    </form>
</div>

</body>
</html>
