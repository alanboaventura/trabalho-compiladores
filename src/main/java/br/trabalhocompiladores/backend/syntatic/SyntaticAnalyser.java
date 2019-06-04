package br.trabalhocompiladores.backend.syntatic;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.LexicalError;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Lexico;
import br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.SemanticError;
import br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.Semantico;
import br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.Sintatico;
import br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.SyntaticError;

/**
 * Classe referente as funções de analisador sintático do compilador.
 */
public class SyntaticAnalyser {

    public static void analyse(String text) throws SyntaticError, LexicalError, SemanticError {
        final Sintatico sintatico = new Sintatico();
        final Semantico semantico = new Semantico();

        try {
            sintatico.parse(new Lexico(text), semantico);
        } catch (SyntaticError | LexicalError | SemanticError e) {
            if (e.getMessage() != null) {
                throw new SyntaticError(e.getMessage());
            } else {
                throw e;
            }
        }
    }
}
