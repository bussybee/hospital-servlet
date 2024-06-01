<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редактировать Пациента</title>
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
<div class="container">
    <h1>Редактировать Пациента</h1>
    <form action="edit" method="post">
        <input type="hidden" name="id" value="${patient.id}">
        <div class="form-group">
            <label for="fullName">ФИО</label>
            <input type="text" id="fullName" name="full_name" value="${patient.fullName}" required>
        </div>
        <div class="form-group">
            <label for="age">Возраст</label>
            <input type="number" id="age" name="age" value="${patient.age}" required>
        </div>
        <div class="form-group">
            <label for="gender">Пол</label>
            <input type="text" id="gender" name="gender" value="${patient.gender}" required>
        </div>
        <div class="form-group">
            <label for="departmentId">ID Отделения</label>
            <input type="number" id="departmentId" name="department_name" value="${patient.departmentName}" required>
        </div>
        <button type="submit" class="btn">Сохранить</button>
    </form>
    <a href="list" class="btn">Назад</a>
</div>
</body>
</html>
