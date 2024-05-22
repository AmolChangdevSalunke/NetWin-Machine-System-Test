<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Sales</title>
    <link rel="stylesheet" href="path/to/your/styles.css">
</head>
<body>
    <h1>Sales Details</h1>
    
    <form method="GET" action="sales">
        <label for="searchCriteria">Search by:</label>
        <select name="searchCriteria" id="searchCriteria">
            <option value="itemName">Item Name</option>
            <option value="customerName">Customer Name</option>
            <option value="customerMobile">Customer Mobile</option>
            <option value="amount">Amount</option>
        </select>
        <input type="text" name="searchValue" placeholder="Enter search value">
        <button type="submit">Search</button>
    </form>
    
    <table border="1">
        <thead>
            <tr>
                <th>Sale ID</th>
                <th>Item Name</th>
                <th>Customer Name</th>
                <th>Customer Age</th>
                <th>Customer State</th>
                <th>Amount</th>
                <th>Sale Date</th>
                <th>Customer Mobile</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sale" items="${sales}">
                <tr>
                    <td>${sale.saleId}</td>
                    <td>${sale.itemName}</td>
                    <td>${sale.customerName}</td>
                    <td>${sale.customerAge}</td>
                    <td>${sale.customerState}</td>
                    <td>${sale.amount}</td>
                    <td>${sale.saleDate}</td>
                    <td>${sale.customerMobile}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div>
        <c:if test="${totalPages > 1}">
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="sales?page=${i}&searchCriteria=${param.searchCriteria}&searchValue=${param.searchValue}">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>