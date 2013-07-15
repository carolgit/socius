/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Ana
 */
public class ArquivoLinux implements Arquivo{
    
    public ArquivoLinux(String path) {
    }
    
    @Override
    public File getFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InputStream getStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFile(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStream(FileInputStream inputStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
