package com.example.BaiKiemTra.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm =
        new DatabaseConnectionManager("test1", "sa", "123456");

    try {
        dcm.getConnection();
        System.out.println("Kết nối thành công");
    }catch (SQLException e){
        e.printStackTrace();
    }
    }
}
