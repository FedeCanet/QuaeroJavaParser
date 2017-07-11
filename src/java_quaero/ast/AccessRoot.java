package java_quaero.ast;

public class AccessRoot {
	QuaeroRoot root;
    private static boolean hasObject = false;
    private static AccessRoot singletonObject = null;

    public static AccessRoot getObject() {
        if (hasObject) {
            return singletonObject;
        } else {
            hasObject = true;
            singletonObject = new AccessRoot();
            return singletonObject;
        }
    }

    private AccessRoot() {
        root = null;
    }
    public void setRoot(QuaeroRoot r){
    	root = r;
    }
    public QuaeroRoot getRoot(){
    	return root;
    }
}
