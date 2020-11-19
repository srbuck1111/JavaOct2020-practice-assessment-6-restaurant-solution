<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	th {
		text-align : left;
		color : red;
		background-color : blue;
	}
	a {
		text-align : right;
		color : blue;
		background-color : pink;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="restaurant" items="${restaurants }">
				<tr>
					<td>${restaurant.name }</td>
					<td>${restaurant.rating }</td>
					<td><a href="/vote/${restaurant.id }?option=1">upvote</a>
					<td><a href="/vote/${restaurant.id }?option=-1">downvote</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/sorted?sortBy=rating">Sort by rating</a>
	<a href="/sorted?sortBy=name">Sort by name</a>
</body>
</html>