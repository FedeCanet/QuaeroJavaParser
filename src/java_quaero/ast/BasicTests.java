package java_quaero.ast;

import java.util.*;

import junit.framework.TestCase;
import java_quaero.parser.Parser;

public class BasicTests extends TestCase {

	public ArrayList makeResult(Integer... values) {
		ArrayList list1 = new ArrayList<>();
		list1.add(new ArrayList<>(Arrays.asList(values)));
		return list1;
	}
	
	public void test1() throws Exception {
		//assertEquals(((QuaeroExpression) Parser.parseString("Persona(b:1)")), "Persona");
		String Query = "List(Company(id: 1, name: \"Google\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")), Company(Person(id: 1,name: \"Lawrence J. Ellison\"),Person(id: 2, name: \"Bob Miner\"),Person(id: 3, name: \"Ed Oates\"), id: 2, name: \"Oracle\"))";
		String Query2 = "List(CCCC(id: 1, name: \"Yahoo\",Person(id: 1, name: \"Larry Page\"),Person(id: 2,name: \" Serguéi Brin\")))";
		QuaeroExpression exp = (QuaeroExpression) Parser.parseString("$"+Query2+"/ ~ [C]*");	
		System.out.println("????");
		System.out.println(exp.eval());
	}
	
}
