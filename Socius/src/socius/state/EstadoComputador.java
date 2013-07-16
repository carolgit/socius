/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.state;

import socius.excecoes.FalhaNaConexaoComServidorException;

/**
 *
 * @author Ana
 */
public interface EstadoComputador{
    public void conectar() throws FalhaNaConexaoComServidorException;
    public void desconectar();
}
