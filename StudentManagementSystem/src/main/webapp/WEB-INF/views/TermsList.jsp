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

	<table class="data" style="width: 50%" align="center">
		<tr>
			<th>Наименование дисциплины</th>
			<th colspan="2">Действие</th>
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


	<%-- 
	<form:select path="term" multiple="true" items="${activeStaff}"
		itemValue="id" itemLabel="fullName" />

	<form:select path="staffs">
		<c:forEach items="${activeStaff}" var="staffs">
			<form:option value="${staffs}">${staffs.fullName}</form:option>
		</c:forEach>
	</form:select>
 --%>
	<%-- 
	<form:form modelAttribute="Term" method="POST" action="${addTerm}">
		<tr>
			<td>Длительность (в неделях)</td>
			<td><form:input path="duration" /></td>
		</tr>
		<tr>
			<td>Дисциплины в семестре</td>
			<td><form:select path="Term" multiple="true"
					items="${disciplines}" itemLabel="name" itemValue="id" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Сохранить" /></td>
		</tr>


	</form:form>
 --%>


</body>
</html>