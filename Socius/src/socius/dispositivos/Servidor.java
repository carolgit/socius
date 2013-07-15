/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import socius.adapter.Arquivo;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import socius.stream.Transferencia;

/**
 *
 * @author Ana
 */
public class Servidor extends UnicastRemoteObject implements Transferencia{
    private List<String> clientes=new ArrayList<>();
    
    public Servidor()throws RemoteException {
    }
    
    public void escutar() throws Exception {
        
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            //cria um objeto remoto
             Servidor servidor=new Servidor();
             //setar a instancia corrente
             Naming.rebind("Compartilha",servidor);
             System.out.println("Servidor Aberto e Operante!");
             for(int i=0;i<servidor.getClientes().size();i++){
                 System.out.println(""+servidor.getClientes().get(i));
             }

        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<String> getClientes() {
        return clientes;
    }



    @Override
    public void iniciar(Computador origem, Computador destino, Arquivo arquivo) throws RemoteException {
    }

    @Override
    public void listar(String host,List<String> arquivos) throws RemoteException {
        clientes.add(host);
        System.out.println("lista:"+clientes);
        System.out.println("host:"+host+"arquivos:"+arquivos);
    }
    
}
