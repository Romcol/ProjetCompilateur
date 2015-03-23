public class Declaration implements Constants{
	private ValueType currentType;
	private String currentIdent;
		
	public void defConstEntier(int entier){
		IdConst idconst = new IdConst(currentIdent, ValueType.ENTIER, entier);
		Yaka.tabIdent.rangeIdent(currentIdent, idconst);
	}
	public void defConstIdent(String ident1){
		if(Yaka.tabIdent.existeIdent(ident1))
		{
			IdConst ident = (IdConst) Yaka.tabIdent.chercheIdent(ident1);
			IdConst idconst = new IdConst(currentIdent, ident.getValueType(), ident.getValue());
			Yaka.tabIdent.rangeIdent(currentIdent, idconst);
		}
		else{
			Yaka.yvm.ecrireErreur("Ident "+ident1+" not found.");
		}
	}
	public void defConstBool(int value){
		IdConst idconst = new IdConst(currentIdent, ValueType.BOOLEEN, value);
		Yaka.tabIdent.rangeIdent(currentIdent, idconst);
	}
	public ValueType getCurrentType() {
		return currentType;
	}
	public void setCurrentType(ValueType currentType) {
		this.currentType = currentType;
	}
	public String getCurrentIdent() {
		return currentIdent;
	}
	public void setCurrentIdent(String currentIdent) {
		this.currentIdent = currentIdent;
	}
	public void defVar(String identName){
		IdVar newIdent = new IdVar(identName, currentType);
		Yaka.tabIdent.rangeIdent(identName, newIdent);
	}
}
