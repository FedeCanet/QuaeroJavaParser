package java_quaero.ast;

import java.util.ArrayList;

public class QuaeroRoot extends QuaeroExpression{
	QuaeroObject qo;
	
	public QuaeroRoot(QuaeroObject qo) {
		super();
		this.qo = qo;
	}

	@Override
	public ArrayList<QuaeroObject> eval() {
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>(); 
		result.add(qo);
		return result;
	}

	@Override
	public String toString() {
		return this.eval().toString();
	}

}
