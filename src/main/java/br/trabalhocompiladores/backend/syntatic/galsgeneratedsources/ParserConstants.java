package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

public interface ParserConstants {

	int START_SYMBOL = 49;

    int FIRST_NON_TERMINAL    = 49;
    int FIRST_SEMANTIC_ACTION = 90;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1,  6,  7, -1, -1,  5, -1, -1, -1,  4, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1,  9,  9, -1, -1,  9, -1, -1, -1,  9, -1, -1, -1, -1, -1,  9, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 12, 12, -1, -1, 12, -1, -1, -1, 12, -1, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 15, 15, -1, -1, 15, -1, -1, -1, 15, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, 18, 18, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 22, -1, -1, -1, -1, -1, -1, 22, 22, -1, -1, 22, -1, -1, -1, 22, -1, -1, -1, -1, 22, 22, -1, -1, -1, -1, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22 },
        { -1, 23, -1, -1, -1, -1, -1, -1, 24, 24, -1, -1, 24, -1, -1, -1, 24, -1, -1, -1, -1, 23, 24, -1, -1, -1, -1, 23, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 25, 25, -1, -1, 25, -1, -1, -1, 25, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, 26, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26 },
        { -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, 27, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27 },
        { -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33 },
        { -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 37, 38, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 42, 42, 42, 42, 42, -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, 42, -1, -1, -1, 42, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49 },
        { -1, 50, 50, 50, 50, 50, -1, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, 50, -1, -1, -1, 50, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, 50, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, -1, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, 53, -1, -1, -1, -1, -1, -1 },
        { -1, 54, 54, 54, 54, 54, -1, -1, -1, -1, -1, 56, -1, -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, 55, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, 54, 54, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 58, 58, 58, 58, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, -1, -1, -1, 58, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, 60, 59, 59, 59, 59, 59, 59, -1, -1, -1, -1, 60, 60, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, 62, 63, 64, 65, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 67, 67, 67, 67, 67, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 67, -1, -1, -1, -1, -1, -1, -1, 67, 67, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 70, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, -1, -1, -1, -1, -1, -1, -1, -1, 70, 70, 70, 70, 70, 70, 70, 68, 69, -1, -1, 70, 70, -1, -1, -1, -1, -1, -1 },
        { -1, 71, 71, 71, 71, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 71, -1, -1, -1, -1, -1, -1, -1, 71, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 74, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 74, -1, -1, -1, -1, -1, -1, -1, -1, 74, 74, 74, 74, 74, 74, 74, 74, 74, 72, 73, 74, 74, -1, -1, -1, -1, -1, -1 },
        { -1, 75, 76, 77, 78, 79, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 80, -1, -1, -1, -1, -1, -1, -1, 81, 82, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 84, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 84, -1, -1, -1, -1, -1, -1, -1, 83, 84, 84, 84, 84, 84, 84, 84, 84, 84, 84, 84, 84, 84, -1, -1, -1, -1, -1, -1 },
        { -1, 86, 86, 86, 86, 86, -1, -1, -1, -1, -1, 86, -1, -1, -1, -1, -1, -1, -1, 86, -1, -1, -1, 86, -1, -1, -1, -1, 86, 85, -1, -1, -1, -1, -1, -1, 86, 86, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 105,  18,  50,  59, 106,   8,  61,  11, 107 },
        {   0 },
        {  51,  50 },
        {  14,  19,  53,   2,  29,  54,  30 },
        {  17 },
        {  13 },
        {   9 },
        {  10 },
        {  23 },
        {  52 },
        {  25 },
        {   0 },
        {  56,  55 },
        {  43,  56,  55 },
        {   0 },
        {  52,  44,  57 },
        {   2, 122,  58 },
        {  41,  57 },
        {   0 },
        {   0 },
        {  60,  59 },
        {  19,   2,   8,  61,  11 },
        {  62,  64 },
        {   0 },
        {  63,  62 },
        {  52, 120,  44,  57, 121,  42 },
        {  66,  42,  65 },
        {  64 },
        {   0 },
        {  67 },
        {  69 },
        {  70 },
        { 127,  29,  75,  30,  88 },
        {  74 },
        {  16, 128,  64,  73,  11, 129 },
        {  89 },
        {   2, 122,  68, 126,  75, 124 },
        {  46 },
        {  47 },
        {  45 },
        {  22,  29,  57, 125,  30 },
        {  28,  29,  71,  30 },
        {  75, 104,  72 },
        {  41,  71 },
        {   0 },
        {   0 },
        { 130,  15,  64 },
        {  27, 131,  64,  11, 132 },
        { 131,  26,  64,  11, 132 },
        {  48,  75 },
        {  77,  76 },
        {   7,  77, 108,  76 },
        {  21,  77, 109,  76 },
        {   0 },
        {  78 },
        {  24, 101 },
        {  12, 102 },
        {  20,  77, 103 },
        {  81,  79 },
        {  80,  99,  81, 100 },
        {   0 },
        {  31 },
        {  32 },
        {  33 },
        {  34 },
        {  35 },
        {  36 },
        {  83,  82 },
        {  37,  83,  91,  82 },
        {  38,  83,  92,  82 },
        {   0 },
        {  85,  84 },
        {  39,  85,  93,  84 },
        {  40,  85,  94,  84 },
        {   0 },
        {   2, 123,  86 },
        {   3,  95 },
        {   4,  96 },
        {   5, 111 },
        {   6, 110 },
        {  29,  75,  30 },
        {  37,  85,  97 },
        {  38,  85,  98 },
        {  29,  87 },
        {   0 },
        {  30 },
        {  71,  30 }
    };


    String[] EXPECTED_PARSER_ERROR = {
            "",
            "esperado fim de arquivo",
            "esperado identificador",
            "esperado constante int",
            "esperado constante float",
            "esperado constante string",
            "esperado constante char",
            "esperado and",
            "esperado begin",
            "esperado bool",
            "esperado char",
            "esperado end",
            "esperado false",
            "esperado float",
            "esperado forward",
            "esperado ifFalseDo",
            "esperado ifTrueDo",
            "esperado int",
            "esperado main",
            "esperado module",
            "esperado not",
            "esperado or",
            "esperado read",
            "esperado string",
            "esperado true",
            "esperado void",
            "esperado whileFalseDo",
            "esperado whileTrueDo",
            "esperado write",
            "esperado \"(\"",
            "esperado \")\"",
            "esperado \"==\"",
            "esperado \"!=\"",
            "esperado \"<\"",
            "esperado \"<=\"",
            "esperado \">\"",
            "esperado \">=\"",
            "esperado \"+\"",
            "esperado \"-\"",
            "esperado \"*\"",
            "esperado \"/\"",
            "esperado \",\"",
            "esperado \".\"",
            "esperado \";\"",
            "esperado \":\"",
            "esperado \"=\"",
            "esperado \"+=\"",
            "esperado \"-=\"",
            "esperado \"^\"",
            "esperado main",		                        //"<programa> inválido",
            "esperado begin forward module",	            //"<declarações> inválido",
            "esperado forward",	                            //"<declaração> inválido",
            "esperado tipo",		                        // "<tipo> inválido",
            "esperado tipo",		                        // "<tipoMódulo> inválido",
            "esperado tipo )",	                            //"<parâmetrosFormais> inválido",
            "esperado ) ;",		                            //"<parâmetrosFormaisMais> inválido",
            "esperado tipo",		                        //"<parâmetro> inválido",
            "esperado id ",		                            //"<listaDeIdentificadores> inválido",
            "esperado ) ",		                            //"<listaDeIdentificadores1> inválido",
            "esperado begin module ",		                //"<módulos> inválido",
            "esperado module",		                        //"<módulo> inválido",
            "esperado id tipo read write ( ^",		        //"<corpo> inválido",
            "esperado id tipo read write ( ^",		        //"<declaraçõesDeVariáveis> inválido",
            "esperado tipo",		                        //"<variável> inválido",
            "esperado id read write ( ^",	                //"<listaDeComandos> inválido",
            "esperado id and ifFalseDo read write ( ^", 	//"<listaDeComandos1> inválido",
            "esperado id comando read write ( ^", 	        //"<comando> inválido",
            "esperado id", 	                                //"<comandoDeAtribuição> inválido",
            "esperado = += -=", 	                        //"<atribuir> inválido",
            "esperado read", 	                            //"<entradaDeDados> inválido",
            "esperado write", 	                            //"<saídaDeDados> inválido",
            "esperado expressão",                           //"<listaDeExpressões> inválido",
            "esperado ) ,", 	                            //"<listaDeExpressões1> inválido",
            "esperado and ifFalseDo", 	                    //"<senao> inválido",
            "esperado ^", 	                                //"<retornoDeMódulo> inválido",
            "esperado express�o", 	                        //"<expressão> inválido",
            "esperado express�o", 	                        //"<expressão1> inválido",
            "esperado express�o", 	                        //"<elemento> inválido",
            "esperado express�o", 	                        // "<relacional> inválido",
            "esperado express�o", 	                        //"<relacional1> inválido",
            "esperado express�o", 	                        //"<operador_relacional> inválido",
            "esperado express�o", 	                        //"<aritmética> inválido",
            "esperado express�o", 	                        //"<aritmética1> inválido",
            "esperado express�o", 	                        //"<termo> inválido",
            "esperado express�o", 	                        //"<termo1> inválido",
            "esperado express�o", 	                        //"<fator> inválido",
            "esperado express�o", 	                        //"<fator1> inválido",
            "esperado express�o", 	                        //"<fator11> inválido",
            "esperado ifTrueDo whileFalseDo whileTrueDo", 	//"<comando1> inválido",
            "esperado whileFalseDo whileTrueDo", 	        //"<expressãoComandoDeRepetição> inválido"
    };

	String[] FOUND_PARSER_ERROR = {
			"",
			"encontrado fim de arquivo",
			"encontrado identificador",
			"encontrado constante int",
			"encontrado constante float",
			"encontrado constante string",
			"encontrado constante char",
			"encontrado and",
			"encontrado begin",
			"encontrado bool",
			"encontrado char",
			"encontrado end",
			"encontrado false",
			"encontrado float",
			"encontrado forward",
			"encontrado ifFalseDo",
			"encontrado ifTrueDo",
			"encontrado int",
			"encontrado main",
			"encontrado module",
			"encontrado not",
			"encontrado or",
			"encontrado read",
			"encontrado string",
			"encontrado true",
			"encontrado void",
			"encontrado whileFalseDo",
			"encontrado whileTrueDo",
			"encontrado write",
			"encontrado \"(\"",
			"encontrado \")\"",
			"encontrado \"==\"",
			"encontrado \"!=\"",
			"encontrado \"<\"",
			"encontrado \"<=\"",
			"encontrado \">\"",
			"encontrado \">=\"",
			"encontrado \"+\"",
			"encontrado \"-\"",
			"encontrado \"*\"",
			"encontrado \"/\"",
			"encontrado \",\"",
			"encontrado \".\"",
			"encontrado \";\"",
			"encontrado \":\"",
			"encontrado \"=\"",
			"encontrado \"+=\"",
			"encontrado \"-=\"",
			"encontrado \"^\"",
			"encontrado main",		                        //"<programa> inválido",
			"encontrado begin forward module",	            //"<declarações> inválido",
			"encontrado forward",	                            //"<declaração> inválido",
			"encontrado tipo",		                        // "<tipo> inválido",
			"encontrado tipo",		                        // "<tipoMódulo> inválido",
			"encontrado tipo )",	                            //"<parâmetrosFormais> inválido",
			"encontrado ) ;",		                            //"<parâmetrosFormaisMais> inválido",
			"encontrado tipo",		                        //"<parâmetro> inválido",
			"encontrado id ",		                            //"<listaDeIdentificadores> inválido",
			"encontrado ) ",		                            //"<listaDeIdentificadores1> inválido",
			"encontrado begin module ",		                //"<módulos> inválido",
			"encontrado module",		                        //"<módulo> inválido",
			"encontrado id tipo read write ( ^",		        //"<corpo> inválido",
			"encontrado id tipo read write ( ^",		        //"<declaraçõesDeVariáveis> inválido",
			"encontrado tipo",		                        //"<variável> inválido",
			"encontrado id read write ( ^",	                //"<listaDeComandos> inválido",
			"encontrado id and ifFalseDo read write ( ^", 	//"<listaDeComandos1> inválido",
			"encontrado id comando read write ( ^", 	        //"<comando> inválido",
			"encontrado id", 	                                //"<comandoDeAtribuição> inválido",
			"encontrado = += -=", 	                        //"<atribuir> inválido",
			"encontrado read", 	                            //"<entradaDeDados> inválido",
			"encontrado write", 	                            //"<saídaDeDados> inválido",
			"encontrado expressão",                           //"<listaDeExpressões> inválido",
			"encontrado ) ,", 	                            //"<listaDeExpressões1> inválido",
			"encontrado and ifFalseDo", 	                    //"<senao> inválido",
			"encontrado ^", 	                                //"<retornoDeMódulo> inválido",
			"encontrado express�o", 	                        //"<expressão> inválido",
			"encontrado express�o", 	                        //"<expressão1> inválido",
			"encontrado express�o", 	                        //"<elemento> inválido",
			"encontrado express�o", 	                        // "<relacional> inválido",
			"encontrado express�o", 	                        //"<relacional1> inválido",
			"encontrado express�o", 	                        //"<operador_relacional> inválido",
			"encontrado express�o", 	                        //"<aritmética> inválido",
			"encontrado express�o", 	                        //"<aritmética1> inválido",
			"encontrado express�o", 	                        //"<termo> inválido",
			"encontrado express�o", 	                        //"<termo1> inválido",
			"encontrado express�o", 	                        //"<fator> inválido",
			"encontrado express�o", 	                        //"<fator1> inválido",
			"encontrado express�o", 	                        //"<fator11> inválido",
			"encontrado ifTrueDo whileFalseDo whileTrueDo", 	//"<comando1> inválido",
			"encontrado whileFalseDo whileTrueDo", 	        //"<expressãoComandoDeRepetição> inválido"
	};
}
