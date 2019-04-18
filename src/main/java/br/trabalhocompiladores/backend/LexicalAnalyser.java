package br.trabalhocompiladores.backend;

import br.trabalhocompiladores.backend.gals.LexicalError;
import br.trabalhocompiladores.backend.gals.Lexico;
import br.trabalhocompiladores.backend.gals.Token;

import java.util.HashMap;
import java.util.Map;

public class LexicalAnalyser {

    public static String analyse(String text) throws LexicalError {
        final Map<Integer, TokenClass> tokenClassesMap = initializeTokenClassesMap();
        int numLine = 0;

        StringBuilder result = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        result.append("linha").append("\t").append("classe").append("\t\t").append("lexema").append(lineSeparator);

        Lexico lexico = new Lexico();
        Token token;

        for (String line : text.split("\n|\n\r")) {
            numLine++;

            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            lexico.setInput(line);
            try {
                token = lexico.nextToken();
                while (token != null) {
                    final TokenClass tokenClass = tokenClassesMap.get(token.getId());
                    if (tokenClass == null || TokenClass.getCommentTokenClasses().contains(tokenClass)){
                        token = lexico.nextToken();
                        continue;
                    }

                    final String tokenClassName = tokenClass.getClassName();
                    final String lexeme = token.getLexeme();

                    final String lexemeSpace = tokenClass.equals(TokenClass.IDENTIFICATOR) || tokenClass.equals(TokenClass.DECIMAL_CONSTANT) ? "\t\t" : "\t";
                    result.append(numLine).append("\t").append(tokenClassName).append(lexemeSpace).append(lexeme).append(lineSeparator);
                    token = lexico.nextToken();
                }

            } catch (LexicalError e) {
                if (e.getMessage() != null) {
                    throw new LexicalError("Erro na linha " + numLine + " - " + e.getMessage());
                } else {
                    throw e;
                }
            }
        }

        if (result.length() > 30) return result.toString();
        return null;
    }

    private static Map<Integer, TokenClass> initializeTokenClassesMap() {
        Map<Integer, TokenClass> tokenClassesMap = new HashMap<>();

        tokenClassesMap.put(2, TokenClass.IDENTIFICATOR);
        tokenClassesMap.put(3, TokenClass.INTEGER_CONSTANT);
        tokenClassesMap.put(4, TokenClass.DECIMAL_CONSTANT);
        tokenClassesMap.put(5, TokenClass.STRING_CONSTANT);
        tokenClassesMap.put(6, TokenClass.CHARACTER_CONSTANT);
        tokenClassesMap.put(7, TokenClass.LINE_COMMENT);
        tokenClassesMap.put(8, TokenClass.BLOCK_COMMENT);
        tokenClassesMap.put(9, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(10, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(11, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(12, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(13, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(14, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(15, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(16, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(17, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(18, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(19, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(20, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(21, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(22, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(23, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(24, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(25, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(26, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(27, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(28, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(29, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(30, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(31, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(32, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(33, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(34, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(35, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(36, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(37, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(38, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(39, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(40, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(41, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(42, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(43, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(44, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(45, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(46, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(47, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(48, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(49, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(50, TokenClass.SPECIAL_SIMBOL);

        return tokenClassesMap;
    }
}