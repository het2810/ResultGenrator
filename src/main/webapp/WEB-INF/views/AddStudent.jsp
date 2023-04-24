<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333333;
            text-align: center;
            margin-top: 50px;
        }
        form {
            width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #bbbbbb;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
            color: #333333;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #ffffff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0062cc;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Add Student</h1>
    <form method="post" action="addStudent">
        <label>Enrollment Number:</label> <input type="text" name="enrollmentNumber" required><br>
        <label>Name:</label> <input type="text" name="firstName" required><br>
        <label>Email:</label> <input type="text" name="email" required><br>
        <label>Password:</label> <input type="password" name="password" required><br>
        <input type="submit" value="Add Student">
        <c:if test="${not empty errorMessage}">
    		<div class="alert alert-danger">${errorMessage}</div>
		</c:if>
        <a href="dashboard">HOME</a>
    </form>
</body>
</html>