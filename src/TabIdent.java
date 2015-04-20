import java.util.HashMap;
import java.util.Map;

public class TabIdent {
	
	private int nbVar;
	
	private HashMap<String,Ident> table_globaux;
	private HashMap<String,Ident> table_locaux;
	
	public TabIdent() {
		this.nbVar = 0;
		this.table_locaux = new HashMap<String, Ident>();
		this.table_globaux = new HashMap<String, Ident>();
	}
	public Ident chercheIdent(String clef){
		return table_locaux.get(clef);
	}
	public boolean existeIdent(String clef){
		return table_locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, IdConst id){
		table_locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, IdVar id){
		id.setValue((nbVar+1)*(-2));
		table_locaux.put(clef, id);
		this.nbVar++;

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

	public int getNbVar() {
		return nbVar;
	}

}
