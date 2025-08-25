<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">EMS Admin</a>
        <div class="d-flex">
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="mb-4">Welcome, Admin</h2>

    <div class="row g-4">
         <div class="col-md-4">
            <div class="card shadow border-primary">
                <div class="card-body text-center">
                    <h5>Manage Employees</h5>
                    
                    <a href="${pageContext.request.contextPath}/admin/employee_module?name=subham" class="btn btn-primary mt-3">Go</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card shadow border-success">
                <div class="card-body text-center">
                    <h5>Manage Clients</h5>
                    <a href="${pageContext.request.contextPath}/admin/client_module?name=subham" class="btn btn-success mt-3">Go</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card shadow border-warning">
                <div class="card-body text-center">
                    <h5>Manage Projects</h5>
                    <a href="${pageContext.request.contextPath}/admin/project_module?name=subham" class="btn btn-warning mt-3">Go</a>
                </div>
            </div>
        </div>
                <div class="col-md-4">
            <div class="card shadow border-warning">
                <div class="card-body text-center">
                    <h5>Manage Contacts</h5>
                    <a href="contact_module?name=subham" class="btn btn-warning mt-3">Go</a>
                </div>
            </div>
        </div>
        
    </div>
</div>

</body>
</html>
