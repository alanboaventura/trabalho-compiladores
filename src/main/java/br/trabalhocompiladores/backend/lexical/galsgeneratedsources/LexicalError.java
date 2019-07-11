package br.trabalhocompiladores.backend.lexical.galsgeneratedsources;

public class LexicalError extends AnalysisError {

    public LexicalError(String msg, int position) {
        super(msg, position);
    }

    private LexicalError(String msg) {
        super(msg);
    }
}
