/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Cris
 */
public class EMAIL {
    
    public void EnviarCorreo(File data, File... img) throws IOException {
        final String username = "personabus@gmail.com";
        final String password = "Asd123654asd";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
	
        try {
            MimeBodyPart imagePart = new MimeBodyPart();
            MimeBodyPart imagePart2 = new MimeBodyPart();
            imagePart2.attachFile(data);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("aalfaroq@utn.ac.cr")
                    /*InternetAddress.parse("crissanabriah3@gmail.com")*/
            );
            message.setSubject("Mensaje ultra secreto");
            message.setText("Abre el link del QR para revelar los secretos del universo");
            Multipart mpt = new MimeMultipart();
            if (img.length > 0) {
                imagePart.attachFile(img[0]);
                mpt.addBodyPart(imagePart);
            }
            mpt.addBodyPart(imagePart2);
            message.setContent(mpt);
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

