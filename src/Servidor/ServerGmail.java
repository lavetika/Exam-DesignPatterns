
package Servidor;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.AddressException;


public class ServerGmail implements IServer{

    @Override
    public Session crearServidor() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        return session;
    }

}
