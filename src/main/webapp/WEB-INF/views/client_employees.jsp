<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
    <title>Project Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background: linear-gradient(135deg, #d4fc79, #96e6a1);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
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
        .container {
            margin-top: 40px;
        }
        .table {
            background: #fff;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }
        .table thead {
            background: linear-gradient(135deg, #00c6ff, #0072ff);
            color: white;
        }
        .table td, .table th {
            padding: 15px;
            vertical-align: middle;
        }
        .project-name {
            font-weight: 600;
            color: #0072ff;
        }
        .badge {
            margin: 2px;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

    <!-- 🔹 Top Bar -->
    <div class="top-bar">
        <h3 class="text-dark">Project Employees</h3>
        <a href="${pageContext.request.contextPath}/logout">
            <button class="logout-btn">Logout</button>
        </a>
    </div>

    <!-- 🔹 Employees by Project Table -->
    <div class="container">
        <table class="table table-bordered text-center">
            <thead>
                <tr>
                    <th>Project ID</th>
                    <th>Project Name</th>
                     <th>Start Date</th>
                    <th>End Date</th>
                    <th>Extended End Date</th>         
                    <th>Total Employees</th>
                    <th>Employees</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${projects}">
                    <tr>
                        <td>${project.projectId}</td>
                        <td class="project-name">${project.projectName}</td>
                        						<td>
							<c:if test="${not empty project.startDate}">
								<fmt:formatDate value="${project.startDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.startDate}">
								N/A
							</c:if>
						</td>
												<td>
							<c:if test="${not empty project.endDate}">
								<fmt:formatDate value="${project.endDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.endDate}">
								N/A
							</c:if>
						</td>
																		<td>
							<c:if test="${not empty project.extendedEndDate}">
								<fmt:formatDate value="${project.extendedEndDate}" pattern="dd-MM-yyyy" />
							</c:if>
							<c:if test="${empty project.extendedEndDate}">
								N/A
							</c:if>
						</td>
						
                        
                        <td>
                            <c:choose>
                                <c:when test="${not empty project.employees}">
                                    ${fn:length(project.employees)}
                                </c:when>
                                <c:otherwise>0</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:if test="${not empty project.employees}">
                                <c:forEach var="emp" items="${project.employees}">
                                    <span class="badge text-bg-success">${emp.name}</span>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty project.employees}">
                                <span class="text-muted">No Employees Assigned</span>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
