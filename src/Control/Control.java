/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import MailSender.IMailSender;
import MailSender.JavaMailSender;
import MailSender.SimpleMessage;
import Servidor.FactoryServer;
import Servidor.IServer;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author laura
 */
public class Control {
    private String correoRemitente;
    private String correoReceptor;
    private String asunto;
    private String mensajeTexto;
    private String password;
    private String server;

    public Control() {
    }
    
    
    public Control(String correoRemitente, String correoReceptor, String asunto, String mensajeTexto, String password, String server){
        this.correoRemitente = correoRemitente;
        this.correoReceptor = correoReceptor;
        this.asunto = asunto;
        this.mensajeTexto = mensajeTexto;
        this.password = password;
        this.server = server;
    }

    private Session crearServer(String nameServer) {
        FactoryServer fabrica = new FactoryServer();
        IServer servidor = fabrica.crearServer(nameServer);
        return servidor.crearServidor();
    }

    private MimeMessage crearMessage(Session session) {
        SimpleMessage mensaje = new SimpleMessage(session);
        return mensaje.obtenerMensaje(correoRemitente, correoReceptor, asunto, mensajeTexto);
    }
    
    public void enviarMessage(){
        IMailSender enviador = new JavaMailSender();
        enviador.enviarMensaje(crearMessage(crearServer(server)), this);
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getRemitente(){
        return correoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensajeTexto() {
        return mensajeTexto;
    }

    public void setMensajeTexto(String mensajeTexto) {
        this.mensajeTexto = mensajeTexto;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
