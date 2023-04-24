<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Faculty</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333333;
        }

        form {
            border: 3px solid #f1f1f1;
            margin-top: 50px;
            margin-bottom: 50px;
            padding: 20px;
            background-color: white;
        }

        input[type=text], input[type=password], input[type=submit] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type=radio] {
            margin-right: 10px;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Add Faculty</h1>
    <form method="post" action="addFaculty">
        Enrollment Number: <input type="text" name="enrollmentNumber" required><br>
        Name: <input type="text" name="firstName" required><br>
        Email: <input type="text" name="email" required><br>
        Subject:
        <input type="radio" name="subjectRoleId" value="C" checked>C
        <input type="radio" name="subjectRoleId" value="JAVA">JAVA
        <input type="radio" name="subjectRoleId" value="PYTHON">PYTHON
        <input type="radio" name="subjectRoleId" value="MATHS">MATHS<br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="AddFaculty">
	    <a href="dashboard">HOME</a>
    </form>
</body>
</html>
