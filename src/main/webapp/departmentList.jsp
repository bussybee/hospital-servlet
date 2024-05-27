<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<h2>Departments</h2>
<a href="departments?action=new">Add New Department</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>
                <a href="departments?action=edit&id=${department.id}">Edit</a>
                <a href="departments?action=delete&id=${department.id}">Delete</a>
                <a href="departments?action=viewPatients&id=${department.id}">View Patients</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
