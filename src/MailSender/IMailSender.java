
package MailSender;

import Control.Control;
import javax.mail.internet.MimeMessage;


public interface IMailSender {
    
    public void enviarMensaje(MimeMessage message, Control control);
    
}
