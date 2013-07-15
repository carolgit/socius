/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.dispositivos;

import socius.adapter.Arquivo;
import socius.adapter.ArquivoLinux;
import socius.adapter.ArquivoWindows;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import socius.adapter.ArquivoUnix;
import socius.excecoes.SistemaOperacionalNaoSuportadoException;
import socius.state.EstadoComputador;
import socius.state.EstadoOffline;
import socius.util.ConfigSistema;
import socius.util.SistemaOperacional;

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

        // Caminho para a pasta pública

        // TODO: Criar um factory ou Builder (o que for mais adequado) que
        // retorne automaticamente uma instancia da interface Arquivo
        // com base no sistema operacional passando o caminho absoluto como 
        // dado de entrada. Se vazio, assume o diretório de compartilhamento
        // como padrão.
        dir = System.getProperty("user.dir") + File.pathSeparator + ConfigSistema.getProperty("cliente.pasta_publica");

        // Detecta sistema operacional e instancia o adapter adequado
        if (SistemaOperacional.isWindows()) {
            arquivos = new ArquivoWindows(dir);
        } else if (SistemaOperacional.isLinux()) {
            arquivos = new ArquivoLinux(dir);
        } else if (SistemaOperacional.isMacintosh()) {
            arquivos = new ArquivoUnix(dir);
        } else {
            throw new SistemaOperacionalNaoSuportadoException();
        }
        
        arquivos.getFile().mkdirs();
    }    
    
    public List<Arquivo> getArquivos() throws RemoteException {
        File[] arquivosPasta = arquivos.getFile().listFiles();
        List<Arquivo> lista = new ArrayList<>();
        
        for (int i = 0; i < arquivosPasta.length; i++) {
            // TODO: Criar um factory ou Builder (o que for mais adequado) que
            // retorne automaticamente uma instancia da interface Arquivo
            // com base no sistema operacional passando o caminho absoluto como 
            // dado de entrada. Se vazio, assume o diretório de compartilhamento
            // como padrão.
            lista.add(new ArquivoWindows(arquivosPasta[i].getAbsolutePath()));
        }
        
        return lista;
        
    }
    
    @Override
    public void conectar() {
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
