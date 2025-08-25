<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>EMS - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <style>
        body {
            background: linear-gradient(to right, #6a11cb, #2575fc);
            font-family: 'Segoe UI', sans-serif;
        }

        .login-container {
            margin-top: 80px;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-primary {
            border-radius: 10px;
            font-weight: bold;
            background: linear-gradient(to right, #2575fc, #6a11cb);
            border: none;
        }

        .btn-primary:hover {
            background: linear-gradient(to right, #6a11cb, #2575fc);
        }

        .alert {
            border-radius: 10px;
        }

        .logo {
            width: 60px;
            height: 60px;
            object-fit: contain;
        }

        .signup-link {
            margin-top: 10px;
            font-size: 0.9rem;
        }

        .signup-link a {
            text-decoration: none;
            font-weight: bold;
            color: #2575fc;
        }

        .signup-link a:hover {
            text-decoration: underline;
            color: #6a11cb;
        }
    </style>
</head>
<body>

<div class="container login-container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card p-4">
                <div class="text-center mb-3">
                    <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
                         class="logo" alt="Logo">
                    <h4 class="mt-2">Employee Management System</h4>
                </div>

                <%-- Show Success/Error Message --%>
                <%
                    String success = (String) request.getAttribute("success");
                    String error = (String) request.getAttribute("error");
                    if (success != null) {
                %>
                    <div class="alert alert-success"><%= success %></div>
                <% } else if (error != null) { %>
                    <div class="alert alert-danger"><%= error %></div>
                <% } %>
<c:if test="${not empty successMsg}">
    <div class="alert alert-success">
        ${successMsg}
    </div>
</c:if>

                <form action="${pageContext.request.contextPath}/login" method="get">
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                </form>


                <div class="mt-3 text-center">
                    <small class="text-muted">© 2025 EMS | All Rights Reserved</small>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
