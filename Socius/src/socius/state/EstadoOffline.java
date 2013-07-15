/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.state;

import socius.dispositivos.Computador;

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
    public void conectar() {
    }

    @Override
    public void desconectar() {
    }
    
    
}
