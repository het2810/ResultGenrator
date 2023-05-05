<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <c:forEach items="${users}" var="user">
        <tr>
          <td>${user.enrollmentNumber}</td>
          <td>${user.firstName}</td>
          <td>1</td>
          <td>2</td>
          <td>3</td>
          <td>4</td>
          <td>5</td>
          <td>6</td>
          <td>7</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <br><br>
  <a href="dashboard">HOME</a>
  <a href="listStudents">Student List</a>
</body>
</html>
