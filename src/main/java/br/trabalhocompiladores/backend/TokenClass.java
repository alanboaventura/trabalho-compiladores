package br.trabalhocompiladores.backend;

import java.util.Arrays;
import java.util.List;

public enum TokenClass {

    IDENTIFICATOR("identificador"),

    INTEGER_CONSTANT("constante inteira"),

    DECIMAL_CONSTANT("constante real"),

    STRING_CONSTANT("constante string"),

    CHARACTER_CONSTANT("constante caracter"),

    LINE_COMMENT("comentario linha"),

    BLOCK_COMMENT("comentario bloco"),

    RESERVED_WORD("palavra reservada"),

    SPECIAL_SIMBOL("simbolo especial");

    private String className;

    public String getClassName() {
        return className;
    }

    TokenClass(String className) {
        this.className = className;
    }

    public static List<TokenClass> getCommentTokenClasses(){
        return Arrays.asList(LINE_COMMENT, BLOCK_COMMENT);
    }
}
