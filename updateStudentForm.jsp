
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Update Student Form</title>
</head>
<body>
<h3>Edit Student</h3>
<form action="/students/update" method="post">
  <table>
    <tr>
      <td><label>ID</label></td>
      <td><input type="text" name="id" value="${student.id}" readonly> </td>
    </tr>
    <tr>
      <td><label>Name</label></td>
      <td><input type="text" name="name" value="${student.name}"> </td>
    </tr>
    <tr>
      <td><label>Email</label></td>
      <td><input type="text" name="email" value="${student.email}"> </td>
    </tr>
    <tr>
      <td><label>Phone</label></td>
      <td><input type="text" name="phone" value="${student.phone}"> </td>
    </tr>
      <td><label></label></td>
      <td><input type="submit" value="Save"></td>
    </tr>
  </table>
</form>
</body>
</html>
