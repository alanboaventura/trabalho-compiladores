package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.AnalysisError;

public class SemanticError extends AnalysisError {

    public SemanticError(String msg, int position) {
        super(msg, position);
    }

    private SemanticError(String msg) {
        super(msg);
    }
}
