
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send email</title>
</head>
<body>
  <form method="post" action="">
      <table border="1">
          <caption h3>Send new email</caption>
      <tr>
          <td>Recipient Address</td>
          <td><input type="text" name="recipient"></td>
      </tr>
          <tr>
           <td>Subject</td>
              <td><input type="text" name="subject"></td>
          </tr>
          <tr>
              <td>Content</td>
              <td><textarea rows="10" ></textarea></td>
          </tr>
      <tr>
          <td colspan="2" ><input type="submit" value="send"></td>
      </tr>


      </table>
  </form>
</body>
</html>
















