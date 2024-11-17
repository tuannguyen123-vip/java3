package com.example.BaiKiemTra.Service;

import com.example.BaiKiemTra.Entity.Sach;
import com.example.BaiKiemTra.Respository.Book_Repo;


import java.util.ArrayList;

public class Book_Service {
    private Book_Repo bookDao = new Book_Repo();

    public ArrayList<Sach> getAll() {
        return bookDao.getAll();
    }

    public void deleteBook(long id) {

        bookDao.deleteBook(id);
    }

    public void addBook(Sach newSach) {

        bookDao.addBook(newSach);
    }

    public Sach getSachById(long id) {

        bookDao.getSachById(id);
        return null;
    }

    public void updateBook(Sach updatedBook) {
    }
}
