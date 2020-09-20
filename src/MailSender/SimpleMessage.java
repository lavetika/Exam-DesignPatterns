
package MailSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleMessage {
    
    Session session;

    public SimpleMessage(Session session) {
        this.session = session;   
    }
    
    public MimeMessage obtenerMensaje(String correoRemitente, String correoReceptor, String asunto, String mensajeTexto) {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensajeTexto);
        } catch (AddressException ex) {
            System.out.println("error");
        } catch (MessagingException ex) {
            System.out.println("error");
        }
        return message;
    }
}