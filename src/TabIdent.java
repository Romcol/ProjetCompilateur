import java.util.HashMap;
import java.util.Map;

public class TabIdent {
	
	private int nbVar;
	private int nbParam;
	
	private HashMap<String,IdFunct> table_globaux;
	private HashMap<String,Ident> table_locaux;
	
	public TabIdent() {
		this.nbVar = 0;
		this.nbParam = 0;
		this.table_locaux = new HashMap<String, Ident>();
		this.table_globaux = new HashMap<String, IdFunct>();
	}
	public Ident chercheIdent(String clef){
		return table_locaux.get(clef);
	}
	
	public IdFunct chercheFonction(String clef)
	{
		return table_globaux.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return table_locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, IdConst id){
		if(table_locaux.containsKey(clef) || table_globaux.containsKey(clef))
		{
			Yaka.yvm.ecrireErreur("Error : Ident '"+clef+"' already exists.");
		}
		table_locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, IdVar id){
		if(table_locaux.containsKey(clef) || table_globaux.containsKey(clef))
		{
			Yaka.yvm.ecrireErreur("Error : Ident '"+clef+"' already exists.");
		}
		id.setValue((nbVar+1)*(-2));
		table_locaux.put(clef, id);
		this.nbVar++;
	}
	
	public int getNbParam()
	{
		return nbParam;
	}
	
	public int getNbVar()
	{
		return nbVar;
	}
	
	public void rangeParam(String clef, IdVar id) {
		this.nbParam++;
		id.setValue(nbParam);
		table_locaux.put(clef, id);
	}

	public void rangeIdent(String clef, IdFunct id) {
		if(table_locaux.containsKey(clef) || table_globaux.containsKey(clef))
		{
			Yaka.yvm.ecrireErreur("Error : Ident '"+clef+"' already exists.");
		}
		table_globaux.put(clef, id);
	}
	
	public void initLocaux() {
		this.table_locaux.clear();
		this.nbParam = 0;
		this.nbVar = 0;
	}
	
	
	public String toString() {
		
		String ret = "";
		
		for (Map.Entry<String, Ident> entry : table_locaux.entrySet())
		{
				ret += "(" + entry.getKey() + " : " + entry.getValue() + ")\n";
		}
		return ret;
	}
	
	public HashMap<String, Ident> gettable_locaux() {
		return table_locaux;
	}

}
