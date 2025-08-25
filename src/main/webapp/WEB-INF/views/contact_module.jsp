<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Contact Person Module</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            text-align: center;
        }
        h2 {
            margin-top: 40px;
            color: #2c3e50;
        }
        .card-container {
            display: flex;
            justify-content: center;
            margin-top: 50px;
            gap: 30px;
        }
        .card {
            width: 250px;
            height: 150px;
            background: white;
            border-radius: 12px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }
        .card:hover {
            transform: scale(1.05);
            background: #3498db;
            color: white;
        }
        a {
            text-decoration: none;
            color: inherit;
        }
    </style>
</head>
<body>

    <h2>📌 Contact Person Management</h2>

    <div class="card-container">
        <a href="${pageContext.request.contextPath}/admin/contactperson/add">
            <div class="card">➕ Add Contact Person</div>
        </a>

        <a href="${pageContext.request.contextPath}/admin/contact-person/view">
            <div class="card">👁 View Contact Persons</div>
        </a>

        <a href="${pageContext.request.contextPath}/admin/contact-person/search">
            <div class="card">🔍 Search Contact Person</div>
        </a>
    </div>

</body>
</html>
