package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Constants;
import br.trabalhocompiladores.backend.lexical.galsgeneratedsources.Token;

public class Semantico implements Constants {

	public static Stack<String> pilhaTipos = new Stack<>();
	public static Stack<String> pilhaRotulos = new Stack<>();
	public static ArrayList<String> listaId = new ArrayList<>();
	public static StringBuilder codigo = new StringBuilder();
	public static String tipoVar;
	public static HashMap<String, String> TS = new HashMap<String, String>();
	public static String id;
	public static String tipoId;
	public static String operadorRelacional;
	public static int labelId = 0;
	public static String label;

	public static void executeAction(int action, Token token) throws SemanticError {
		switch (action) {
		case 1:
			acao1e2e3(token); // Mesmo código para o 1 e 2, o que muda é o codigo
			codigo.append("add\n");
			break;
		case 2:
			acao1e2e3(token);
			codigo.append("sub\n");
			break;
		case 3:
			acao1e2e3(token);
			codigo.append("mul\n");
			break;
		case 4:
			acao04(token);
			break;
		case 5:
			acao5(token);
			break;
		case 6:
			acao6(token);
			break;
		case 7:
			acao07(token);
			break;
		case 8:
			acao08(token);
			break;
		case 9:
			acao09(token);
			break;
		case 10:
			acao10(token);
			break;
		case 11:
			acao11(token);
			break;
		case 12:
			acao12(token);
			break;
		case 13:
			acao13(token);
			break;
		case 14:
			acao14(token);
			break;
		case 15:
			acao15(token);
			break;
		case 16:
			acao16(token);
			break;
		case 17:
			acao17(token);
			break;
		case 18:
			acao18(token);
			break;
		case 19:
			acao19(token);
			break;
		case 20:
			acao20(token);
			break;
		case 21:
			acao21(token);
			break;
		case 30:
			acao30(token);
			break;
		case 31:
			acao31(token);
			break;
		case 32:
			acao32(token);
			break;
		case 33:
			acao33(token);
			break;
		case 34:
			acao34(token);
			break;
		case 35:
			acao35(token);
			break;
		case 36:
			acao36(token);
			break;
		case 37:
			acao37(token);
			break;
		case 38:
			acao38(token);
			break;
		case 39:
			acao39(token);
			break;
		case 40:
			acao40(token);
			break;
		case 41:
			acao41(token);
			break;
		case 42:
			acao42(token);
			break;
		default:
			break;
		}
		System.out.println("A��o #" + action + ", Token: " + token);
	}

	private static void acao42(Token token) {
		String rotulo1 = pilhaRotulos.pop();
		String rotulo2 = pilhaRotulos.pop();
		codigo.append("br " + rotulo2 + "\n");
		codigo.append(rotulo1 + ":" + "\n");
	}

	private static void acao41(Token token) {
		criaLabel();
		String tokenLexeme = token.getLexeme();

		if ("whileTrueDo".equals(tokenLexeme)) {
			codigo.append("brfalse " + label + "\n");
		} else if ("whileFalseDo".equals(tokenLexeme)) {
			codigo.append("brtrue " + tokenLexeme + "\n");
		}

		pilhaRotulos.push(label);
	}

	private static void acao40(Token token) {
		criaLabel();
		codigo.append("br " + label + "\n");
		codigo.append(pilhaRotulos.pop() + ":\n");
		pilhaRotulos.push(label);
	}

	private static void acao39(Token token) {
		codigo.append(pilhaRotulos.pop() + ":\n");
	}

	private static void acao38(Token token) {
		criaLabel();
		codigo.append("brfalse " + label + "\n");
		pilhaRotulos.push(label);
	}

	private static void acao37(Token token) {
		criaLabel();
		codigo.append(label + ":" + "\n");
		pilhaRotulos.push(label);
	}

	private static void acao36(Token token) throws SemanticError {
		id = listaId.get(0);

		if (!TS.containsKey(id)) {
			throw new SemanticError(id + " n�o declarado.", token.getPosition());
		}

		operadorRelacional = token.getLexeme();

		if ("+=".equals(operadorRelacional) || "-=".equals(operadorRelacional)) {
			codigo.append("ldloc " + id + "\n");
			codigo.append("conv.r8\n");
		}
	}

