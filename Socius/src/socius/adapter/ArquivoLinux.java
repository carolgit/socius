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
    
    private File file;
    
    public ArquivoLinux(String path) {
        file = new File(path);

        if(!file.isFile())
            file.mkdirs();
    }
    
    @Override
    public File getFile() {
        return file;
    }

    @Override
    public InputStream getStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void setStream(FileInputStream inputStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
