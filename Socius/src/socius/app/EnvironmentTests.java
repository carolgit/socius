/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.app;

import java.rmi.RemoteException;
import java.util.List;
import javafx.application.Application;
import socius.adapter.Arquivo;
import socius.dispositivos.Computador;
import socius.excecoes.SistemaOperacionalNaoSuportadoException;
import socius.factory.arquivo.ArquivoFactory;

/**
 *
 * @author Ana
 */
public class EnvironmentTests {
    public static void main(String[] args) 
            throws SistemaOperacionalNaoSuportadoException, RemoteException {
        
//        //http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
//        System.out.println("Sistema Operacional:"+System.getProperty("os.name"));
//        System.out.println("Arquitetura:"+System.getProperty("os.arch"));
//        System.out.println("User name:"+System.getProperty("user.name"));
//        System.out.println("Versao:"+System.getProperty("os.version"));
//        System.out.println("tipo de separador"+System.getProperty("file.separator"));
//        System.out.println("arquivo em que esta trabalhando"+System.getProperty("user.dir"));
//        System.out.println("diretorio home"+System.getProperty("user.home"));
        
        System.out.println("Teste do ArquivoFactory ---");
        
        Computador c = new Computador();
        List<Arquivo> arqsPublicos = c.getArquivos();
        
        for(Arquivo aps : arqsPublicos)
            System.out.println(aps.getFile().getAbsolutePath());
        
        System.exit(0);
    }
            
}
