<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update new song</title>
</head>
<body>
<h3>Edit song</h3>
<form action="/song-management/update" method="post">
    <table>
        <tr>
            <td><label>Tên bài hát</label></td>
            <td><input type="text" name="ten_bai_hat" value="${songs.ten_bai_hat}" readonly></td>
        </tr>
        <tr>
            <td><label>Giá</label></td>
            <td><input type="text" name="gia" value="${songs.gia}"></td>
        </tr>
        <tr>
            <td><label>Thời lượng</label></td>
            <td><input type="text" name="thoi_luong" value="${songs.thoi_luong}"></td>
        </tr>
        <tr>
            <td><label>Ngày ra mắt</label></td>
            <td><input type="date" name="ngay_ra_mat" value="${songs.ngay_ra_mat}"></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>

</form>
</body>
</html>
