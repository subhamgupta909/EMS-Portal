<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Contact Person</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
            width: 400px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #2c3e50;
        }
        .form-group {
            margin-bottom: 18px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #34495e;
        }
        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            transition: 0.3s;
        }
        input:focus {
            border-color: #3498db;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.6);
        }
        button {
            margin-top: 10px;
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            background: #3498db;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>➕ Add Contact Person</h2>
        <form action="${pageContext.request.contextPath}/admin/contact-person/save" method="post" modelAttribute="contactPerson">
            
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" placeholder="Enter full name" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter email" required>
            </div>

            <div class="form-group">
                <label>Phone</label>
                <input type="text" name="phone" placeholder="Enter phone number" required>
            </div>

            <div class="form-group">
                <label>Designation</label>
                <input type="text" name="designation" placeholder="Enter designation">
            </div>

            <button type="submit">Save Contact Person</button>
        </form>
    </div>

</body>
</html>
