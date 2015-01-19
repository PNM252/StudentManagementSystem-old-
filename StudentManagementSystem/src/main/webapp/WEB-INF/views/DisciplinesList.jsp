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
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	
}

table tr:nth-child(even) {
	background-color: #eee;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table th {
	background-color: gray;
	color: black;
	
}

#td1 {
	width: 1px;
	
}
</style>
<body>

	<a href="<c:url value="/logout" />"> Выйти из приложения </a>
	<br>
	<a href="<c:url value="/TitlePage" />">На главную</a>

	<h1 align="center">Система управления студентами и их
		успеваемостью</h1>

	<table align="center">
		<tr align="center">
			<td><form action="DisciplineCreating">
					<input type="submit" value="Создать димциплину">
				</form></td>
		</tr>
	</table>

	<h3 align="center">Дисциплины</h3>
	<c:if test="${!empty disciplineList}">
		<table class="data" style="width: 50%" align="center">
			<tr>
				<th>Наименование дисциплины</th>
				<th colspan= "2">Действие</th>
			</tr>
			<c:forEach items="${disciplineList}" var="discipline">
				<tr>
					<td>${discipline.disciplinename}</td>
					<td id="td1"><form
							action="/StudentManagementSystem/editDiscipline
					/${discipline.disciplineID}">
							<input type="submit" value="Редактировать">
						</form></td>
					<td id="td1"><form
							action="deleteDiscipline/${discipline.disciplineID}">
							<input type="submit" value="Удалить">
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>