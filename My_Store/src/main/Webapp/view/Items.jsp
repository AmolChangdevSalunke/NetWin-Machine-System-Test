<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Items</h1>
	<form action="/items" method="post">
		Item Name: <input type="text" name="itemName" />
		<button type="submit">Add Item</button>
	</form>
	<ul>
		<c:forEach items="${items}" var="item">
			<li>${item.itemName}</li>
		</c:forEach>
	</ul>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>