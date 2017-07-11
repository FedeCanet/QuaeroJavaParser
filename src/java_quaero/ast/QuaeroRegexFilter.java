package java_quaero.ast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuaeroRegexFilter extends QuaeroOperation {
	String regex;
	
	public QuaeroRegexFilter(QuaeroExpression e1, String regex) {
		super(e1);
		if(regex.contains("'")){
			this.regex = regex.replace("'", "");
		}else{
			this.regex = regex;
		}
	}

	@Override
	public ArrayList<QuaeroObject> eval() {
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroObject> e1Objs = e1.eval();
		for(QuaeroObject qo: e1Objs){
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(qo.getTag());
			if(m.matches()){
				result.add(qo);
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return this.eval().toString();
	}

}
