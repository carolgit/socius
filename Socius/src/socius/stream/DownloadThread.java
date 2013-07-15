/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.stream;

import socius.adapter.Arquivo;
import socius.dispositivos.Computador;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class DownloadThread implements Runnable{
    private Arquivo arquivo;
    private Computador computador;
    private Download download;

    public DownloadThread(Arquivo arquivo, Computador computador, Download download) {
        this.arquivo = arquivo;
        this.computador = computador;
        this.download = download;
    }
    
    @Override
    public void run() {
        byte buffer[] = new byte[(int)arquivo.getFile().length()];  
        try {
             while((arquivo.getStream().read(buffer))>0){  
                    download.getOut().write(buffer);
                   }
             } catch (IOException ex) {
                Logger.getLogger(DownloadThread.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    public void setTransferencia(Transferencia t){
    }
    
}
