 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.factory.arquivo;

import java.io.File;
import socius.adapter.Arquivo;
import socius.adapter.ArquivoLinux;
import socius.util.ConfigSistema;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class ArquivoLinuxFactory extends ArquivoFactory {
    
    private static ArquivoFactory instance;

    private ArquivoLinuxFactory() {
    }

    public static ArquivoFactory getInstance() {
        if(instance == null)
            instance = new ArquivoLinuxFactory();
        
        return instance;
    }

    @Override
    public Arquivo getArquivo() {
        String path = System.getProperty("user.dir") + File.pathSeparator + 
                ConfigSistema.getProperty("cliente.pasta_publica");
        
        return new ArquivoLinux(path);
    }

    @Override
    public Arquivo getArquivo(String path) {
        return new ArquivoLinux(path);
    }
    
}
