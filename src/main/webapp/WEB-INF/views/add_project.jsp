<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Project</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0 rounded-3">
        <div class="card-header bg-primary text-white text-center">
            <h3>Add New Project</h3>
        </div>
        <div class="card-body p-4">

            <form action="${pageContext.request.contextPath}/admin/project/save" method="post"  modelattribute="project">
                
                <!-- Project Name -->
                <div class="mb-3">
                    <label for="projectName" class="form-label">Project Name</label>
                    <input type="text" class="form-control" id="projectName" name="projectName" placeholder="Enter project name" required>
                </div>

                <!-- Start Date -->
                <div class="mb-3">
                    <label for="startDate" class="form-label">Start Date</label>
                    <input type="date" class="form-control" id="startDate" name="startDate" required>
                </div>

                <!-- End Date -->
                <div class="mb-3">
                    <label for="endDate" class="form-label">End Date</label>
                    <input type="date" class="form-control" id="endDate" name="endDate" required>
                </div>

                <!-- Client Dropdown -->
                <div class="mb-3">
                    <label for="userId" class="form-label">Select Client</label>
                    <select class="form-select" id="userId" name="userId" required>
                        <option value="">-- Select Client --</option>
                        <c:forEach var="c" items="${clientList}">
                            <c:if test="${c.role == 'ROLE_CLIENT'}">
                                <option value="${c.userId}">${c.name} - ${c.userId}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

                <!-- Submit Button -->
                <div class="text-center">
                    <button type="submit" class="btn btn-success px-4">Add Project</button>
                    <a href="project?action=list" class="btn btn-secondary px-4">Cancel</a>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
