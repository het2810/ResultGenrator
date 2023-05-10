<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Result</title>
    <style>
        /* existing styles for the table */
        table {
            height: 600px;
            width: 600px;
            margin: 0 auto;
            border-collapse: collapse;
            border: 2px solid black;
            font-family: Arial, sans-serif;
        }

        th,
        td {
            padding: 10px;
            text-align: center;
            border: 2px solid black;
        }

        th {
            background-color: #FFDAB9;
            font-weight: bold;
        }

        tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        .div {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        /* CSS for the buttons */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            border: 2px solid #000;
            background-color: #f2f2f2;
            color: #000;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #000;
            color: #fff;
        }

        .btn-download {
            background-color: #008CBA;
            border-color: #008CBA;
            color: #fff;
        }

        .btn-download:hover {
            background-color: #006d8a;
            border-color: #006d8a;
            color: #fff;
        }

        .btn-home {
            background-color: #f44336;
            border-color: #f44336;
            color: #fff;
            /* add any other desired styling */
        }

        .btn-home:hover {
            background-color: #d32f2f;
            border-color: #d32f2f;
            color: #fff;
            /* add any other desired styling */
        }

        #result-pending {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        a {
            text-decoration: none;
            color: white;
        }

        @media print {
            .btn {
                display: none;
            }
        }

        @media print {
            * {
                filter: grayscale(100%);
            }
        }
    </style>

<body>
    </head>
    <div class="div">
        <c:if test="${result[0].checkDownload eq 1 }">
            <table border="2">
                <tr>
                    <th colspan="5">Result</th>
                </tr>
                <tr>
                    <th colspan="2">Enrollment Number</th>
                    <td colspan="3">${result[0].enrollmentNumber }</td>
                </tr>
                <tr>
                    <th colspan="2">Name</th>
                    <td colspan="3">${result[0].firstName }</td>
                </tr>
                <tr>
                    <th colspan="2">Course</th>
                    <td colspan="3">BE</td>
                </tr>
                <tr>
                    <th>Subject</th>
                    <th>Internal</th>
                    <th>External</th>
                    <th>Practical</th>
                    <th>Total</th>
                </tr>
                <tr>
                    <th>C</th>
                    <td>${result[0].internal_C }</td>
                    <td>${result[0].external_C }</td>
                    <td>${result[0].practical_C }</td>
                    <td>${result[0].total_C }</td>
                </tr>
                <tr>
                    <th>Python</th>
                    <td>${result[0].internal_Python }</td>
                    <td>${result[0].external_Python }</td>
                    <td>${result[0].practical_Python }</td>
                    <td>${result[0].total_Python }</td>
                </tr>
                <tr>
                    <th>Java</th>
                    <td>${result[0].internal_Java }</td>
                    <td>${result[0].external_Java }</td>
                    <td>${result[0].practical_Java }</td>
                    <td>${result[0].total_Java }</td>
                </tr>
                <tr>
                    <th>Maths</th>
                    <td>${result[0].internal_Maths }</td>
                    <td>${result[0].external_Maths }</td>
                    <td>-</td>
                    <td>${result[0].total_Maths }</td>
                </tr>
                <tr>
                    <th>SPI</th>
                    <td>
                        <c:set var="percentage" value="${(result[0].total/550)*100}" />
                        <c:set var="spi" value="0" />
                        <c:choose>
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
                        </c:choose>
                    </td>

                    <th>Status</th>
                    <td colspan="2">
                        <c:choose>
                            <c:when test="${result[0].internal_C <= 15}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].external_C <=23}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].practical_C <= 19 }">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].internal_Java <= 15}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].external_Java <=23}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].practical_Java <= 19 }">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].internal_Python <= 15}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].external_Python <=23}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].practical_Python <= 19 }">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].internal_Maths <= 15}">
                                FAIL
                            </c:when>
                            <c:when test="${result[0].external_Maths <=23}">
                                FAIL
                            </c:when>
                            <c:otherwise>
                                PASS
                            </c:otherwise>
                        </c:choose>
                    </td>

                </tr>
            </table>

        </c:if>
        <c:if test="${result[0].checkDownload eq  0}">
            <div id="result-pending">
                <h2>Result Pending, Contact to Class Coordinator</h2>
            </div>
        </c:if>
        <div>
            <c:if test="${result[0].checkDownload eq 1 }">
                <a href="javascript:window.print()" class="btn btn-home">Print</a>
            </c:if>
            <a href="studentDashboard" class="btn btn-home">Home</a>
        </div>
    </div>


</body>

</html>