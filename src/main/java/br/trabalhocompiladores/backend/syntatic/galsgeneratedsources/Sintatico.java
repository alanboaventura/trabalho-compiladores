package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Constants;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.LexicalError;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Lexico;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Token;

import java.util.Stack;

import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.FIRST_NON_TERMINAL;
import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.FIRST_SEMANTIC_ACTION;
import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.PARSER_ERROR;
import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.PARSER_TABLE;
import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.PRODUCTIONS;
import static br.trabalhocompiladores.backend.syntatic.galsgeneratedsources.ParserConstants.START_SYMBOL;

public class Sintatico implements Constants {

    private Stack stack = new Stack();
    private Token currentToken;
    private Token previousToken;
    private Lexico scanner;
    private Semantico semanticAnalyser;

    private static final boolean isTerminal(int x) {
        return x < FIRST_NON_TERMINAL;
    }

    private static final boolean isNonTerminal(int x) {
        return x >= FIRST_NON_TERMINAL && x < FIRST_SEMANTIC_ACTION;
    }

    private static final boolean isSemanticAction(int x) {
        return x >= FIRST_SEMANTIC_ACTION;
    }

    private boolean step() throws LexicalError, SyntaticError, SemanticError {
        if (currentToken == null) {
            int pos = 0;
            if (previousToken != null)
                pos = previousToken.getPosition() + previousToken.getLexeme().length();

            currentToken = new Token(DOLLAR, "$", pos);
        }

        int x = ((Integer) stack.pop()).intValue();
        int a = currentToken.getId();

        if (x == EPSILON) {
            return false;
        } else if (isTerminal(x)) {
            if (x == a) {
                if (stack.empty())
                    return true;
                else {
                    previousToken = currentToken;
                    currentToken = scanner.nextToken();
                    return false;
                }
            } else {
                throw new SyntaticError(PARSER_ERROR[x], currentToken.getPosition());
            }
        } else if (isNonTerminal(x)) {
            if (pushProduction(x, a))
                return false;
            else
                throw new SyntaticError(PARSER_ERROR[x], currentToken.getPosition());
        } else // isSemanticAction(x)
        {
            semanticAnalyser.executeAction(x - FIRST_SEMANTIC_ACTION, previousToken);
            return false;
        }
    }

    private boolean pushProduction(int topStack, int tokenInput) {
        int p = PARSER_TABLE[topStack - FIRST_NON_TERMINAL][tokenInput - 1];
        if (p >= 0) {
            int[] production = PRODUCTIONS[p];
            //empilha a produção em ordem reversa
            for (int i = production.length - 1; i >= 0; i--) {
                stack.push(new Integer(production[i]));
            }
            return true;
        } else
            return false;
    }

    public void parse(Lexico scanner, Semantico semanticAnalyser) throws LexicalError, SyntaticError, SemanticError {
        this.scanner = scanner;
        this.semanticAnalyser = semanticAnalyser;

        stack.clear();
        stack.push(new Integer(DOLLAR));
        stack.push(new Integer(START_SYMBOL));

        currentToken = scanner.nextToken();

        while (!step()) ;
    }
}
