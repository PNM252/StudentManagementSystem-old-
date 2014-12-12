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
<body>

	<a href="<c:url value="/logout" />"> Выйти из приложения </a>

	<h1 align="center">Система управления студентами и их
		успеваемостью</h1>

	<form:form commandName="student" action="save" method="post">

		<table align="center">
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id" readonly="true" /></td>
			<tr>
				<td><form:label path="firstname">Имя</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Фамилия</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="studentgroup">Группа</form:label></td>
				<td><form:input path="studentgroup" /></td>
			</tr>
			<tr>
				<td><form:label path="dateofadmission">Дата Поступления</form:label></td>
				<td><form:input path="dateofadmission" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Сохранить"></input></td>
			</tr>
		</table>
	</form:form>

</body>
</html>