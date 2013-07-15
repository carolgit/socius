/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.stream;

import socius.adapter.Arquivo;
import socius.dispositivos.Computador;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *contrutor possue exception por implementar uma inteface que extende Remote
 * @author Ana
 */
public class Upload extends UnicastRemoteObject implements Transferencia{

    public Upload()throws RemoteException{
    }

    @Override
    public void iniciar(Computador origem, Computador destino, Arquivo arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar(String host,List<String> arquivos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
