package com.example.java3n_crud_sd18310;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmailSendingServlet", value = "/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("emailcom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String host = "smtp.gmail.com";
         String port = "587";
         String user = "";
         String pass = "";

         String recipient = request.getParameter("recipient");
         String subject = request.getParameter("subject");
         String content = request.getParameter("content");

         String resultMessage = "";

         try{
//             EmailUtlis.sendEmail(host, port, user, pass, recipient, subject, content);
             resultMessage = "Email sent ...";

         }catch (Exception e){
             e.printStackTrace();
             resultMessage = "Error";
         }finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/emailResult/ ");

         }

    }
}