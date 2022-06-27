<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Spring Project</h1>
	<div align="center">
		
		<form action="showAddStudentPage">
		<input type="submit" value="ADD">
		</form>
		<table border="1">
			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>mobile</td>
					<td>location</td>
				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobileNumber}</td>
					<td>${student.location}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>