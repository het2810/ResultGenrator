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

thead {
	background-color: #f5f5f5;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

th:first-child,
td:first-child {
	border-top: none;
}

td {
	vertical-align: middle;
}

.student-info {
	display: flex;
	justify-content: space-between;
}

.student-info div {
	margin-bottom: 10px;
}

</style>
</head>
<body>
	<h2>Student Marks</h2>
	<table>
		<thead>
			<tr>
				<th>Enrollment Number</th>
				<td>${student[0].enrollmentNumber}</td>
			</tr>
			<tr>
				<th>First Name</th>
				<td>${student[0].firstName}</td>
			</tr>
		</thead>
	</table>
	<table>
		<thead>
			<tr>
				<th>Subject</th>
				<th>Internal Marks</th>
				<th>External Marks</th>
				<th>Practical Marks</th>
				<th>Total Marks</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>C</td>
				<td>${student[0].internal_C eq "-1" ? "-" : student[0].internal_C}</td>
                <td>${student[0].external_C eq "-1" ? "-" : student[0].external_C}</td>
                <td>${student[0].practical_C eq "-1" ? "-" : student[0].practical_C}</td>
                <td>${student[0].total_C eq "-1" ? "0" : student[0].total_C}</td>
          </tr>
			<tr>
				<td>Java</td>
				<td>${student[0].internal_Java eq "-1" ? "-" : student[0].internal_Java}</td>
				<td>${student[0].external_Java eq "-1" ? "-" : student[0].external_Java}</td>
				<td>${student[0].practical_Java eq "-1" ? "-" : student[0].practical_Java}</td>
				<td>${student[0].total_Java eq "-1" ? "-" : student[0].total_Java}</td>
			</tr>
			<tr>
				<td>Python</td>
				<td>${student[0].internal_Python eq "-1" ? "-" : student[0].internal_Python}</td>
				<td>${student[0].external_Python eq "-1" ? "-" : student[0].external_Python}</td>
				<td>${student[0].practical_Python eq "-1" ? "-" : student[0].practical_Python}</td>
				<td>${student[0].total_Python eq "-1" ? "-" : student[0].total_Python}</td>
			</tr>
			<tr>
				<td>Maths</td>
				<td>${student[0].internal_Maths eq "-1" ? "-" : student[0].internal_Maths}</td>
				<td>${student[0].external_Maths eq "-1" ? "-" : student[0].external_Maths}</td>
				<td>-</td>
				<td>${student[0].total_Maths eq "-1" ? "-" : student[0].total_Maths}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>Grand Total</th>
				<td>${student[0].total_Maths + student[0].total_Python + student[0].total_Java + student[0].total_C}</td>
			</tr>
		</tfoot>
	</table>
	<br>
	<br>
	<a href="listStudents">Back to Student List</a>
</body>
