package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.AnalysisError;

public class SyntaticError extends AnalysisError {

    public SyntaticError(String msg, int position) {
        super(msg, position);
    }

    private SyntaticError(String msg) {
        super(msg);
    }
}
