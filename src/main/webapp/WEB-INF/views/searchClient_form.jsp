<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Client</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #ccc;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            margin: 20px 0;
            padding: 20px;
            background: #fafafa;
            border-radius: 8px;
            border: 1px solid #ddd;
        }
        label {
            font-weight: bold;
            margin-right: 10px;
        }
        input[type=text] {
            width: 70%;
            padding: 8px;
            margin-right: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        input[type=submit] {
            padding: 8px 20px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Client Search</h2>

    <!-- 🔹 Form 1: Search Client by ID -->
    <form action="${pageContext.request.contextPath}/admin/client/search-id" method="get">
        <label for="userId">Search Client by ID:</label>
        <input type="text" name="userId" placeholder="Enter Client ID (e.g., CL-001)" required />
        <input type="submit" value="Search Client" />
    </form>

    <!-- 🔹 Form 2: Search Client Projects by Client ID -->
    <form action="${pageContext.request.contextPath}/admin/client/searchProjects" method="get">
        <label for="clientId">Search Client Projects:</label>
        <input type="text" name="clientId" placeholder="Enter Client ID (e.g., CL-001)" required />
        <input type="submit" value="Search Projects" />
    </form>
</div>

</body>
</html>
