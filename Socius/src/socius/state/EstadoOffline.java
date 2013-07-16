/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.state;

import socius.dispositivos.Computador;
import socius.excecoes.FalhaNaConexaoComServidorException;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class EstadoOffline implements EstadoComputador {
    
    private Computador computador;

    public EstadoOffline(Computador computador) {
        this.computador = computador;
    }
    
    @Override
    public void conectar() throws FalhaNaConexaoComServidorException {
        throw new FalhaNaConexaoComServidorException();
    }

    @Override
    public void desconectar() {
    }
    
    
}
