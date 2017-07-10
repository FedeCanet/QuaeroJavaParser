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
		assertEquals(((QuaeroExpression) Parser.parseString("$Company(b:1) & $Cosa(ed:3)")).getqObjs().get(1).getTag(), "Person"); //Como deberia ser la consulta con un solo $ o con un $ por QuaeroObject
	}
	
}
