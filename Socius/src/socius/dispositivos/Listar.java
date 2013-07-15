/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface Listar extends Remote{
    public List<Computador> getLista()throws RemoteException;
    public void setLista(Computador pc)throws RemoteException;
}
