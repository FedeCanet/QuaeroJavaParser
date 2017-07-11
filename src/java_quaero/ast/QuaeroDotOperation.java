package java_quaero.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class QuaeroDotOperation extends QuaeroOperation {

	public QuaeroDotOperation(QuaeroExpression e1) {
		super(e1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<QuaeroObject> eval() {
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroObject> qObjs = e1.eval();
		for(QuaeroObject qo: qObjs){
			HashMap<String,QuaeroValue> mapa = qo.getAttributes();
			ArrayList<String> keySet = new ArrayList<String>();
			keySet.addAll(mapa.keySet());
			Collections.reverse(keySet);
			for(String key: keySet){
				result.add(new QuaeroAttribute(key, mapa.get(key)));
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return this.eval().toString();
	}

}
