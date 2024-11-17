package com.example.BaiKiemTra.Respository;

import com.example.BaiKiemTra.Entity.Sach;
import com.example.BaiKiemTra.jdbc.DatabaseConnectionManager;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Book_Repo {

   private static DatabaseConnectionManager dcm =
            new DatabaseConnectionManager("test1", "sa", "123456");

    public static ArrayList<Sach> list = new ArrayList<>();
    static{
        list.add(new Sach(101,"name1", "email1", 1));
        list.add(new Sach(1012,"name2", "email2", 4));
        list.add(new Sach(1031,"name3", "email3", 5));
    }

    public ArrayList<Sach> getAll() {
        ArrayList<Sach> list1 = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dcm.getConnection();
            String sql = """
    SELECT * FROM sach;
    """;

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
               Sach sach = new Sach();
               sach.setId(resultSet.getLong("id"));
               sach.setTheLoai((resultSet.getString("theLoai")));
               sach.setTieuDe(resultSet.getString("tieuDe"));
               sach.setSoLuong(resultSet.getInt("soLuong"));
                list1.add(sach);
            }

            System.out.println("done...");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dcm.close(resultSet, preparedStatement, connection);
        }

        return list1;


    }

    public void deleteBook(long id) {

         list.removeIf(sach -> sach.getId() == id);
    }

    public void addBook(Sach newSach) {

        list.add(newSach);
    }

    public void getSachById(long id) {


    }
}
