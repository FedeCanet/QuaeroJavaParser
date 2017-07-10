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
	
}
