<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/28/2024
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add book</h2>
<!-- Form để thêm sinh viên mới -->
<form action="/Servlet_Book" method="post">

    <label for="id">ID:</label>
    <input type="text" id="id" name="id" required><br><br>

    <label for="theLoai">Thể loại:</label>
    <input type="text" id="theLoai" name="theLoai" required><br><br>

    <label for="tieuDe">Tiêu đề:</label>
    <input type="text" id="tieuDe" name="tieuDe" required><br><br>

    <label for="soLuong">Số Lượng:</label>
    <input type="number" id="soLuong" name="soLuong" required><br><br>

    <input type="submit" value="Add New Book">
</form>

<table border="1">
        <a href="/Servlet_Book">Add new Student</a>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Thể loại</th>
        <th>Tiêu đề</th>
        <th>Số lượng</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${ListBook}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${book.id}</td>
            <td>${book.theLoai}</td>
            <td>${book.tieuDe}</td>
            <td>${book.soLuong}</td>
            <td>
                <a href="/students/edit?id=${book.id}">Edit</a>
                ||
                <a href="/BookDelete?id=${book.id}"  onclick="return confirm('Bạn có muốn xóa quyển này không ?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
