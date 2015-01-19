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
	<br>
	<a href="<c:url value="/TitlePage" />">На главную</a>

	<h1 align="center">Система управления студентами и их
		успеваемостью</h1>

	<form:form method="post" action="addDiscipline"
		commandName="discipline">

		<table align="center">
			<tr>
				<td><form:label path="disciplinename">Название</form:label></td>
				<td><form:input path="disciplinename" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input type="submit"
					value="Создать" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>