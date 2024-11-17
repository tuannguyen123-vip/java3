package com.example.Nat_kt.service;

import com.example.Nat_kt.entity.Book;
import com.example.Nat_kt.repository.BookDao;

import java.util.ArrayList;

public class BookService {
    private BookDao  bookDao = new BookDao();

    public ArrayList<Book> getBooks(){

        return bookDao.getBooks();
}
public void deleteBook(Long id) {
    bookDao.deleteBook(id);
}
public void addBook(Book book){
    bookDao.addBook(book);
}
public void updateBook(Book book){
bookDao.updateBook(book);
}
public Book getBookById(Long id){
return bookDao.getBookById(id);
}
}
