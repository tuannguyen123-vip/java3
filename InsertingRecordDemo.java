package com.example.BaiKiemTra.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertingRecordDemo {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm =
                new DatabaseConnectionManager("test1", "sa", "123456");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dcm.getConnection();
            String sql = """
             INSERT INTO students(id, name, email, phone)     
             VALUES (?,?,?,?);
                      """;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, 1001L);
            preparedStatement.setString(2,"student 2");
            preparedStatement.setString(3, "email 3");
            preparedStatement.setString(4, "phone 4");

            preparedStatement.executeUpdate();

            System.out.println("done...");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dcm.close(resultSet, preparedStatement, connection);
        }
    }
}
