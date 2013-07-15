/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.excecoes;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public class SistemaOperacionalNaoSuportadoException extends Throwable
    implements ExcecaoSistema {

    public SistemaOperacionalNaoSuportadoException() {
        super("Sistema operacional residente não suportado pelo sistema.");
    }

    @Override
    public void exibeMensagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
