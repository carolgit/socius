/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.app;

import java.rmi.RemoteException;
import socius.dispositivos.Computador;
import socius.excecoes.FalhaNaConexaoComServidorException;
import socius.excecoes.SistemaOperacionalNaoSuportadoException;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class ClientBoot {
    public static void main(String[] args) throws RemoteException, 
            SistemaOperacionalNaoSuportadoException,
            FalhaNaConexaoComServidorException {
        
        // Instancia computador
        Computador computador = new Computador();
        
        // Tenta realizar a conexão com servidor
        computador.conectar();
        
        // TODO: 
        // InterfaceGrafica interface = new InterfaceGrafica(computador);
        // interface.inicializar();
        // interface.exibir();
        
    }
}
