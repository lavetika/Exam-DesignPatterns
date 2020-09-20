
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
            
        }
        
        System.out.println("Si se envio, ya vayanse a dormir");
    }
    
}
