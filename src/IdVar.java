
public class IdVar extends Ident {
	private int offset;
	public IdVar(String name, ValueType valueType, int offset){
		super(name, valueType);
		this.offset = offset;
	}
	public boolean isConst(){
		return false;
	}
}
