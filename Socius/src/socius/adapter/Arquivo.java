/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.rmi.Remote;

/**
 *
 * @author Ana
 */
public interface Arquivo extends Remote{
    public File getFile();
    public InputStream getStream();
    public void setFile(File file);
    public void setStream(FileInputStream inputStream);
}
