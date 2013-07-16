/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import socius.adapter.Arquivo;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import socius.excecoes.FalhaNaConexaoComServidorException;
import socius.excecoes.SistemaOperacionalNaoSuportadoException;
import socius.factory.arquivo.ArquivoFactory;
import socius.state.EstadoComputador;
import socius.state.EstadoOffline;

/**
 *
 * @author Ana
 */
public class Computador extends UnicastRemoteObject implements EstadoComputador {

    private String descricao;
    private EstadoComputador estado;
    private String dir;
    private Arquivo arquivos;

    public Computador() throws RemoteException, SistemaOperacionalNaoSuportadoException {
        // Estado inicial 
        estado = new EstadoOffline(this);

        arquivos = ArquivoFactory.getFactory().getArquivo();
    }

    public List<Arquivo> getArquivos() 
            throws RemoteException, SistemaOperacionalNaoSuportadoException {
        File[] arquivosPasta = arquivos.getFile().listFiles();
        List<Arquivo> lista = new ArrayList<>();

        for (int i = 0; i < arquivosPasta.length; i++) {
            String absPath = arquivosPasta[i].getAbsolutePath();
            Arquivo arq = ArquivoFactory.getFactory().getArquivo(absPath);
            lista.add(arq);
        }
        
        return lista;

    }

    @Override
    public void conectar() throws FalhaNaConexaoComServidorException {
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
}
