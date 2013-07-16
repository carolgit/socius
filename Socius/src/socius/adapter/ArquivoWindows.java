/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class ArquivoWindows implements Arquivo{
    private File file;
    private FileInputStream inputStream;

    public ArquivoWindows(String path) {
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
       
       try {
           inputStream = new FileInputStream(file);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(ArquivoWindows.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           try {
               inputStream.close();
           } catch (IOException ex) {
               Logger.getLogger(ArquivoWindows.class.getName()).log(Level.SEVERE, null, ex);
           }
       }  return inputStream;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void setStream(FileInputStream inputStream) {
        this.inputStream=inputStream;
    }

}
