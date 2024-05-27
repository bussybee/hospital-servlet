<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patients</title>
</head>
<body>
<h2>Patients</h2>
<a href="departments">Back to Departments</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.id}</td>
            <td>${patient.fullName}</td>
            <td>${patient.age}</td>
            <td>${patient.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
