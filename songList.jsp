<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Song</h2>
<a href="/song-management/playlist">Add new song</a>
<table border="1">
    <tr>
        <th>#</th>
        <th>Tên bài hát</th>
        <th>Giá</th>
        <th>Thời lượng</th>
        <th>Ngày ra mắt</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="tempSong" items="${songs}" varStatus="i">
     <tr>
         <td>${i.index + 1}</td>
         <td>${tempSong.ten_bai_hat}</td>
         <td>${tempSong.gia}</td>
         <td>${tempSong.thoi_luong}</td>
         <td>${tempSong.ngay_ra_mat}</td>
         <td>
             <a href="/song-management/edit?ten_bai_hat=${tempSong.ten_bai_hat}">Edit</a>
             ||
             <a href="/song-management/delete?ten_bai_hat=${tempSong.ten_bai_hat}">Delete</a>
         </td>
     </tr>
    </c:forEach>
</table>
</body>
</html>
