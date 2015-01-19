<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Система управления студентами и их успеваемостью</title>
</head>
<style>
input[type=submit] {
	width: 10em;
	height: 2em;
}
</style>
<body>

	<!-- 	<body bgcolor="white"> -->

	<a href="<c:url value="/logout" />"> Выйти из приложения </a>

	<h1 align="center">Система управления студентами и их
		успеваемостью</h1>

	<table align="center">
		<tr>
			<td><form action="StudentsList">
					<input type="submit" value="Студенты">
				</form></td>
			<td><form action="DisciplinesList">
					<input type="submit" value="Дисциплины">
				</form></td>
			<td><form action="TermsList">
					<input type="submit" value="Семестры">
				</form></td>
	</table>

</body>
</html>