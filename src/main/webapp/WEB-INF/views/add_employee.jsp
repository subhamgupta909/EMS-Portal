<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Registration</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%);
            margin: 0;
            padding: 0;
        }
        .container {
            width: 450px;
            margin: 50px auto;
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.15);
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            font-weight: 600;
            margin-top: 12px;
            display: block;
            color: #444;
        }
        input[type=text],
        input[type=email],
        input[type=date],
        input[type=number],
        select {
            width: 100%;
            padding: 10px 12px;
            margin-top: 6px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 14px;
            box-sizing: border-box;
        }
        input:focus, select:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 4px rgba(0,123,255,0.4);
        }
        button {
            width: 100%;
            margin-top: 22px;
            padding: 12px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Employee Registration</h2>

    <form:form method="post" action="${pageContext.request.contextPath}/admin/employee/save" modelAttribute="employee">

        <label>Employee Name:</label>
        <form:input path="name" placeholder="Enter full name"/>

        <label>Email:</label>
        <form:input path="email" type="email" placeholder="Enter email"/>
        <label>Password:</label>
        <form:input path="password"  type="password" placeholder="Enter Password"/>

        <label>Department:</label>
        <form:input path="dept" placeholder="Enter department"/>

        <label>Phone:</label>
        <form:input path="phone" type="number" placeholder="Enter phone number"/>

        <label>Date of Joining:</label>
        <form:input path="dateOfJoining" type="date" />

        <label>Role:</label>
        <form:select path="role">
            <form:option value="" label="-- Select Role --"/>
            <form:option value="ROLE_EMPLOYEE" label="Employee"/>
            <form:option value="ROLE_CLIENT" label="Client"/>
            <form:option value="ROLE_ADMIN" label="Admin"/>
        </form:select>

        <button type="submit">Save Employee</button>
    </form:form>
</div>
</body>
</html>
