//package com.example.java3n_crud_sd18310.utlis;
//
//import jakarta.mail.Message;
//import jakarta.mail.MessagingException;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.util.Date;
//import java.util.Properties;
//
//public class EmailUtlis {
//
//    public static void sendEmail(
//     String host,
//     String port,
//     final String userName,
//     final String password,
//     String toAddress,
//     String subject,
//     String message
//    ) throws MessagingException {
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls", "true");
//        Authenticator auth = new Authenticator() {
//            public PasswordAuthentication getPasswordAuthentication() {
////                return  new PasswordAuthentication(userName, password);
//            }
//        };
//
//        Session session = Session.getInstance(properties, auth);
//
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress(userName));
//        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSubject(subject);
//        msg.setSentDate(new Date());
//        msg.setText(message);
//
//        Transport.send(msg);
//    }
//}
