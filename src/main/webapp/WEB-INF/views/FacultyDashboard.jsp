<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Faculty Dashboard</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
    }

    #navbar {
      background-color: #333;
      overflow: hidden;
    }

    #navbar a {
      float: right;
      color: #f2f2f2;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      font-size: 17px;
    }

    #navbar a:hover {
      background-color: #ddd;
      color: black;
    }

    #navbar a.active {
      background-color: #4CAF50;
      color: white;
    }

    #header {
      background-color: #f2f2f2;
      text-align: center;
      padding: 50px;
    }

    #header h1 {
      font-size: 50px;
      margin: 0;
    }

    #container {
      margin: 50px auto;
      text-align: center;
    }

    .big-button {
      display: inline-block;
      background-color: #4CAF50;
      color: white;
      font-size: 24px;
      padding: 20px 40px;
      margin: 10px;
      border-radius: 5px;
      text-decoration: none;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
    }

    .big-button:hover {
      background-color: #3e8e41;
    }
    
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

  </style>
</head>
<body>
  <div id="navbar">
    <a href="loginAsStudentOrFaculty">Logout</a>
    <a href="facultyDashboard" class="active">Home</a>
  </div>
  
  <div id="header">
    <h1>Faculty Dashboard</h1>
  </div>

  <div id="container">
    <a href="listStudentForMarks" class="big-button">List Student</a>
  </div>


</body>
</html>
