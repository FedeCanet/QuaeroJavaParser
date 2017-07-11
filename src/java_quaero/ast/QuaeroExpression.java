package java_quaero.ast;

import java.util.ArrayList;


abstract public class QuaeroExpression {
	public abstract ArrayList<QuaeroObject> eval();

	@Override
	public String toString() {return "";}
	
}
