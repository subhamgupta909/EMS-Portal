<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Assign Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        select, button {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }
        button {
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Assign Project to Employee</h2>
    
    <form action="${pageContext.request.contextPath}/admin/employee/assignproject" method="post">
        		<!-- Success/Error Messages -->
		<c:if test="${not empty successMessage}">
			<div class="message success">${successMessage}</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<div class="message error">${errorMessage}</div>
		</c:if>
        
        <!-- Bench Employee Dropdown -->
        <label for="userId">Select Employee:</label>
        <select name="userId" id="userId" required>
            <option value="">-- Select Employee --</option>
            <c:forEach var="emp" items="${empBenchList}">
                <option value="${emp.userId}">${emp.name} (${emp.email})</option>
            </c:forEach>
        </select>
        
        <!-- Project Dropdown -->
        <label for="projectId">Select Project:</label>
        <select name="projectId" id="projectId" required>
            <option value="">-- Select Project --</option>
            <c:forEach var="proj" items="${projectList}">
                <option value="${proj.projectId}">
                    ${proj.projectName} (Client: ${proj.client.name})
                </option>
            </c:forEach>
        </select>
        
        <button type="submit">Assign Project</button>
    </form>
</div>

</body>
</html>
