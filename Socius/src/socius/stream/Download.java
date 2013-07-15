/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.stream;

import socius.adapter.Arquivo;
import socius.dispositivos.Computador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *contrutor possue exception por implementar uma inteface que extende Remote
 * @author Ana
 */
public class Download extends UnicastRemoteObject implements Transferencia{
    private File file;
    private File copy;
    private final String separatorSys=System.getProperty("file.separator");
    private final String dirUsingSys=System.getProperty("user.dir");
    private String dirEscolhido=dirUsingSys;
    private FileOutputStream out;
    
    public Download() throws RemoteException{
    }
    
    @Override
    public void iniciar(Computador origem, Computador destino, Arquivo arquivo) {
        try {
            //        o arquivo é instanciado o arquivo de origem com seu caminho
                    file=new File(arquivo.getFile().getAbsolutePath());
                    //cria um arquivo de mesmo nome no diretorio corrente se o usuario não modificar o diretorio
                    copy=new File(getDirEscolhido()+separatorSys+arquivo.getFile().getName());
                    try {
                        out=new FileOutputStream(copy);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ExecutorService pool=Executors.newFixedThreadPool(10);
                    do{
                        pool.submit(new DownloadThread(arquivo, destino, this));
                    }while(file.length()!=-1);
                    pool.shutdown();
                    pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FileOutputStream getOut() {
        return out;
    }

    public String getDirEscolhido() {
        return dirEscolhido;
    }

    public void setDirEscolhido(String dirEscolhido) {
        this.dirEscolhido = dirEscolhido;
    }

    @Override
    public void listar(String host,List<String> arquivos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
