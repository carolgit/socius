/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.stream;

import socius.adapter.Arquivo;
import socius.dispositivos.Computador;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface Transferencia extends Remote{
    public void iniciar(Computador origem,Computador destino, Arquivo arquivo)throws RemoteException;
    public void listar(String host,List<String> arquivos)throws RemoteException;
}
