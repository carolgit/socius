/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.excecoes;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class FalhaNaConexaoComServidorException extends Throwable 
    implements ExcecaoSistema {

    public FalhaNaConexaoComServidorException() {
        super("O sistema falhou ao conectar com o servidor.");
    }


    @Override
    public void exibeMensagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
