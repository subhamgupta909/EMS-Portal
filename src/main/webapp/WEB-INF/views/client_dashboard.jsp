<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #9face6);
            min-height: 100vh;
        }
        .dashboard-container {
            margin-top: 60px; /* cards thoda upar */
        }
        .card {
            border-radius: 15px;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
            min-height: 150px;
        }
        .card:hover {
            transform: translateY(-6px);
            box-shadow: 0 8px 18px rgba(0,0,0,0.25);
        }
        .card h5 {
            font-weight: bold;
            font-size: 1.2rem;
        }
        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 40px;
        }
        .logout-btn {
            background: #ff4b5c;
            border: none;
            color: white;
            font-weight: bold;
            padding: 8px 18px;
            border-radius: 25px;
            transition: 0.3s;
        }
        .logout-btn:hover {
            background: #e60023;
        }
    </style>
</head>
<body>

    <!-- 🔹 Top Bar with Logout -->
    <div class="top-bar">
        <h3 class="text-dark">Client Dashboard</h3>
        <a href="${pageContext.request.contextPath}/logout">
            <button class="logout-btn">Logout</button>
        </a>
    </div>

    <!-- 🔹 Dashboard Content -->
    <div class="container dashboard-container">
        <div class="row g-4 justify-content-center">

            <!-- Card 1 -->
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/client/details" class="text-decoration-none">
                    <div class="card text-center text-white bg-gradient p-4" style="background: linear-gradient(135deg,#667eea,#764ba2);">
                        <h5>My Details</h5>
                        <p class="mt-2">View your personal details</p>
                    </div>
                </a>
            </div>

            <!-- Card 2 -->
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/client/projects" class="text-decoration-none">
                    <div class="card text-center text-white p-4" style="background: linear-gradient(135deg,#11998e,#38ef7d);">
                        <h5>View Projects</h5>
                        <p class="mt-2">See your projects</p>
                    </div>
                </a>
            </div>

            <!-- Card 3 -->
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/client/employees" class="text-decoration-none">
                    <div class="card text-center text-white p-4" style="background: linear-gradient(135deg,#fc6076,#ff9a44);">
                        <h5>View Employees</h5>
                        <p class="mt-2">Check employees on your projects</p>
                    </div>
                </a>
            </div>

        </div>
    </div>

</body>
</html>
