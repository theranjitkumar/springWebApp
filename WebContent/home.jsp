<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	<h3>${title }</h3>
	<a href="./about">about</a>
	<hr/>
	<form method="post" action="./">
		<label>id</label> <input type="text" name="id"> <br>
		<label>name</label> <input type="text" name="name"> <br>
		<label>city</label> <input type="text" name="city"> <br>
		<input type="submit" value="submit">
	</form>

<hr/>
	<ul>
		<c:forEach var="listValue" items="${students}">
			<li>${listValue.id}-${listValue.name}-${listValue.city}</li>
		</c:forEach>
	</ul>


	<a href="./add">add</a>
	<a href="./update">update</a>
	<a href="./delete">delete</a>

</body>
</html>