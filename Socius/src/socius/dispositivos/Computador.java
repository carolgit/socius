/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import socius.adapter.Arquivo;
import socius.adapter.ArquivoLinux;
import socius.adapter.ArquivoWindows;
import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import socius.state.EstadoComputador;
import socius.state.EstadoOffline;
import socius.stream.Tarefa;

/**
 *
 * @author Ana
 */
public class Computador extends UnicastRemoteObject implements EstadoComputador{
    private String descricao;
    private EstadoComputador estado=EstadoOffline.getIsOffline();
    private List<Arquivo> arquivos= new ArrayList();
    private String dir=System.getProperty("user.dir");
    private String separator=System.getProperty("file.separator");
    private String folder="compartilha";
    private static Computador instancia;
    
    public Computador() throws RemoteException{
      
    }  

    public static Computador getInstancia() {
        if(instancia==null){
            if(instancia==null){
                try {
                    instancia=new Computador();
                } catch (RemoteException ex) {
                    Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return instancia;
    }
    
    public void ClienteServidor(InetAddress host){
      
    }
    
    public List<Arquivo> getArquivos() throws RemoteException{
            //cria diretorio se ele não existir ainda
            String shareFolder=dir+separator+folder;
            File diretorio=new File(shareFolder);
            diretorio.mkdir();
            Arquivo arq=null;
            //percorre os arquivos do diretorio que tipo arquivo e insere nalista
            if(diretorio.listFiles().length!=0){
                for(int i=0;i<diretorio.listFiles().length;i++){
                    File f[]=diretorio.listFiles();
                    if(separator.equals("/")){
        //               arq=new ArquivoUnix();
                       arq=new ArquivoLinux();
                    }else if(separator.equals("\\")){
                       arq=new ArquivoWindows();
                    }
                    arq.setFile(f[i]);
                    arquivos.add(arq);
                }
                return arquivos;
            }else{
                System.out.println("Este# computador não compartilha nenhum arquivo no momento!");
                return null;
            }
    }
    public void atualizarListaArquivos(){
        
    }

    @Override
    public void conectar() {
        estado.conectar();
        
    }

    @Override
    public void desconectar() {
        estado.desconectar();
    }

    public EstadoComputador getEstado() {
        return estado;
    }

    public void setEstado(EstadoComputador estado) {
        this.estado = estado;
    }
    public Object executeTarefa(Tarefa t)throws RemoteException{
        return t.start();
    }
    public void EstadoAcao(){
        try {
            List<String> fileName=new ArrayList<>();
            List<Arquivo> l=Computador.getInstancia().getArquivos();
            if(l!=null){
                for (Arquivo arquivo : l) {
                    fileName.add(arquivo.getFile().getName());
                }
                EstadoOffline.getIsOffline().getTransferencia().listar(InetAddress.getLocalHost().getHostAddress(),fileName);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws RemoteException {
        
        Computador.getInstancia().conectar();
        System.out.println("NovoEstado:"+Computador.getInstancia().getEstado());
        List<Arquivo> l=Computador.getInstancia().getArquivos();
        Computador.getInstancia().EstadoAcao();
        if(l!=null){
            for (Arquivo arquivo : l) {
                System.out.println(arquivo.getFile().getName());
            }
        }
    }
    
}
