
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Sales</h1>
	<form action="/sales" method="post">
		<!-- form fields for sale details -->
		<button type="submit">Add Sale</button>
	</form>
	<ul>
		<c:forEach items="${sales}" var="sale">
			<li>${sale.custName}- ${sale.item.itemName} - ${sale.payAmount}</li>
		</c:forEach>
	</ul>
	<div>
		<c:if test="${currentPage > 0}">
			<a href="/sales?page=${currentPage - 1}">Previous</a>
		</c:if>
		<c:if test="${currentPage < totalPages - 1}">
			<a href="/sales?page=${currentPage + 1}">Next</a>
		</c:if>
	</div>
</body>
</html>