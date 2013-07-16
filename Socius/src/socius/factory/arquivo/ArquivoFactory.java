/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socius.factory.arquivo;

import socius.adapter.Arquivo;
import socius.excecoes.SistemaOperacionalNaoSuportadoException;
import socius.util.SistemaOperacional;

/**
 *
 * @author Lucas Dillmann <lucas [at] dillmann.com.br>
 */
public abstract class ArquivoFactory {

    private static ArquivoFactory factory;

    public abstract Arquivo getArquivo();

    public abstract Arquivo getArquivo(String path);

    public static ArquivoFactory getFactory()
            throws SistemaOperacionalNaoSuportadoException {

        if (SistemaOperacional.isWindows()) {
            return ArquivoWindowsFactory.getInstance();
        } else if (SistemaOperacional.isLinux()) {
            return ArquivoLinuxFactory.getInstance();
        } else if (SistemaOperacional.isMacintosh()) {
            return ArquivoUnixFactory.getInstance();
        } else {
            throw new SistemaOperacionalNaoSuportadoException();
        }

    }
}
