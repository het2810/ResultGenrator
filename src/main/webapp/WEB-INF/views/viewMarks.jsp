<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Marks</title>
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
	<h2>Student Marks</h2>
	<table>
		<thead>
			<tr>
				<th>Enrollment Number</th>
				<th>First Name</th>
				<th>Internal C</th>
				<th>Internal Java</th>
				<th>Internal Python</th>
				<th>Internal Maths</th>
				<th>External C</th>
				<th>External Java</th>
				<th>External Python</th>
				<th>External Maths</th>
				<th>Practical C</th>
				<th>Practical Java</th>
				<th>Practical Python</th>
				<th>Total C</th>
				<th>Total Java</th>
				<th>Total Python</th>
				<th>Total Maths</th>
				<th>Grand Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${student}" var="s">
				<tr>
					<td>${s.enrollmentNumber}</td>
					<td>${s.firstName}</td>
					<td>${s.internal_C eq null ? "" : s.internal_C}</td>
					<td>${s.internal_Java eq null ? "" : s.internal_Java}</td>
					<td>${s.internal_Python eq null ? "" : s.internal_Python}</td>
					<td>${s.internal_Maths eq null ? "" : s.internal_Maths}</td>
					<td>${s.external_C eq null ? "" : s.external_C}</td>
					<td>${s.external_Java eq null ? "" : s.external_Java}</td>
					<td>${s.external_Python eq null ? "" : s.external_Python}</td>
					<td>${s.external_Maths eq null ? "" : s.external_Maths}</td>
					<td>${s.practical_C eq null ? "" : s.practical_C}</td>
					<td>${s.practical_Java eq null ? "" : s.practical_Java}</td>
					<td>${s.practical_Python eq null ? "" : s.practical_Python}</td>
					<td>${s.total_C eq null ? "" : s.total_C}</td>
					<td>${s.total_Java eq null ? "" : s.total_Java}</td>
					<td>${s.total_Python eq null ? "" : s.total_Python}</td>
					<td>${s.total_Maths eq null ? "" : s.total_Maths}</td>
					<td>${s.total_Maths + s.total_Python + s.total_Java + s.total_C}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<a href="listStudents">Back to Student List</a>
</body>
</html>
