<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Department Form</title>
</head>
<body>
<h2>${department.id == null ? 'Add New' : 'Edit'} Department</h2>
<form action="departments" method="post">
    <input type="hidden" name="id" value="${department.id}"/>
    <label>Name:</label>
    <input type="text" name="name" value="${department.name}"/><br/>
    <input type="hidden" name="action" value="${department.id == null ? 'create' : 'update'}"/>
    <input type="submit" value="Save"/>
</form>
<a href="departments">Back to List</a>
</body>
</html>

