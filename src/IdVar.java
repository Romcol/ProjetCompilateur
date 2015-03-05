
public class IdVar extends Ident {
	private int offset;
	public IdVar(int type, String name, int valueType, int offset){
		super(type, name, valueType);
		this.offset = offset;
	}
}
