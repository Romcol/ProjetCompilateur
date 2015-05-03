import java.util.ArrayList;
import java.util.List;

public class Fonction implements Constants {
	
	private String name;
	private ValueType returnType;
	private List<IdVar> params = new ArrayList<IdVar>();
	private ValueType currentParamType;
	
	public void init() {
		this.name = null;
		this.returnType = null;
		this.params.clear();
		
		Yaka.tabIdent.initLocaux();
	}
	
	public void setReturnType(ValueType rtnType) {
		if(rtnType != null) 
		{
			if(this.returnType == null)
			{
				this.returnType = rtnType;
			}
		}
		else
			Yaka.yvm.ecrireErreur("Type de retour incorrecte ("+rtnType+")");
	}
	
	public void setName(String name) {
		this.name = name;
		Yaka.yvm.label(name);
	}
	
	public void setCurrentParamType(ValueType type){
		this.currentParamType = type;
	}
	
	public void newParam(String ident) {
		IdVar newident = new IdVar(ident, currentParamType);
		Yaka.tabIdent.rangeParam(ident, newident);
		this.params.add(newident);
	}
	
	public void noMoreParams(){
		int nbParam = Yaka.tabIdent.getNbParam();
		for (IdVar ident : params) {
			 int idRank = ident.getValue();
			 ident.setValue(4+(nbParam-idRank)*2);
		}
	}
	
	public ValueType stringToValueType(String type) {
		if(type.equals("ENTIER")) 
			return ValueType.ENTIER;
		else if(type.equals("BOOLEEN"))
			return ValueType.BOOLEEN;
		
		return null;
	}
	
	public void addFunct(){
		Yaka.tabIdent.rangeIdent(name, new IdFunct(name, returnType, params));
		Yaka.yvm.fermeBloc(Yaka.tabIdent.getNbParam()*2);
	}
	
	public void retourne(ValueType finalType ){
		if(finalType != returnType)
		{
			Yaka.yvm.ecrireErreur("Return type is "+finalType+" when expected "+returnType);
			return;
		}
		Yaka.yvm.ireturn(Yaka.tabIdent.getNbParam()*2+4);
	}
	
}
