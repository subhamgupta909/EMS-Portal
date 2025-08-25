<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Client Registration</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
	margin: 0;
	padding: 0;
}

.container {
	width: 450px;
	margin: 50px auto;
	background: #fff;
	padding: 30px 40px;
	border-radius: 12px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
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

input[type=text], input[type=email], input[type=date], select {
	width: 100%;
	padding: 10px 12px;
	margin-top: 6px;
	border-radius: 8px;
	border: 1px solid #ccc;
	font-size: 14px;
	box-sizing: border-box;
}

input:focus, select:focus {
	border-color: #ff7f50;
	outline: none;
	box-shadow: 0 0 4px rgba(255, 127, 80, 0.5);
}

button {
	width: 100%;
	margin-top: 22px;
	padding: 12px;
	background: #ff7f50;
	color: white;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: background 0.3s ease;
}

button:hover {
	background: #e85c35;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Client Registration</h2>

		<form:form method="post"
			action="${pageContext.request.contextPath}/admin/client/save"
			modelAttribute="client">

			<label>Client Name:</label>
			<form:input path="name" placeholder="Enter client name" />

			<label>Email:</label>
			<form:input path="email" type="email"
				placeholder="Enter client email" />
			<label>Password:</label>
			<form:input path="password" type="password"
				placeholder="Enter client email" />

			<label>Date of Relationship:</label>
			<form:input path="relationshipDate" type="date" />

			<label>Role:</label>
			<form:select path="role">
				<form:option value="" label="-- Select Role --" />
				<form:option value="ROLE_CLIENT" label="Client" />
				<form:option value="ROLE_ADMIN" label="Admin" />
				<form:option value="ROLE_EMPLOYEE" label="Employee" />

			</form:select>

			<button type="submit">Save Client</button>
		</form:form>
	</div>
</body>
</html>
