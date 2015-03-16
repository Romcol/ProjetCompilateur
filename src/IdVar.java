
public class IdVar extends Ident {
	public IdVar(String name, ValueType valueType){
		super(name, valueType);
	}
	public boolean isConst(){
		return false;
	}
	
	
	public String toString() {
		return name;
	}
}