	private static void acao35(Token token) throws SemanticError {
		for (String id : listaId) {
			if (!TS.containsKey(id)) {
				throw new SemanticError(id + " n�o declarado", token.getPosition());
			}

			tipoId = TS.get(id);
			String classe = "";
			
			if ("int".equals(tipoId)) {
				classe = "Int64";
			} else if ("float".equals(tipoId)) {
				classe = "Double";
			} else if ("char".equals(tipoId)) {
				classe = "Char";
			} else if ("bool".equals(tipoId)) {
				classe = "Boolean";
			}

			codigo.append("call string [mscorlib]System.Console::ReadLine()\n");
			
			if(!"string".equals(tipoId)) {
				codigo.append("call " + tipoId + " [mscorlib]System." + classe + "::Parse(string)\n");				
			}
			
			codigo.append("stloc " + id + "\n");
		}
		listaId.clear();
	}

	private static void acao34(Token token) throws SemanticError {
		id = listaId.get(0);
		listaId.remove(0);

		if (!TS.containsKey(id)) {
			throw new SemanticError(id + " n�o declarado", token.getPosition());
		}

		tipoId = TS.get(id);

		if ("+=".equals(operadorRelacional)) {
			codigo.append("add\n");
		} else if ("-=".equals(operadorRelacional)) {
			codigo.append("sub\n");
		}

		if ("int64".equals(tipoId)) {
			codigo.append("conv.i8\n");
		}

		codigo.append("stloc " + id + "\n");
	}

	private static void acao33(Token token) throws SemanticError {
		id = token.getLexeme();
		if (!TS.containsKey(id)) {
			throw new SemanticError(id + " n�o declarado", token.getPosition());
		}

		tipoId = TS.get(id);
		pilhaTipos.push(tipoId);
		codigo.append("ldloc " + id + "\n");

		if ("int64".equals(tipoId)) {
			codigo.append("conv.r8\n");
		}
	}

	private static void acao32(Token token) {
		listaId.add(token.getLexeme());
	}

	private static void acao31(Token token) throws SemanticError {
		for (String id : listaId) {
			if (TS.containsKey(id)) {
				throw new SemanticError(id + " j� declarado", token.getPosition());
			} else {
				TS.put(id, tipoVar);
				codigo.append(".locals(" + tipoVar + " " + id + ")\n");
			}
		}
		listaId.clear();
	}

	private static void acao30(Token token) {
		if ("int".equals(token.getLexeme())) {
			tipoVar = "int64";
		} else if ("real".equals(token.getLexeme())) {
			tipoVar = "float64";
		} else if ("char".equals(token.getLexeme())) {
			tipoVar = "char";
		} else if ("bool".equals(token.getLexeme())) {
			tipoVar = "bool";
		} else if ("string".equals(token.getLexeme())) {
			tipoVar = "string";
		}
	}

	private static void acao21(Token token) {
		pilhaTipos.push("string");
		codigo.append("ldstr " + token.getLexeme() + "\n");
	}

	private static void acao20(Token token) {
		pilhaTipos.push("string");

		switch (token.getLexeme()) {
		case "\\s":
			codigo.append("ldstr " + "\" \"" + "\n");
			break;
		case "\\n":
			codigo.append("ldstr " + "\"\\n\"\n");
			break;
		case "\\t":
			codigo.append("ldstr " + "\"\\t\"\n");
			break;
		default:
			break;
		}
	}

	private static void acao19(Token token) throws SemanticError {
		String tipo19 = pilhaTipos.pop();

		if ("bool".equals(tipo19)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipo(s) incompat�vel(is) em express�o l�gica", token.getPosition());
		}

		codigo.append("ldc.i4.1\n");
		codigo.append("or\n");
	}

	private static void acao18(Token token) throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("bool".equals(tipo)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipo(s) incompat�vel(is) em express�o l�gica", token.getPosition());
		}

