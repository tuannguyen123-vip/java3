package com.example.java03_NAT.controller;

import com.example.java03_NAT.entity.Song;
import com.example.java03_NAT.service.SongService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SongServlet", value = {
        "/song-management",
        "/song-management/playlist",
        "/song-management/update",
        "/song-management/delete",
        "/song-management/edit",
        "/song-management/insert",
})
public class SongServlet extends HttpServlet {

    private SongService service = new SongService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        switch(path){
            case "/song-management":
                listSong(request, response);
                break;
            case "/song-management/update":
                 updateSong(request, response);
                 break;
            case "/song-management/delete":
                deleteSong(request, response);
                break;
            case "/song-management/edit":
                editSong(request, response);
                break;
            case "/song-management/playlist":
                showNewForm(request,response);
                break;
            case "/song-management/insert":
                insertSong(request, response);
                break;
        }
    }

    private void insertSong(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Song song = getSongForm(request);
    service.addSong(song);
    response.sendRedirect("/song-management");
    }

    private static Song getSongForm(HttpServletRequest request) {
        String ten_bai_hat = request.getParameter("ten_bai_hat");
        Integer gia = Integer.parseInt(request.getParameter("gia"));
        Integer thoi_luong = Integer.parseInt(request.getParameter("thoi_luong"));
        String ngay_ra_mat = request.getParameter("ngay_ra_mat");

        return new Song(ten_bai_hat, gia, thoi_luong, ngay_ra_mat);
    }


    private void updateSong(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Song song = getSongForm(request);
        service.updateSong(song);
        response.sendRedirect("/song-management");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/addSong.jsp").forward(request, response);
    }

    private void editSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ten_bai_hat = request.getParameter("ten_bai_hat");
    Song song = service.getSongById(ten_bai_hat);
    request.setAttribute("songs", song);
    request.getRequestDispatcher("/view/updateSong.jsp").forward(request, response);
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String ten_bai_hat = request.getParameter("ten_bai_hat");
    service.deleteSong(ten_bai_hat);
    response.sendRedirect("/song-management");
    }

    private void listSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Song> song = new ArrayList<>();
        song = service.getSongs();
        request.setAttribute("songs", song);
        request.getRequestDispatcher("/view/songList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request, response);
    }
}