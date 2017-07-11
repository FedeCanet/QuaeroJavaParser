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
		return null;
	}

}
