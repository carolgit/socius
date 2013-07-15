/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana
 */
public class ListarImpl extends UnicastRemoteObject implements Listar{
    private List<Computador> lista= new ArrayList();
    
    public ListarImpl() throws RemoteException{
    }

    @Override
    public List<Computador> getLista() throws RemoteException {
        return this.lista;
    }

    @Override
    public void setLista(Computador pc) throws RemoteException {
        lista.add(pc);
    }
    
}
