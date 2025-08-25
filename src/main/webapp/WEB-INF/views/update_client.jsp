<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Employee - EMS</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    margin: 0;
    padding: 0;
}

.container {
    width: 40%;
    margin: 50px auto;
    background: white;
    padding: 25px;
    box-shadow: 0px 4px 15px rgba(0,0,0,0.1);
    border-radius: 8px;
}

h2 {
    text-align: center;
    color: #2c3e50;
    margin-bottom: 20px;
}

form label {
    display: block;
    margin-bottom: 6px;
    font-weight: bold;
    color: #333;
}

form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

form input:focus {
    border-color: #007BFF;
    outline: none;
}

.btn {
    display: inline-block;
    padding: 10px 18px;
    border-radius: 5px;
    text-decoration: none;
    font-size: 14px;
    border: none;
    cursor: pointer;
    color: white;
}

.btn-update {
    background-color: #28a745;
}

.btn-update:hover {
    background-color: #218838;
}

.btn-back {
    background-color: #6c757d;
    margin-left: 10px;
}

.btn-back:hover {
    background-color: #5a6268;
}
</style>
</head>
<body>

<div class="container">
    <h2>Update Client</h2>

    <form action="${pageContext.request.contextPath}/admin/client/update"  method="post">
        <input type="hidden" name="userId" value="${client.userId}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${client.name}" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${client.email}" required readonly="readonly">


        <label for="relationshipDate">RelationshipDate:</label>
        <input type="date" id="relationshipDate" name="relationshipDate"
               value="<fmt:formatDate value='${client.relationshipDate}' pattern='yyyy-MM-dd'/>" required>

        <button type="submit" class="btn btn-update">Update</button>
        <a href="${pageContext.request.contextPath}/list" class="btn btn-back">Cancel</a>
    </form>
</div>

</body>
</html>
