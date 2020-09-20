
package Servidor;

/**
 *
 * @author laura
 */
public class FactoryServer {
    public IServer crearServer(String nameServer){
        
        if(nameServer.equalsIgnoreCase("Outlook")){
            return new ServerOutlook();
        }else if(nameServer.equalsIgnoreCase("Gmail")){
            return new ServerGmail();
        }else if(nameServer.equalsIgnoreCase("Yahoo")){
            return new ServerYahoo();
        }else{
            return new ServerHotmail();
        }
    }
}
