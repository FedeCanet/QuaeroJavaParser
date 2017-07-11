package java_quaero.ast;

import java.util.ArrayList;

public class QuaeroSlashOperation extends QuaeroOperation {

	public QuaeroSlashOperation(QuaeroExpression e1) {
		super(e1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<QuaeroObject> eval(){
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroObject> qObjs = e1.eval();
		for (QuaeroObject qo: qObjs){
			for(QuaeroObject qo2: qo.getObjectList()){
				result.add(qo2);
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return this.eval().toString();
	}

}
