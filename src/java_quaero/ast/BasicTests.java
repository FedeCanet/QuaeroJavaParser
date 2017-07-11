package java_quaero.ast;

import java.util.*;

import java_cup.runtime.Symbol;
import junit.framework.TestCase;
import java_quaero.parser.Lexer;
import java_quaero.parser.Parser;
import java_quaero.parser.Tokens;

public class BasicTests extends TestCase {

	public ArrayList makeResult(Integer... values) {
		ArrayList list1 = new ArrayList<>();
		list1.add(new ArrayList<>(Arrays.asList(values)));
		return list1;
	}
	public static void showTokens(String input) throws Exception {
		Lexer lexer = Parser.makeLexer(input);
		Symbol token = lexer.next_token();
		while (token.sym != Tokens.EOF) {
			System.out.println(token.sym +": "+ token.value);
			token = lexer.next_token();
		}
		System.out.println("FIN");
	}
	
	public void test1() throws Exception {
		String Query = "List(Company(id: 1, name: \"Google\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")), Company(Person(id: 1,name: \"Lawrence J. Ellison\"),Person(id: 2, name: \"Bob Miner\"),Person(id: 3, name: \"Ed Oates\"), id: 2, name: \"Oracle\"))";
		String result = "[Company(id:1.0,name:\"Google\",Person(id:1.0,name:\"Larry Page\"),Person(id:2.0,name:\" Serguéi Brin\")), Company(id:2.0,name:\"Oracle\",Person(id:1.0,name:\"Lawrence J. Ellison\"),Person(id:2.0,name:\"Bob Miner\"),Person(id:3.0,name:\"Ed Oates\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		assertEquals(((QuaeroExpression) Parser.parseString("$"+"/")).toString(), result);
	}
	public void test2() throws Exception {
		String Query = "List(Company(id: 1, name: \"Google\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")), Company(Person(id: 1,name: \"Lawrence J. Ellison\"),Person(id: 2, name: \"Bob Miner\"),Person(id: 3, name: \"Ed Oates\"), id: 2, name: \"Oracle\"))";
		String result = "[Person(id:1.0,name:\"Larry Page\"), Person(id:2.0,name:\" Serguéi Brin\"), Person(id:1.0,name:\"Lawrence J. Ellison\"), Person(id:2.0,name:\"Bob Miner\"), Person(id:3.0,name:\"Ed Oates\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		assertEquals(((QuaeroExpression) Parser.parseString("$"+"//")).toString(), result);
	}
	public void test3() throws Exception {
		String Query = "List(Company(id: 1, name: \"Google\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")), Company(Person(id: 1,name: \"Lawrence J. Ellison\"),Person(id: 2, name: \"Bob Miner\"),Person(id: 3, name: \"Ed Oates\"), id: 2, name: \"Oracle\"))";
		String result = "[]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		assertEquals(((QuaeroExpression) Parser.parseString("$"+"///")).toString(), result);
	}
	public void test4() throws Exception {
		String Query = "List(Company(id: 1, name: \"Google\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")), Company(Person(id: 1,name: \"Lawrence J. Ellison\"),Person(id: 2, name: \"Bob Miner\"),Person(id: 3, name: \"Ed Oates\"), id: 2, name: \"Oracle\"))";
		String result = "[id:1.0, name:\"Larry Page\", id:2.0, name:\" Serguéi Brin\", id:1.0, name:\"Lawrence J. Ellison\", id:2.0, name:\"Bob Miner\", id:3.0, name:\"Ed Oates\"]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		assertEquals(((QuaeroExpression) Parser.parseString("$"+"//.")).toString(), result);
	}
	public void test5() throws Exception {
		String Query = "Person(id:2,persona:true)";
		String result = "[Person(id:2.0,persona:true)]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$");
		assertEquals(ex.toString(), result);
	}
	public void test6() throws Exception {
		String Query = "Person(id:2,persona:true)";
		String result = "[id:2.0, persona:true]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+".");
		assertEquals(ex.toString(), result);
	}
	public void test7() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Person(id:2.0,name:\"Roberto\"), Person(id:3.0,name:\"Gervacio\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/ Person");
		assertEquals(ex.toString(), result);
	}
	public void test8() throws Exception {
		String Query = "Person(id:2,invalido:true)";
		String result = "[id:2.0, invalido:true]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("($)"+".");
		assertEquals(ex.toString(), result);
	}
	public void test9() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[name:\"Roberto\", name:\"Gervacio\"]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/. name");
		assertEquals(ex.toString(), result);
	}
	public void test10() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[id:2.0, id:3.0]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/. id");
		assertEquals(ex.toString(), result);
	}
	public void test11() throws Exception {
		String Query = "Company(Person('id.':2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[id.:2.0]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/. 'id.'");
		assertEquals(ex.toString(), result);
	}
	public void test12() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Person(id:2.0,name:\"Roberto\"), Person(id:3.0,name:\"Gervacio\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/ ~Perso[nabcy]");
		assertEquals(ex.toString(), result);
	}
	public void test13() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[id:2.0, name:\"Roberto\", id:3.0, name:\"Gervacio\"]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/. ~'[a-zA-Z]*'");
		assertEquals(ex.toString(), result);
	}
	public void test14() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[name:\"Roberto\", name:\"Gervacio\"]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"/. ~name");
		assertEquals(ex.toString(), result);
	}
	public void test16Unic	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"∩"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test16	() throws Exception {
		String xd  = "\u2229";
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"&"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test17	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"|"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test17Unic	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result ="[Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"∪"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test18	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\")), Company(Person(id:2.0,name:\"Roberto\"),Person(id:3.0,name:\"Gervacio\"))]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"+"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test20	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$"+"-"+"$");
		assertEquals(ex.toString(), result);
	}
	public void test21	() throws Exception {
		String Query = "Company(Person(id:2,name:\"Roberto\"), Person(id:3,name:\"Gervacio\"))";
		String result = "[Person(id:2.0,name:\"Roberto\"), Person(id:3.0,name:\"Gervacio\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$/"+"-"+"($ / - $/)");
		assertEquals(ex.toString(), result);
	}
	public void test21unic	() throws Exception {
		String Query = "Company(Person(id:⊤,name:\"Roberto\"), Person(id:⊥,name:\"Gervacio\"))";
		String result = "[Person(id:true,name:\"Roberto\"), Person(id:false,name:\"Gervacio\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$/"+"-"+"($ / - $/)");
		assertEquals(ex.toString(), result);
	}
	public void testtoInfinity() throws Exception {
		String Query = "Company(Person(id:∞,name:\"Roberto\"), Person(id:-∞,name:\"Gervacio\"))";
		String result = "[Person(id:1.7976931348623157E308,name:\"Roberto\"), Person(id:4.9E-324,name:\"Gervacio\")]";
		AccessRoot acc = AccessRoot.getObject();
		QuaeroObject qo = (QuaeroObject) Parser.parseString(Query);
		acc.setRoot(new QuaeroRoot(qo));
		QuaeroExpression ex = (QuaeroExpression) Parser.parseString("$/"+"-"+"($ / - $/)");
		assertEquals(ex.toString(), result);
	}
}
