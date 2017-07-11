package java_quaero.ast;

import java.util.ArrayList;

public class QuaeroTagFilter extends QuaeroOperation {
	private String tag;

	public QuaeroTagFilter(QuaeroExpression e1, String tag) {
		super(e1);
		this.tag = tag;
	}
	@Override
	public ArrayList<QuaeroObject> eval(){
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroObject> e1Objs = e1.eval();
		for (QuaeroObject qo:e1Objs){
			if(qo.getTag().equals(tag)){
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
