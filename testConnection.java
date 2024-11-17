package com.example.java3n_crud_sd18310.jdbc;

import java.sql.SQLException;

public class testConnection {
    public static void main(String[] args) {
      DatabaseConnectionManager dcm  = new DatabaseConnectionManager("test1","sa","2005");
      try {
          dcm.getConnection();
          System.out.println("Bạn đã kết nối thành công!");
      } catch (SQLException e) {
          e.printStackTrace();
      }
    }

}
