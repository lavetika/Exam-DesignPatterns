
package MailSender;

import Control.Control;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class JavaMailSender implements IMailSender{

    
    @Override
    public void enviarMensaje(MimeMessage message, Control control) {
        try {
            Transport t = message.getSession().getTransport("smtp");
            t.connect(control.getRemitente(), control.getPassword());
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El correo o constraseña ingresado no incorrecto.","Error de sesion", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
