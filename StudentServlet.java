package com.example.java3n_crud_sd18310.controller;

import com.example.java3n_crud_sd18310.entity.Student;
import com.example.java3n_crud_sd18310.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "StudentServlet", value = "/StudentServlet/*")
@WebServlet(name = "StudentServlet", value = {
        "/students",
        "/students/new",
        "/students/insert",
        "/students/delete",
        "/students/update",
        "/students/edit"
})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String path = request.getServletPath();
        System.out.println(path);
switch(path){
    case "/students":
        listStudents(request,response);
        break;
    case "/students/new":
        showNewForm(request,response);
        break;
    case "/students/insert":
        insertStudent(request,response);
        break;
    case "/students/edit":
        editStudent(request,response);
        break;
    case "/students/update":
        updateStudent(request,response);
        break;
    case "/students/delete":
        deleteStudent(request,response);
        break;
}


    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //read student from form
        Student student = getStudentFromForm(request);
        //update student in list
        service.updateStudent(student);
        //back to table
        response.sendRedirect("/students");


    }

    private static Student getStudentFromForm(HttpServletRequest request) {
        // read students info from form

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        //create new students
        return new Student(id, name, email, phone);
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //load data student info to form
        // get id
        Long id = Long.parseLong(request.getParameter("id"));
        //get student by id
        Student student = service.getStudentById(id);
        //send to jsp
        request.setAttribute("student", student);
        request.getRequestDispatcher("/view/updateStudentForm.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/addStudentForm.jsp")
                .forward(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Id
        Long id = Long.parseLong(request.getParameter("id"));

        // delete
        service.deleteStudent(id);

        // back to view
        response.sendRedirect("/students");
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
// read students info from form

        Student student = getStudentFromForm(request);

        //add student to list
        service.addStudent(student);
        // back to table
        response.sendRedirect("/students");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // data: students
        ArrayList<Student> students = new ArrayList<>();

        students = service.getStudents();

        //students.add(new Student(1001L, "student 1", "email 1", "phone 1"));
        //students.add(new Student(1002L, "student 2", "email 2", "phone 2"));
        //students.add(new Student(1003L, "student 3", "email 3", "phone 3"));

        // => jsp
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
