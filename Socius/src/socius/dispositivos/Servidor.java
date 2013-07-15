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
import socius.stream.Tarefa;
import socius.stream.Transferencia;

/**
 *
 * @author Ana
 */
public class Servidor extends UnicastRemoteObject implements Transferencia{
    int porta=2013;
    List<String> clientes=new ArrayList<>();
    public Servidor()throws RemoteException {
    }
    public static void main(String[] args) throws Exception {
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
//              Transferencia transferencia=new Download();
//              Naming.rebind("Transferencia",transferencia);
//            System.out.println("servidor aberto e operante!");
//            System.out.println("Lista de Cliente:"+servidor.getClientes());
//              Listar listandoPCs=new ListarImpl();
//              Naming.rebind("Listagem", listandoPCs);
            //dá segurança ao sistema
//            System.setSecurityManager(new RMISecurityManager());
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void escutar(){
        
    }

    public List<String> getClientes() {
        return clientes;
    }
    
    public void getTarefa(Computador c)throws RemoteException{
        System.out.println(c.executeTarefa(new Tarefa()));
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
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
