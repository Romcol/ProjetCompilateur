
public class IdVar extends Ident {
	public IdVar(String name, ValueType valueType){
		super(name, valueType);
	}

	public void load() {
		Yaka.yvm.iload(this.value);
	}
	
	public void store() {
		Yaka.yvm.istore(this.value);
	}
	
	public String toString() {
		return name;
	}

}
