package br.trabalhocompiladores.backend.syntatic.galsgeneratedsources;

import java.io.Console;
import java.util.ArrayList;
import java.util.Dictionary;
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
			acao1e2e3(); // Mesmo código para o 1 e 2, o que muda é o codigo
			codigo.append("add\n");
			break;
		case 2:
			acao1e2e3();
			codigo.append("sub\n");
			break;
		case 3:
			acao1e2e3();
			codigo.append("mul\n");
			break;
		case 4:
			acao04();
			break;
		case 5:
			acao5(token);
			break;
		case 6:
			acao6(token);
			break;
		case 7:
			acao07();
			break;
		case 8:
			acao08();
			break;
		case 9:
			acao09(token);
			break;
		case 10:
			acao10();
			break;
		case 11:
			acao11();
			break;
		case 12:
			acao12();
			break;
		case 13:
			acao13();
			break;
		case 14:
			acao14();
			break;
		case 15:
			acao15();
			break;
		case 16:
			acao16();
			break;
		case 17:
			acao17();
			break;
		case 18:
			acao18();
			break;
		case 19:
			acao19();
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
			acao31();
			break;
		case 32:
			acao32(token);
			break;
		case 33:
			acao33(token);
			break;
		case 34:
			acao34();
			break;
		case 35:
			acao35();
			break;
		case 36:
			acao36(token);
			break;
		case 37:
			acao37();
			break;
		case 38:
			acao38();
			break;
		case 39:
			acao39();
			break;
		case 40:
			acao40();
			break;
		case 41:
			acao41(token);
			break;
		case 42:
			acao42();
			break;
		default:
			break;
		}
//		System.out.println(codigo.toString());
	}

	private static void acao42() {
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

	private static void acao40() {
		criaLabel();
		codigo.append("br " + label + "\n");
		codigo.append(pilhaRotulos.pop() + ":\n");
		pilhaRotulos.push(label);
	}

	private static void acao39() {
		codigo.append(pilhaRotulos.pop() + ":\n");
	}

	private static void acao38() {
		criaLabel();
		codigo.append("brfalse " + label + "\n");
		pilhaRotulos.push(label);
	}

	private static void acao37() {
		criaLabel();
		codigo.append(label + ":" + "\n");
		pilhaRotulos.push(label);
	}

	private static void acao36(Token token) throws SemanticError {
		id = listaId.get(0);

		if (!TS.containsKey(id)) {
			throw new SemanticError(id + " não declarado.");
		}

		operadorRelacional = token.getLexeme();

		if ("+=".equals(operadorRelacional) || "-=".equals(operadorRelacional)) {
			codigo.append("ldloc " + id + "\n");
			codigo.append("conv.r8\n");
		}
	}

	private static void acao35() throws SemanticError {
		for (String id : listaId) {
			if (!TS.containsKey(id)) {
				throw new SemanticError(id + " não declarado");
			}

			tipoId = TS.get(id);
			String classe = "";

			if ("int64".equals(tipoId)) {
				classe = "Int64";
			} else if ("float64".equals(tipoId)) {
				classe = "Double";
			}

			codigo.append("call string [mscorlib]System.Console::ReadLine()\n");
			codigo.append("call " + tipoId + " [mscorlib]System." + classe + "::Parse(string)\n");
			codigo.append("stloc " + id + "\n");
		}
		listaId.clear();
	}

	private static void acao34() throws SemanticError {
		id = listaId.get(0);
		listaId.remove(0);

		if (!TS.containsKey(id)) {
			throw new SemanticError(id + " não declarado");
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
			throw new SemanticError(id + " n�o declarado");
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

	private static void acao31() throws SemanticError {
		for (String id : listaId) {
			if (TS.containsKey(id)) {
				throw new SemanticError(id + " j� declarado");
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

	private static void acao19() throws SemanticError {
		String tipo19 = pilhaTipos.pop();

		if ("bool".equals(tipo19)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica");
		}

		codigo.append("ldc.i4.1\n");
		codigo.append("or\n");
	}

	private static void acao18() throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("bool".equals(tipo)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica");
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

	private static void acao11() {
		pilhaTipos.push("bool");
		codigo.append("ldc.i4.1\n");
	}

	private static void acao12() {
		pilhaTipos.push("bool");
		codigo.append("ldc.i4.0\n");
	}

	private static void acao13() throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("bool".equals(tipo)) {
			pilhaTipos.push("bool");
		} else {
			throw new SemanticError("Tipos(s) incompatível(is) em expressão lógica");
		}

		codigo.append("ldc.i4.1\n");
		codigo.append("not\n");
	}

	private static void acao04() throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if (tipo1.equals(tipo2)) {
			pilhaTipos.push(tipo1);
		} else {
			throw new SemanticError("Tipos(s) incompatível(is) em expressão aritmética");
		}

		codigo.append("div\n");
	}

	private static void acao07() throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("float64".equals(tipo) || "int64".equals(tipo)) {
			pilhaTipos.push(tipo);
		} else {
			throw new SemanticError("Tipos(s) incompatível(is) em expressão aritmética");
		}
	}

	private static void acao08() throws SemanticError {
		String tipo = pilhaTipos.pop();

		if ("float64".equals(tipo) || "int64".equals(tipo)) {
			pilhaTipos.push(tipo);
		} else {
			throw new SemanticError("Tipos(s) incompatível(is) em expressão aritmética");
		}

		codigo.append("lcd.i8 -1\n");
		codigo.append("conv.r8\n");
		codigo.append("mul\n");
	}

	private static void acao10() throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if ("string".equals(tipo1) || "string".equals(tipo2)) {
			if (tipo1.equalsIgnoreCase(tipo2)) {
				pilhaTipos.pop();
			} else {
				throw new SemanticError("Tipos incompatíveis em expressão relacional.");
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

	private static void acao14() {
		String tipo = pilhaTipos.pop();

		if ("int64".equals(tipo)) {
			codigo.append("conv.i8\n");
		}

		codigo.append("call void [mscorlib]System.Console::Write(" + tipo + ")\n");
	}

	private static void acao15() {
		codigo.append(".assembly extern mscorlib {}\n")
		.append(".assembly _codigo_objeto{}\n")
		.append(".module _codigo_objeto.exe\n")
		.append("\n")
		.append(".class public _UNICA{\n");
	}

	private static void acao16() {
		codigo.append(".method static public void _principal() {\n")
		.append(".entrypoint\n");
	}

	private static void acao17() {
		codigo.append("ret ").append("}").append("}\n");
	}

	private static void acao1e2e3() throws SemanticError {
		String tipo1 = pilhaTipos.pop();
		String tipo2 = pilhaTipos.pop();

		if ("string".equals(tipo1) || "string".equals(tipo2) || "bool".equals(tipo1) || "bool".equals(tipo2)) {
			throw new SemanticError("Tipos(s) incompat�vel(is) em express�o aritim�tica");
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
