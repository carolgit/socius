/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.stream;

import java.io.Serializable;

/**
 *Controle de tempo
 * @author Ana
 */
public class Tarefa implements Serializable{
    public Object start(){
        return new Long(System.currentTimeMillis());
    }
}
