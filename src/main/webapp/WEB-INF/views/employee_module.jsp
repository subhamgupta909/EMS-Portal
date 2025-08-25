<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Manage Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">EMS Admin - Employees</a>
        <div class="d-flex">
            <a href="${pageContext.request.contextPath}/admin" class="btn btn-outline-light me-2">Back to Dashboard</a>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Logout</a>
        </div>
    </div>
</nav>

<!-- Page Title -->
<div class="container mt-5">
    <h2 class="mb-4">Employee Management</h2>

    <!-- Cards Section -->
    <div class="row g-4">
        <!-- Add Employee -->
        <div class="col-md-4">
            <div class="card shadow border-primary">
                <div class="card-body text-center">
                    <h5>Add Employee</h5>
                    <a href="${pageContext.request.contextPath}/admin/employee/add" class="btn btn-primary mt-3">Go</a>
                </div>
            </div>
        </div>

        <!-- View All Employees -->
        <div class="col-md-4">
            <div class="card shadow border-success">
                <div class="card-body text-center">
                    <h5>View All Employees</h5>
                    <a href="${pageContext.request.contextPath}/admin/employee_list" class="btn btn-success mt-3">Go</a>
                </div>
            </div>
        </div>

        <!-- Bench Employees -->
        <div class="col-md-4">
            <div class="card shadow border-warning">
                <div class="card-body text-center">
                    <h5>Bench Employees</h5>
                    <a href="${pageContext.request.contextPath}/admin/employee/bench" class="btn btn-warning mt-3">Go</a>
                </div>
            </div>
        </div>


        <!-- Search Employee -->
        <div class="col-md-4">
            <div class="card shadow border-dark">
                <div class="card-body text-center">
                    <h5>Search Employee</h5>
                    <a href="${pageContext.request.contextPath}/admin/search" class="btn btn-dark mt-3">Go</a>
                </div>
            </div>
        </div>
        <!-- Assign Project -->
        <div class="col-md-4">
            <div class="card shadow border-info">
                <div class="card-body text-center">
                    <h5>Assign Project</h5>
                    <a href="${pageContext.request.contextPath}/admin/employee/assign-project" class="btn btn-info mt-3">Go</a>
                </div>
            </div>
        </div>
        <!-- Release Employee -->
        <div class="col-md-4">
            <div class="card shadow border-dark">
                <div class="card-body text-center">
                    <h5>Release Employee</h5>
                    <a href="${pageContext.request.contextPath}/admin/employee/release" class="btn btn-dark mt-3">Go</a>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
