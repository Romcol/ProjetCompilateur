import java.util.List;

public class IdFunct implements Constants {
	
	public String name;
	public ValueType returnType;
	public List<ValueType> typeParams;
	
	public IdFunct(String name, ValueType returnType, List<ValueType> typeParams) {
		this.name = name;
		this.returnType = returnType;
		this.typeParams = typeParams;
	}
	
}