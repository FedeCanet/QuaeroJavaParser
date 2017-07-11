package java_quaero.ast;

import java.util.ArrayList;

public class QuaeroConcatenation extends QuaeroOperation{
	private QuaeroExpression e2;
	
	public QuaeroConcatenation(QuaeroExpression e1, QuaeroExpression e2) {
		super(e1);
		this.e2 = e2;
	}

	@Override
	public ArrayList<QuaeroObject> eval() {
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroObject> e1Objs = e1.eval();
		ArrayList<QuaeroObject> e2Objs = e2.eval();
		result.addAll(e2Objs);
		result.addAll(e1Objs);
		return result;
	}

	@Override
	public String toString() {
		return this.eval().toString();
	}
	

}
