/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.state;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import socius.stream.Transferencia;

/**
 *
 * @author Ana
 */
public class EstadoOffline implements EstadoComputador{
    private Transferencia transferencia;
    static EstadoOffline IsOffline;

    public Transferencia getTransferencia() {
        return transferencia;
    }
    
    public static EstadoOffline getIsOffline() {
        if(IsOffline==null){
            if(IsOffline==null){
                IsOffline=new EstadoOffline();
            }
        }
        return IsOffline;
    }
    
    public EstadoOffline(){
       
    }

//    public EstadoOffline(Computador pc) {
//        this.pc=pc;
//    }
    @Override
    public void conectar() {
       
        Scanner tc = new Scanner(System.in);
        System.out.println("Deseja se conectar?(y/n)");
        String ans = tc.nextLine();
        if(ans.equalsIgnoreCase("y")){
            try {
//            if(System.getSecurityManager()==null){
//                System.setSecurityManager(new RMISecurityManager());
//            }
                    System.out.println("conectando..");
                    transferencia= (Transferencia) Naming.lookup("rmi://"+ InetAddress.getLocalHost().getHostAddress()+"/Compartilha");

            } catch (UnknownHostException ex) {
                Logger.getLogger(EstadoOffline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(EstadoOffline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(EstadoOffline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                    Logger.getLogger(EstadoOffline.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    @Override
    public void desconectar() {
        System.out.println("Você se já encontra Offline!");
        conectar();
    }

}
