<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script>
	function confirmDelete() {
		return confirm("Are you sure you want to delete this Student?");
	}
</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th rowspan="2">Enrollment Number</th>
				<th rowspan="2">First Name</th>
				<th colspan="3">C</th>
				<th colspan="3">JAVA</th>
				<th colspan="3">PYTHON</th>
				<th colspan="2">MATHS</th>
				<th rowspan="2">TOTAL</th>
				<th rowspan="2">SPI</th>
				<th rowspan="2">STATUS</th>
			</tr>
			<tr>
				<th>Internal Marks</th>
				<th>External Marks</th>
				<th>Practical Marks</th>
				<th>Internal Marks</th>
				<th>External Marks</th>
				<th>Practical Marks</th>
				<th>Internal Marks</th>
				<th>External Marks</th>
				<th>Practical Marks</th>
				<th>Internal Marks</th>
				<th>External Marks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.enrollmentNumber}</td>
					<td>${student.firstName}</td>
					<td>${student.internal_C }</td>
					<td>${student.external_C }</td>
					<td>${student.practical_C }</td>
					<td>${student.internal_Java }</td>
					<td>${student.external_Java }</td>
					<td>${student.practical_Java }</td>
					<td>${student.internal_Python }</td>
					<td>${student.external_Python }</td>
					<td>${student.practical_Python }</td>
					<td>${student.internal_Maths }</td>
					<td>${student.external_Maths }</td>
					<td>${student.total }</td>
					<td><c:set var="percentage" value="${(student.total/550)*100}" />
						<c:set var="spi" value="0" /> <c:choose>
							<c:when test="${percentage < 40}">
								<c:set var="spi" value="0" />
								<c:out value="${spi}" />
							</c:when>
							<c:when test="${percentage >= 40 and percentage <= 44}">
								<c:set var="spi" value="${((percentage-40)/4)}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 45 and percentage <= 49}">
								<c:set var="spi" value="${((percentage-45)/5)+4}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 50 and percentage <= 54}">
								<c:set var="spi" value="${((percentage-50)/5)+5}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 55 and percentage <= 59}">
								<c:set var="spi" value="${((percentage-55)/5)+6}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 60 and percentage <= 64}">
								<c:set var="spi" value="${((percentage-60)/5)+7}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 65 and percentage <= 69}">
								<c:set var="spi" value="${((percentage-65)/5)+8}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 70 and percentage <= 79}">
								<c:set var="spi" value="${((percentage-70)/10)+9}" />
								<fmt:formatNumber value="${spi}" pattern="#0.00" />
							</c:when>
							<c:when test="${percentage >= 80}">
								<c:set var="spi" value="10" />
								<c:out value="${spi}" />
							</c:when>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${student.internal_C <= 15}">
								FAIL
							</c:when>
							<c:when test="${student.external_C <=23}">
								FAIL
							</c:when>
							<c:when test="${student.practical_C <= 19 }">
								FAIL
							</c:when>
							<c:when test="${student.internal_Java <= 15}">
								FAIL
							</c:when>
							<c:when test="${student.external_Java <=23}">
								FAIL
							</c:when>
							<c:when test="${student.practical_Java <= 19 }">
								FAIL
							</c:when>
							<c:when test="${student.internal_Python <= 15}">
								FAIL
							</c:when>
							<c:when test="${student.external_Python <=23}">
								FAIL
							</c:when>
							<c:when test="${student.practical_Python <= 19 }">
								FAIL
							</c:when>
							<c:when test="${student.internal_Maths <= 15}">
								FAIL
							</c:when>
							<c:when test="${student.external_Maths <=23}">
								FAIL
							</c:when>
							<c:otherwise>
								PASS
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<a href="dashboard">HOME</a>
	<a href="listStudents">Student List</a>
</body>
</html>
