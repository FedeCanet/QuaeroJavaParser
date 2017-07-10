package java_quaero.ast;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuaeroExpression {
	private ArrayList<QuaeroObject> qObjs;
	private ArrayList<QuaeroAttribute> qAtts;
	public QuaeroExpression() {
		qObjs = new ArrayList<QuaeroObject>();
		qAtts = new ArrayList<QuaeroAttribute>();
	}
	public void onlyElements(){//No considerar qAttributes porque no hay elements dentro de qAttributes
		ArrayList<QuaeroObject> qoAux = new ArrayList<QuaeroObject>();//Hay que hacer los elementos de e o los elementos de los elementos de e?
		for (QuaeroObject qo:qObjs){ //Por ej, (Company(Persona(...)),Company(Persona(...)) deberia devolver las company o las personas?	
			if(!qo.getObjectList().isEmpty()){	
				qoAux.addAll(qo.getObjectList());
			}
		}
		qObjs = qoAux;
	}
	public void filterByTag(String tag){//Mismo que lo anterior
		ArrayList<QuaeroObject> qoAux = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroAttribute> qaAux = new ArrayList<QuaeroAttribute>();
		for (QuaeroObject qo:qObjs){
			if(qo.getTag().equals(tag)){
				qoAux.add(qo);
			}
		}
		qObjs = qoAux;
		for (QuaeroAttribute qa:qAtts){
			if(!qa.getTag().equals(tag)){
				qaAux.add(qa);
			}
		}
		qAtts = qaAux;
	}
	public void filterByRegex(String regex){
		Pattern p = Pattern.compile(regex);
		ArrayList<QuaeroObject> qoAux = new ArrayList<QuaeroObject>();
		ArrayList<QuaeroAttribute> qaAux = new ArrayList<QuaeroAttribute>();
		for(QuaeroObject qo: qObjs){
			Matcher m = p.matcher(qo.getTag());
			if(m.find()){
				qoAux.add(qo);
			}
		}
		for(QuaeroAttribute qa: qAtts){
			Matcher m = p.matcher(qa.getTag());
			if(m.find()){
				qaAux.add(qa);
			}
		}
		qObjs = qoAux;
		qAtts = qaAux;
	}
	public void onlyAttributes(){
		ArrayList<QuaeroAttribute> qaAux = new ArrayList<QuaeroAttribute>();
		for(QuaeroObject qo: qObjs){
			Map<String,Value> map = qo.getAttributes();
			for (String key: map.keySet()){
				qaAux.add(new QuaeroAttribute(key, map.get(key)));
			}
		}
		qAtts = qaAux;
		qObjs = new ArrayList<QuaeroObject>();
		
	}	
	public void intersection(QuaeroExpression e){
		qObjs.retainAll(e.getqObjs());
		qAtts.retainAll(e.getqAtts());
	}
	public void union(QuaeroExpression e){
		qObjs.removeAll(e.getqObjs());
		qAtts.removeAll(e.getqAtts());
		qObjs.addAll(e.getqObjs());
		qAtts.addAll(e.getqAtts());
		
	}
	public void concatenation(QuaeroExpression e){
		qObjs.addAll(e.getqObjs());
		qAtts.addAll(e.getqAtts());
	}
	public void difference(QuaeroExpression e){
		qObjs.removeAll(e.getqObjs());
		qAtts.removeAll(e.getqAtts());
		
	}
	public ArrayList<QuaeroObject> getqObjs() {
		return qObjs;
	}
	public void setqObjs(ArrayList<QuaeroObject> qObjs) {
		this.qObjs = qObjs;
	}
	public ArrayList<QuaeroAttribute> getqAtts() {
		return qAtts;
	}
	public void setqAtts(ArrayList<QuaeroAttribute> qAtts) {
		this.qAtts = qAtts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qAtts == null) ? 0 : qAtts.hashCode());
		result = prime * result + ((qObjs == null) ? 0 : qObjs.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuaeroExpression other = (QuaeroExpression) obj;
		if (qAtts == null) {
			if (other.qAtts != null)
				return false;
		} else if (!qAtts.equals(other.qAtts))
			return false;
		if (qObjs == null) {
			if (other.qObjs != null)
				return false;
		} else if (!qObjs.equals(other.qObjs))
			return false;
		return true;
	}
	
}
