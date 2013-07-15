/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.app;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import socius.dispositivos.Servidor;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class ServerBoot {
    
    public static void main(String[] args) {
        
        // Instancia e inicializa o Servidor para
        // escuta e atendimento de requisições na respectiva porta
        Servidor server;
        try {
            server = new Servidor();
            server.escutar();
        } catch (RemoteException ex) {
            Logger.getLogger(ServerBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
