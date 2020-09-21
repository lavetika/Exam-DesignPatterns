/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author laura
 */
public class ServerHotmail implements IServer{
    @Override
    public Session crearServidor() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        return session;
    }   
}
