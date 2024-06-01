<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Форма Отделения</title>
    <style>
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
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
    </style>
</head>
<body>
<div class="main">
    <div class="container">
        <h1>${department != null ? "Редактировать Отделение" : "Добавить Новое Отделение"}</h1>
        <form action="departments" method="post">
            <div class="form-group">
                <label for="name">Название:</label>
                <input type="text" id="name" name="name" value="${department != null ? department.name : ''}" required>
            </div>
            <input type="hidden" name="id" value="${department != null ? department.id : ''}">
            <input type="hidden" name="action" value="${department != null ? 'update' : 'create'}">
            <input type="submit" class="btn" value="${department != null ? 'Сохранить' : 'Добавить'}">
        </form>
        <a href="departmentList.jsp" class="btn">Назад</a>
    </div>
</div>
</body>
</html>
