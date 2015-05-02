import java.util.List;

public class IdFunct implements Constants {
	
	public String name;
	public ValueType returnType;
	public List<IdVar> params;
	
	public IdFunct(String name, ValueType returnType, List<IdVar> params) {
		this.name = name;
		this.returnType = returnType;
		this.params = params;
	}
	
	public List<IdVar> getParams()
	{
		return this.params;
	}
	
}