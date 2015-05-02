import java.util.ArrayList;
import java.util.List;

public class Fonction implements Constants {
	
	private String name;
	private ValueType returnType;
	private List<ValueType> typeParams = new ArrayList<ValueType>();
	
	public void init() {
		this.name = null;
		this.returnType = null;
		this.typeParams.clear();
		
		Yaka.tabIdent.initLocaux();
	}
	
	public void setReturnType(ValueType returnType) {
		if(returnType != null) 
			this.returnType = returnType;
		else
			Yaka.yvm.ecrireErreur("Type de retour incorrecte ("+returnType+")");
	}
	
	public void setName(String name) {
		this.name = name;
		Yaka.yvm.label(name);
	}
	
	public void newParam(String ident) {
		
		this.typeParams.add(this.returnType);
		Yaka.tabIdent.rangeParam(ident, new IdVar(ident, this.returnType));
	}
	
	public ValueType stringToValueType(String type) {
		if(type.equals("ENTIER")) 
			return ValueType.ENTIER;
		else if(type.equals("BOOLEEN"))
			return ValueType.BOOLEEN;
		
		return null;
	}
	
	public void addFunct(){
		Yaka.tabIdent.rangeIdent(name, new IdFunct(name, returnType, typeParams));
		Yaka.yvm.fermeBloc(Yaka.tabIdent.getNbParam()*2);
	}
	
	public void noMoreParam(){
		Yaka.yvm.ouvBloc(Yaka.tabIdent.getNbVar()*2);
	}
	
	public void retourne(){
		Yaka.yvm.ireturn(Yaka.tabIdent.getNbParam()*2+2);
	}
	
}
