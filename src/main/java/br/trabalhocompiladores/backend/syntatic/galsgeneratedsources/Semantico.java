package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Constants;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Token;

public class Semantico implements Constants {

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);
    }
}
