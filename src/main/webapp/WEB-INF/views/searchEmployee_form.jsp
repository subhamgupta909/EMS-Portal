<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Search</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(120deg, #e0f7fa, #ffffff);
            margin: 0;
            padding: 0;
        }
        .container {
            width: 40%;
            margin: 60px auto;
            padding: 30px;
            background: #fff;
            border-radius: 15px;
            box-shadow: 0px 6px 15px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 26px;
        }
        label {
            font-weight: 500;
            color: #34495e;
            margin-top: 12px;
            display: block;
        }
        input[type="text"], 
        input[type="email"], 
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            font-size: 14px;
            transition: 0.3s;
        }
        input[type="text"]:focus, 
        input[type="email"]:focus, 
        input[type="date"]:focus {
            border-color: #3498db;
            box-shadow: 0px 0px 6px rgba(52,152,219,0.4);
        }
        .radio-group {
            margin: 15px 0;
        }
        .radio-group label {
            display: inline-block;
            margin-right: 20px;
            font-weight: normal;
        }
        .date-range {
            display: flex;
            gap: 10px;
        }
        .btn-submit {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background: #3498db;
            color: white;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }
        .btn-submit:hover {
            background: #2980b9;
            box-shadow: 0px 4px 12px rgba(41,128,185,0.4);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>🔎 Employee Search</h2>
    <form action="${pageContext.request.contextPath}/admin/employee/search" method="get">

        <div class="radio-group">
            <label>
                <input type="radio" name="criteria" value="empId" checked />
                Employee ID
            </label>
            <input type="text" name="empId" placeholder="Enter Employee ID" />
        </div>

        <div class="radio-group">
            <label>
                <input type="radio" name="criteria" value="email" />
                Email
            </label>
            <input type="email" name="email" placeholder="Enter Employee Email" />
        </div>

        <div class="radio-group">
            <label>
                <input type="radio" name="criteria" value="date" />
                Date of Joining Range
            </label>
            <div class="date-range">
                <input type="date" name="startDate" />
                <input type="date" name="endDate" />
            </div>
        </div>

        <button type="submit" class="btn-submit">Search</button>
    </form>
</div>
</body>
</html>
