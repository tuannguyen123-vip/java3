<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/28/2024
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h2>Update Student</h2>

<!-- Form để cập nhật sách -->
<form action="/BookUpdate" method="post">
    <input type="hidden" id="id" name="id" value="${book.id}" />

    <label for="theLoai">Thể loại:</label>
    <input type="text" id="theLoai" name="theLoai" value="${book.theLoai}" required><br><br>

    <label for="tieuDe">Tiêu đề:</label>
    <input type="text" id="tieuDe" name="tieuDe" value="${book.tieuDe}" required><br><br>

    <label for="soLuong">Số lượng:</label>
    <input type="number" id="soLuong" name="soLuong" value="${book.soLuong}" required><br><br>

    <input type="submit" value="Cập nhật sách">
</form>
</body>
</html>
