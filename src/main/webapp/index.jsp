<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
        }
        .main{
            max-width: 10000px;
            background-color: #fff;
        }
        h1 {
            text-align: center;
            font-size: 36px;
            margin-bottom: 10px;
        }
        p {
            text-align: center;
            font-size: 18px;
            margin-top: 0;
        }
        .btn {
            display: block;
            width: 200px;
            height: 40px;
            margin: 20px auto;
            background-color: #007bff;
            color: #fff;
            text-align: center;
            line-height: 40px;
            font-size: 18px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .table {
            margin-top: 30px;
            border-collapse: collapse;
            width: 100%;
            text-align: left;
        }
        .table th, .table td {
            padding: 50px;
            border: 1px solid #ddd;
        }
        .table th {
            background-color: #f5f5f5;
            font-weight: bold;
        }
        .title {
            text-align: center;
            font-size: 36px;
            margin-top: 30px;
            margin-bottom: 10px;
        }
        .subtitle {
            text-align: center;
            font-size: 18px;
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="container">
        <h1>Hospital Management System</h1>
        <table class="table">
            <tr>
                <td>
                    <h2 class="title">Отделения</h2>
                    <p class="subtitle">Список отделений с информацией о пациентах</p>
                    <a href="departmentList.jsp" class="btn">Перейти</a>
                </td>
                <td>
                    <h2 class="title">Пациенты</h2>
                    <p class="subtitle">Список пациентов с указанием отделения</p>
                    <a href="allPatientsList.jsp" class="btn">Перейти</a>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
