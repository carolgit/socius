/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.app;

/**
 *
 * @author Ana
 */
public class EnvironmentTests {
    public static void main(String[] args) {
        //http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        System.out.println("Sistema Operacional:"+System.getProperty("os.name"));
        System.out.println("Arquitetura:"+System.getProperty("os.arch"));
        System.out.println("User name:"+System.getProperty("user.name"));
        System.out.println("Versao:"+System.getProperty("os.version"));
        System.out.println("tipo de separador"+System.getProperty("file.separator"));
        System.out.println("arquivo em que esta trabalhando"+System.getProperty("user.dir"));
        System.out.println("diretorio home"+System.getProperty("user.home"));
    }
            
}
