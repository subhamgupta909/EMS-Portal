<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="container mt-4">

    <!-- Top Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h3>Welcome, ${employee.name} 👋</h3>
        <form action="${pageContext.request.contextPath}/logout" method="get">
            <button type="submit" class="btn btn-danger btn-sm">Logout</button>
        </form>
    </div>

    <div class="row">
        <!-- My Details Card -->
        <div class="col-md-6 mb-3">
            <form action="${pageContext.request.contextPath}/employee/details" method="get">
                <input type="hidden" name="view" value="details"/>
                <button type="submit" class="card shadow-lg rounded-3 w-100 btn btn-light text-start">
                    <div class="card-body">
                        <h5 class="card-title text-primary">My Details</h5>
                        <p class="text-muted mb-0">Click to view your personal details</p>
                    </div>
                </button>
            </form>
        </div>

        <!-- View Project Card -->
        <div class="col-md-6 mb-3">
            <form action="${pageContext.request.contextPath}/employee/project" method="get">
                <input type="hidden" name="view" value="project"/>
                <button type="submit" class="card shadow-lg rounded-3 w-100 btn btn-light text-start">
                    <div class="card-body">
                        <h5 class="card-title text-success">View Project</h5>
                        <p class="text-muted mb-0">Click to view your project details</p>
                    </div>
                </button>
            </form>
        </div>
    </div>

    <!-- Dynamic Section -->
    <div class="row mt-4">
        <div class="col-md-12">
<c:choose>
    <%-- My Details Section --%>
    <c:when test="${view eq 'details'}">
        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white">My Details</div>
            <div class="card-body">
                <table class="table table-bordered table-striped">
                    <tr><th>Name</th><td>${employee.name}</td></tr>
                    <tr><th>Email</th><td>${employee.email}</td></tr>
                    <tr><th>Department</th><td>${employee.dept}</td></tr>
                    <tr><th>Phone</th><td>${employee.phone}</td></tr>
                    <tr><th>Date of Joining</th>						<td>
							<c:if test="${not empty employee.dateOfJoining}">
								<fmt:formatDate value="${employee.dateOfJoining}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty employee.dateOfJoining}">
								N/A
							</c:if>
						</td>
</tr>
                </table>
            </div>
        </div>
    </c:when>

    <%-- Project Section --%>
    <c:when test="${view eq 'project'}">
        <div class="card shadow-lg">
            <div class="card-header bg-success text-white">My Project</div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty project}">
                        <table class="table table-bordered table-striped">
                            <tr><th>Project Name</th><td>${project.projectName}</td></tr>
                            <tr><th>Start Date</th>						<td>
							<c:if test="${not empty project.startDate}">
								<fmt:formatDate value="${project.startDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.startDate}">
								N/A
							</c:if>
						</td>
</tr>
                            <tr><th>Old End Date</th>												<td>
							<c:if test="${not empty project.endDate}">
								<fmt:formatDate value="${project.endDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.endDate}">
								N/A
							</c:if>
						</td>
</tr>
                            <tr><th>Extended End Date</th>												<td>
							<c:if test="${not empty project.extendedEndDate}">
								<fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.extendedEndDate}">
								N/A
							</c:if>
						</td>
</tr>

                            <tr><th>Client Name</th><td>${project.client.name}</td></tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="text-muted">No project assigned yet.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:when>
</c:choose>
        </div>
    </div>
</div>

</body>
</html>
