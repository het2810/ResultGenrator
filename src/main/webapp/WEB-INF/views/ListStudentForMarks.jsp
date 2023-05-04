<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListUsers</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th {
	font-weight: bold;
	background-color: #f5f5f5;
}

td, th {
	padding: 10px;
	text-align: left;
	border: 1px solid #ddd;
}

tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	display: inline-block;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	margin-right: 10px;
}

a:hover {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Enrollment Number</th>
				<th>First Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.enrollmentNumber}</td>
					<td>${user.firstName}</td>
					<td><c:set var="checkMarks"
							value="${addMarksDao.checkMarksExist(user.enrollmentNumber, session.enrollmentNumber)}" />
						<c:choose>
							<c:when test="${empty checkMarks}">
								<a href="addMarks?enrollmentNumber=${user.enrollmentNumber}">Add
									Marks</a>
							</c:when>
							<c:otherwise>
								<a href="updateMarks?enrollmentNumber=${user.enrollmentNumber}">Update
									Marks</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<br>
	<a href="facultyDashboard">HOME</a>
</body>
</html>