		codigo.append("ldc.i4.1\n");
		codigo.append("and\n");
	}

	private static void criaLabel() {
		labelId++;
		label = "label" + labelId;
	}

	private static void acao09(Token token) {
		operadorRelacional = token.getLexeme();
	}

	private static void acao11(Token token) {
		pilhaTipos.push("bool");
		codigo.append("ldc.i4.1\n");
	}

	private static void acao12(Token token) {
		pilhaTipos.push("bool");
		codigo.append("ldc.i4.0\n");
	}

	private static void acao13(Token token) throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("bool".equals(tipo)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o l�gica", token.getPosition());
		}

		codigo.append("ldc.i4.1\n");
		codigo.append("xor\n");
	}

	private static void acao04(Token token) throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if (tipo1.equals(tipo2)) {
			pilhaTipos.push(tipo1);
		} else {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o aritm�tica", token.getPosition());
		}

		codigo.append("div\n");
	}

	private static void acao07(Token token) throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("float64".equals(tipo) || "int64".equals(tipo)) {
			pilhaTipos.push(tipo);
		} else {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o arit�tica", token.getPosition());
		}
	}

	private static void acao08(Token token) throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("float64".equals(tipo) || "int64".equals(tipo)) {
			pilhaTipos.push(tipo);
		} else {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o aritm�tica", token.getPosition());
		}

		codigo.append("conv.r8\n");
		codigo.append("lcd.i8 -1\n");
		codigo.append("mul\n");
	}

	private static void acao10(Token token) throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if ("string".equals(tipo1) || "string".equals(tipo2)) {
			if (tipo1.equalsIgnoreCase(tipo2)) {
				pilhaTipos.push("bool");
			} else {
				throw new SemanticError("Tipos incompat�veis em express�o relacional.", token.getPosition());
			}
		}
		
		switch (operadorRelacional) {
		case ">":
			codigo.append("cgt\n");
			break;
		case "<":
			codigo.append("clt\n");
			break;
		case "==":
			codigo.append("ceq\n");
			break;
		case "!=":
			codigo.append("ceq\n");
			codigo.append("ldc.i4 0\n");
			codigo.append("ceq\n");
			break;
		case "<=":
			codigo.append("cgt\n");
			codigo.append("ldc.i4 0\n");
			codigo.append("ceq\n");
			break;
		case ">=":
			codigo.append("clt\n");
			codigo.append("ldc.i4 0\n");
			codigo.append("ceq\n");
			break;
		}

	}

	private static void acao6(Token token) {
		pilhaTipos.push("float64");
		codigo.append("ldc.r8 ").append(token.getLexeme() + "\n");
	}

	private static void acao14(Token token) {
		String tipo = pilhaTipos.pop();

		if ("int64".equals(tipo)) {
			codigo.append("conv.i8\n");
		}

		codigo.append("call void [mscorlib]System.Console::Write(" + tipo + ")\n");
	}

	private static void acao15(Token token) {
		codigo.append(".assembly extern mscorlib {}\n")
		.append(".assembly _codigo_objeto{}\n")
		.append(".module _codigo_objeto.exe\n")
		.append("\n")
		.append(".class public _UNICA{\n");
	}

	private static void acao16(Token token) {
		codigo.append(".method static public void _principal() {\n")
		.append(".entrypoint\n");
	}

	private static void acao17(Token token) {
		codigo.append("ret\n")
		.append("}\n")
		.append("}\n");
	}

	private static void acao1e2e3(Token token) throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if ("string".equals(tipo1) || "string".equals(tipo2) || "bool".equals(tipo1) || "bool".equals(tipo2)) {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o aritim�tica", token.getPosition());
		}

		if ("float64".equals(tipo1) || "float64".equals(tipo2)) {
			pilhaTipos.push("float64");
		} else {
			pilhaTipos.push("int64");
		}
	}

	private static void acao5(Token token) {
		pilhaTipos.push("int64");
		codigo.append("ldc.i8 ").append(token.getLexeme() + "\n");
		codigo.append("conv.r8\n");
	}
}
