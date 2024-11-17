
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Add New Book</title>
</head>
<body>
<h3>Edit Student</h3>
<form action="/books/update" method="post">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td><input type="text" name="id" value="${book.id}" readonly> </td>
        </tr>
        <tr>
            <td><label>Name</label></td>
            <td><input type="text" name="name" value="${book.name}"> </td>
        </tr>
        <tr>
            <td><label>KInd</label></td>
            <td><input type="text" name="kind" value="${book.kind}"> </td>
        </tr>
        <tr>
            <td><label>Price</label></td>
            <td><input type="text" name="price" value="${book.price}"> </td>
        </tr>
        <tr>
            <td><label>Quantity</label></td>
            <td><input type="text" name="quantity" value="${book.quantity}"> </td>
        </tr>

        <td><label></label></td>
        <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>
