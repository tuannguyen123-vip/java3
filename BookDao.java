package com.example.Nat_kt.repository;

import com.example.Nat_kt.entity.Book;
import com.example.Nat_kt.jdbc.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

   private static DatabaseConnectionManager dcm = new DatabaseConnectionManager("sach" , "sa", "123456");

    private static ArrayList<Book> books = new ArrayList<>();
    static {
        books.add(new Book(1001L, "book 1", "co tic", 10, 2));
        books.add(new Book(1002L, "book 2", "vui ve", 20, 10));
        books.add(new Book(1003L, "book 3", "tru thu", 30, 3));
    }
    public ArrayList<Book> getBooks(){
        ArrayList<Book> books1 = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dcm.getConnection();
            String sql = """
            SELECT * FROM quyensach;
                    """;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setKind(resultSet.getString("kind"));
                book.setPrice(resultSet.getInt("price"));
                book.setQuantity(resultSet.getInt("quantity"));

                books1.add(book);
            }
            System.out.println("nhap du lieu thanh cong");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dcm.close(resultSet, preparedStatement, connection);
        }
        return books1;
    }

    public void deleteBook(Long id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dcm.getConnection();
            String sql = """
DELETE FROM quyensach WHERE id = ?;
                    """;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("nhap du lieu thanh cong");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
         dcm.close(null, preparedStatement, connection);
        }
    }

    public void addBook(Book book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = dcm.getConnection();
            String sql = """
                    INSERT INTO quyensach(id, name, kind, price, quantity)
                    VALUES(?,?,?,?,?);
                    """;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getKind());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.executeUpdate();

            System.out.println("nhap du lieu thanh cong");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
       dcm.close(resultSet, preparedStatement, connection);
        }
    }

    public void updateBook(Book book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = dcm.getConnection();
            String sql = """
                    UPDATE quyensach SET name = ?, kind = ?, price = ?, quantity = ? WHERE id = ?;
                    """;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(5, book.getId());
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getKind());
            preparedStatement.setInt(3, book.getPrice());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.executeUpdate();

            System.out.println("nhap du lieu thanh cong");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dcm.close(resultSet, preparedStatement, connection);
        }
    }

    public Book getBookById(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}
