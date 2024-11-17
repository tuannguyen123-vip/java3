
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new song</title>
</head>
<body>
<h3>Add Song</h3>
<form action="/song-management/insert" method="post">
 <table>
     <tr>
         <td><label>Tên bài hát</label></td>
         <td><input type="text" name="ten_bai_hat"></td>
     </tr>
     <tr>
         <td><label>Giá</label></td>
          <td><input type="text" name="gia"></td>
     </tr>
     <tr>
         <td><label>Thời lượng</label></td>
         <td><input type="text" name="thoi_luong"></td>
     </tr>
     <tr>
         <td><label>Ngày ra mắt</label></td>
          <td><input type="date" name="ngay_ra_mat"></td>
     </tr>
     <tr>
         <td><label></label></td>
         <td><input type="submit" value="save"></td>
     </tr>
 </table>
</form>
</body>
</html>
