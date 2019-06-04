package br.trabalhocompiladores.backend.lexical;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.LexicalError;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Lexico;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe referente as funções de analisador léxico do compilador.
 */
public class LexicalAnalyser {

    /**
     * {@link StringBuilder} que irá armazenar o resultado da analise léxica.
     */
    private static StringBuilder result;

    /**
     * Classe gerada do GALS que irá realizar a analise léxica do texto.
     */
    private static Lexico lexico = new Lexico();

    /**
     * Map que irá armazenar as classes de tokens disponíveis.
     */
    private static Map<Integer, TokenClass> tokenClassesMap = initializeTokenClassesMap();

    /**
     * Realiza a analise léxica de um determinado texto.
     *
     * @param text Texto que deve ser analisado lexicamente.
     * @return Uma {@link String} contendo o resultado da analise léxica do texto, ou seja, a lista de tokens identificados.
     * @throws LexicalError Caso não seja possível realizar a analise em função de algum erro lexíco, onde quem chamar este
     * método deve realizar a tratativa para exibir para o usuário o motivo do erro (conteúdo/message da exceção).
     */
    public static String analyse(String text) throws LexicalError {
        result = new StringBuilder();

        final String lineSeparator = System.getProperty("line.separator");
        result.append("linha").append("\t").append("classe").append("\t\t").append("lexema").append(lineSeparator).append(lineSeparator);

        /*
         * Variaveis auxiliares refentes ao comentário em bloco.
         */
        int blockCommentStartLine = 0;
        boolean blockCommentIsOpened = false;
        StringBuilder blockComment = new StringBuilder();

        int numLine = 0; // Variavel auxíliar para descobrirmos qual linha do texto encontramos determinado valor.

        for (String line : text.split("\n|\n\r")) { // Realiza a leitura do texto linha por linha.
            numLine++;

            if (line == null || line.trim().isEmpty() || line.startsWith("?")) {
                continue;
            }

            /*
             * Variações de analise referentes ao comentário em bloco.
             */
            if (line.contains("#|") && line.contains("|#")) {
                blockComment.append(line);
                blockCommentStartLine = numLine;
                analyseText(blockComment.toString(), blockCommentStartLine);
                blockComment = new StringBuilder();
                continue;
            } else if (line.contains("#|")) {
                blockComment.append(line);
                blockCommentStartLine = numLine;
                blockCommentIsOpened = true;
                continue;
            } else if (line.contains("|#")) {
                blockComment.append("\n").append(line);
                analyseText(blockComment.toString(), blockCommentStartLine);
                blockCommentIsOpened = false;
                blockComment = new StringBuilder();
                continue;
            } else if (blockCommentIsOpened) {
                blockComment.append("\n").append(line);
                continue;
            }

            // Realiza a analise léxica da linha.
            analyseText(line, numLine);
        }

        if (!blockComment.toString().isEmpty()) {
            return String.format("ERRO! O comentário de bloco iniciado na linha %s não foi fechado até o final do arquivo.", blockCommentStartLine);
        }

        if (result.length() > 30) return result.toString(); // Caso o resultado tenha menos de 30 caracteres quer dizer que não foi encontrado nenhum token, foi apenas preenchido o cabeçalho.
        return null;
    }

    private static void analyseText(String text, int numLine) throws LexicalError {
        Token token;
        lexico.setInput(text);
        try {
            token = lexico.nextToken();
            while (token != null) {
                final TokenClass tokenClass = tokenClassesMap.get(token.getId());
                if (tokenClass == null || TokenClass.getCommentTokenClasses().contains(tokenClass)) { // Comentários são ignorados.
                    token = lexico.nextToken();
                    continue;
                }

                final String tokenClassName = tokenClass.getClassName();
                final String lexeme = token.getLexeme();

                final String lexemeSpace = tokenClass.equals(TokenClass.IDENTIFICATOR) || tokenClass.equals(TokenClass.DECIMAL_CONSTANT) ? "\t\t" : "\t";
                result.append(numLine).append("\t").append(tokenClassName).append(lexemeSpace).append(lexeme).append(System.getProperty("line.separator"));

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

    private static Map<Integer, TokenClass> initializeTokenClassesMap() {
        Map<Integer, TokenClass> tokenClassesMap = new HashMap<>();

        tokenClassesMap.put(2, TokenClass.IDENTIFICATOR);
        tokenClassesMap.put(3, TokenClass.INTEGER_CONSTANT);
        tokenClassesMap.put(4, TokenClass.DECIMAL_CONSTANT);
        tokenClassesMap.put(5, TokenClass.STRING_CONSTANT);
        tokenClassesMap.put(6, TokenClass.CHARACTER_CONSTANT);
        tokenClassesMap.put(7, TokenClass.RESERVED_WORD);
        tokenClassesMap.put(8, TokenClass.RESERVED_WORD);
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
        tokenClassesMap.put(29, TokenClass.SPECIAL_SIMBOL);
        tokenClassesMap.put(30, TokenClass.SPECIAL_SIMBOL);
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

        return tokenClassesMap;
    }
}