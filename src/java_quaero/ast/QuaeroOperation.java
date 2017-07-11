package java_quaero.ast;

import java.util.ArrayList;

abstract public class QuaeroOperation extends QuaeroExpression {
	protected QuaeroExpression e1;
	
	public QuaeroOperation(QuaeroExpression e1) {
		super();
		this.e1 = e1;
	}

	@Override
	public abstract ArrayList<QuaeroObject> eval();
	
}
