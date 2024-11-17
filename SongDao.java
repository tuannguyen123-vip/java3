package com.example.java03_NAT.repository;

import com.example.java03_NAT.entity.Song;
import com.example.java03_NAT.jdbc.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;



public class SongDao {

    private static DatabaseConnectionManager dcm = new DatabaseConnectionManager(
        "PTPM_FINALLY_SOF203", "sa", "123456");

    private static ArrayList<Song> songs = new ArrayList<>();
    static {
        songs.add(new Song("muaphun", 120000, 1225, "2022-10-12"));
        songs.add(new Song("emcuangayhomqua", 1200, 12, "2020-02-12"));
        songs.add(new Song("ethangban", 120000, 1233, "2020-12-12"));
    }

        public ArrayList<Song> getSongs(){
        ArrayList<Song> songs1 = new ArrayList<>();

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
               connection = dcm.getConnection();
               String sql = """
                  SELECT ten_bai_hat, gia, thoi_luong, ngay_ra_mat FROM bai_hat;     
                       """;
               preparedStatement = connection.prepareStatement(sql);
               resultSet = preparedStatement.executeQuery();
               while (resultSet.next()){
                   Song song = new Song();
                   song.setTen_bai_hat(resultSet.getString("ten_bai_hat"));
                   song.setGia(resultSet.getInt("gia"));
                   song.setThoi_luong(resultSet.getInt("thoi_luong"));
                   song.setNgay_ra_mat(resultSet.getString("ngay_ra_mat"));

                    songs1.add(song);
               }
                System.out.println("Nhap du lieu thanh cong");
            }catch (SQLException ex){
               ex.printStackTrace();
            }finally {
              dcm.close(resultSet, preparedStatement, connection);
            }
        return songs1;
        }

        public void addSong(Song song) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
      try {
          connection = dcm.getConnection();
          String sql = """
                  INSERT INTO bai_hat(ten_bai_hat, gia, thoi_luong, ngay_ra_mat)
                  VALUES(?,?,?,?);
                  """;
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, song.getTen_bai_hat());
           preparedStatement.setInt(2, song.getGia());
           preparedStatement.setInt(3, song.getThoi_luong());
           preparedStatement.setString(4, song.getNgay_ra_mat());
           preparedStatement.executeUpdate();

          System.out.println("Nhap du lieu thanh cong");

      }catch (SQLException ex){
      ex.printStackTrace();
      }finally {
     dcm.close(resultSet, preparedStatement, connection);
      }
    }

    public void updateSong(Song song){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dcm.getConnection();
            String sql = """
                 UPDATE bai_hat SET gia = ?, thoi_luong = ?, ngay_ra_mat = ? WHERE ten_bai_hat = ?;
                 """;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4, song.getTen_bai_hat());
            preparedStatement.setInt(1, song.getGia());
            preparedStatement.setInt(2, song.getThoi_luong());
            preparedStatement.setString(3, song.getNgay_ra_mat());
            preparedStatement.executeUpdate();

            System.out.println("Nhap du lieu thanh cong");

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            dcm.close(resultSet, preparedStatement, connection);
        }
    }

    public void deleteSong(String ten_bai_hat){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dcm.getConnection();
            String sql = """
                    DELETE FROM bai_hat WHERE ten_bai_hat = ?;
                 """;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ten_bai_hat);
            preparedStatement.executeUpdate();

            System.out.println("Nhap du lieu thanh cong");

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            dcm.close(null, preparedStatement, connection);
        }
    }

    public Song getSongById(String ten_bai_hat){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dcm.getConnection();
            String sql = "SELECT ten_bai_hat, gia, thoi_luong, ngay_ra_mat FROM bai_hat WHERE ten_bai_hat = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ten_bai_hat);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Song(
                        resultSet.getString("ten_bai_hat"),
                        resultSet.getInt("gia"),
                        resultSet.getInt("thoi_luong"),
                        resultSet.getString("ngay_ra_mat")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dcm.close(resultSet, preparedStatement, connection);
        }
        return null;
    }
}
