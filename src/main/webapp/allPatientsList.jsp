<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список Всех Пациентов</title>
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
        <h1>Список Всех Пациентов</h1>
        <a href="patients?action=new" class="btn">Добавить Нового Пациента</a>
        <table class="table">
            <thead>
            <tr>
                <th>ФИО</th>
                <th>Возраст</th>
                <th>Пол</th>
                <th>Отделение</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>${patient.fullName}</td>
                    <td>${patient.age}</td>
                    <td>${patient.gender}</td>
                    <td>${patient.departmentName}</td>
                    <td>
                        <a href="patients?action=edit&id=${patient.id}" class="btn">Редактировать</a>
                        <a href="patients?action=delete&id=${patient.id}" class="btn">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="index.jsp" class="btn">Назад</a>
    </div>
</div>
</body>
</html>
