/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.factory.arquivo;

import java.io.File;
import socius.adapter.Arquivo;
import socius.adapter.ArquivoWindows;
import socius.util.ConfigSistema;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class ArquivoWindowsFactory extends ArquivoFactory {

    private static ArquivoFactory instance;

    private ArquivoWindowsFactory() {
    }

    public static ArquivoFactory getInstance() {
        if(instance == null)
            instance = new ArquivoWindowsFactory();
        
        return instance;
    }
    
    @Override
    public Arquivo getArquivo() {
        String path = System.getProperty("user.home") + File.separator + 
                ConfigSistema.getProperty("cliente.pasta_publica");
        
        return new ArquivoWindows(path);
    }

    @Override
    public Arquivo getArquivo(String path) {
        return new ArquivoWindows(path);
    }
    
}
