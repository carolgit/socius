/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 * 
 * Classe utilitária para leitura das configurações do sistema
 * armazenadas em um arquivo de propiedades
 * 
 */
public abstract class ConfigSistema {
    
    private static Properties properties;
    
    static {
        try {
            properties = new Properties();
            InputStream stream = ConfigSistema.class
                    .getResourceAsStream("/socius.properties");
            properties.load(stream);
            stream.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigSistema.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static String getProperty(String identificacao) {
        return properties.getProperty(identificacao);
    }
    
    public static String getProperty(String identificacao, String valorPadrao) {
        return properties.getProperty(identificacao, valorPadrao);
    }
    
   
}
