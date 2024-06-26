<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список Отделений</title>
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
        <h1>Список Отделений</h1>
        <a href="departments?action=new" class="btn">Добавить Новое Отделение</a>
        <table class="table">
            <thead>
            <tr>
                <th>Название</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="department" items="${departments}">
                <tr>
                    <td>${department.name}</td>
                    <td>
                        <a href="departments?action=edit&id=${department.id}" class="btn">Редактировать</a>
                        <a href="departments?action=delete&id=${department.id}" class="btn" style="background-color: #dc3545;">Удалить</a>
                        <a href="patientListByDepartment.jsp" class="btn" style="background-color: #28a745;">Просмотреть Пациентов</a>
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
