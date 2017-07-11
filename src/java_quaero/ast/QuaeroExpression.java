package java_quaero.ast;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class QuaeroExpression {
	public abstract ArrayList<QuaeroObject> eval();

	@Override
	public String toString() {return "";}
	
}
