<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Пациенты Отделения</title>
    <style>
        .btn {
            display: inline-block;
            padding: 10px 15px;
            font-size: 14px;
            cursor: pointer;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }
        .table th, .table td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        .table th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="container">
        <h1>Пациенты Отделения</h1>
        <table class="table">
            <thead>
            <tr>
                <th>ФИО</th>
                <th>Возраст</th>
                <th>Пол</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>${patient.fullName}</td>
                    <td>${patient.age}</td>
                    <td>${patient.gender}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="departmentList.jsp" class="btn">Назад к Отделениям</a>
    </div>
</div>
</body>
</html>
