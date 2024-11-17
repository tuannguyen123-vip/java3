package com.example.BaiKiemTra.Controller;

import com.example.BaiKiemTra.Entity.Sach;
import com.example.BaiKiemTra.Service.Book_Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet_Book", value = {"/Servlet_Book",
        "/BookDelete",
        "/books/edit",
        "/BookUpdate"})
public class Servlet_Book extends HttpServlet {
    private Book_Service service = new Book_Service();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        // Hiển thị danh sách sinh viên
        if(uri.contains("/Servlet_Book")) {
            ArrayList<Sach> list = service.getAll();
            request.setAttribute("ListBook", list);
            request.getRequestDispatcher("/view/ListBook.jsp").forward(request, response);


        }// Xóa sinh viên
        else if(uri.contains("/BookDelete")) {
            long id = Long.parseLong(request.getParameter("id"));
            service.deleteBook(id);
            response.sendRedirect("/Servlet_Book");


        }// Hiển thị form cập nhật sinh viên
        else if (uri.contains("/books/edit")) {
            long id = Long.parseLong(request.getParameter("id"));
            Sach sach = service.getSachById(id);
            request.setAttribute("sach", sach);
            request.getRequestDispatcher("/view/editBook.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        // Thêm sinh viên mới
        if (uri.contains("/Servlet_Book")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String theLoai = request.getParameter("theLoai");
            String tieuDe = request.getParameter("tieuDe");
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));

            Sach newSach = new Sach(id, theLoai, tieuDe, soLuong);
            service.addBook(newSach);

            response.sendRedirect("/Servlet_Book");
        }
        else if(uri.contains("/BookUpdate")) { // Kiểm tra xem có phải là yêu cầu cập nhật sách không

                // Lấy thông tin sách từ form
                Long id = Long.parseLong(request.getParameter("id"));
                String theLoai = request.getParameter("theLoai");
                String tieuDe = request.getParameter("tieuDe");
                int soLuong = Integer.parseInt(request.getParameter("soLuong"));

                // Cập nhật thông tin sách
                Sach updatedBook = new Sach(id, theLoai, tieuDe, soLuong);
                service.updateBook(updatedBook); // Giả sử bạn đã có phương thức updateBook trong BookService

                // Sau khi cập nhật, chuyển hướng về trang danh sách sách
                response.sendRedirect("/Servlet_Book");

        }
    }
}
