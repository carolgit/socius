/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.util;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class SistemaOperacional {
    
    public static String sistema = System.getProperty("os.name").toLowerCase();
    
    public static boolean isWindows() {
        return sistema.indexOf("win") >= 0;
    }
    
    public static boolean isLinux() {
        return sistema.indexOf("nux") >= 0;
    }
    
    public static boolean isMacintosh() {
        return sistema.indexOf("mac") >= 0;
    }
    
    
}
