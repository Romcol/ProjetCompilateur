import java.util.HashMap;
import java.util.Map;

public class TabIdent {
	
	private int nbVar;
	

	private HashMap<String,Ident> table;
	
	public TabIdent() {
		this.nbVar = 0;
		this.table = new HashMap<String, Ident>();
	}
	public Ident chercheIdent(String clef){
		return table.get(clef);
	}
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, IdConst id){
		table.put(clef, id);
	}
	
	public void rangeIdent(String clef, IdVar id){
		id.setValue((nbVar+1)*(-2));
		table.put(clef, id);
		this.nbVar++;

	}
	
	public String toString() {
		
		String ret = "";
		
		for (Map.Entry<String, Ident> entry : table.entrySet())
		{
				ret += "(" + entry.getKey() + " : " + entry.getValue() + ")\n";
		}
		return ret;
	}
	
	public HashMap<String, Ident> getTable() {
		return table;
	}

	public int getNbVar() {
		return nbVar;
	}

}
