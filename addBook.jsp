<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<h3>Add Student</h3>
<form action="/books/insert" method="post">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td><input type="text" name="id"> </td>
        </tr>
        <tr>
            <td><label>Name</label></td>
            <td><input type="text" name="name"> </td>
        </tr>
        <tr>
            <td><label>Kind</label></td>
            <td><input type="text" name="kind"> </td>
        </tr>
        <tr>
            <td><label>Price</label></td>
            <td><input type="text" name="price"> </td>
        </tr>
        <tr>
            <td><label>Quantity</label></td>
            <td><input type="text" name="quantity"> </td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>

