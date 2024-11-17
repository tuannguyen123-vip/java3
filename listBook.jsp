<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Students</h2>
<a href="/books/new">Add New Book</a>
<table border="1">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>Kind</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="tempBook" items="${book}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${tempBook.id}</td>
            <td>${tempBook.name}</td>
            <td>${tempBook.kind}</td>
            <td>${tempBook.price}</td>
            <td>${tempBook.quantity}</td>
            <td>
                <a href="/books/edit?id=${tempBook.id}">Edit</a>
                ||
                <a href="/books/delete?id=${tempBook.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

