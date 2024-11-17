package com.example.Nat_kt.controller;

import com.example.Nat_kt.entity.Book;
import com.example.Nat_kt.service.BookService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BookServlet", value = {
        "/books",
        "/books/new",
        "/books/insert",
        "/books/delete",
        "/books/update",
        "/books/edit"
})

public class BookServlet extends HttpServlet {
    private BookService service = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        System.out.println(path);
        switch (path){
            case "/books":
                listBook(request, response);
                break;
            case "/books/new":
                showForm(request, response);
                break;
            case "/books/insert":
                insertBook(request, response);
                break;
            case "/books/edit":
                editBook(request, response);
                break;
            case "/books/update":
                updateBook(request, response);
                break;
            case "/books/delete":
                deleteBook(request, response);
                break;
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books = new ArrayList<>();
        books = service.getBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/view/listBook.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/addBook.jsp").forward(request, response);

    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Book book = service.getBookById(id);
        request.setAttribute("books", book);
        request.getRequestDispatcher("/view/updateBook.jsp").forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book book = getBookForm(request);
        service.addBook(book);
        response.sendRedirect("/books");
    }

   private static Book getBookForm(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String kind = request.getParameter("kind");
        Integer price = Integer.parseInt(request.getParameter("price"));
       Integer quantity = Integer.parseInt(request.getParameter("quantity"));

       return new Book(id, name, kind, price, quantity);


   }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
      Book book = getBookForm(request);
      service.updateBook(book);
      response.sendRedirect("/students");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.deleteBook(id);
        response.sendRedirect("/students");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
    }
}