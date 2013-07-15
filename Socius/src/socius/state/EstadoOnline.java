/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.state;

import socius.dispositivos.Computador;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class EstadoOnline implements EstadoComputador{
    static EstadoOnline IsOnline;

    public static EstadoOnline getIsOnline() {
        if(IsOnline==null){
            if(IsOnline==null){
                IsOnline=new EstadoOnline();
            }
        }
        return IsOnline;
    }
    
    public EstadoOnline(){
       
    }

//    public EstadoOnline(Computador pc) {
//        this.pc = pc;
//    }

    @Override
    public void conectar() {
        System.out.println("Você já se encontra Online!");
        desconectar();
    }

    @Override
    public void desconectar() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Deseja se desconectar?(y/n)");
        String ans = tc.nextLine();
        if(ans.equalsIgnoreCase("y")){
            System.out.println("desconectando..");
            Computador.getInstancia().setEstado(EstadoOffline.getIsOffline());
        }
    }
}
