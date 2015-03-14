import java.util.Map;
import java.util.Stack;


public class YVM {

	protected Stack<IdVar> pile;
	
	
	public YVM() {
		this.pile = new Stack<IdVar>();
	}

	public void addVar(IdVar var) {
		this.pile.push(var);
	}


	/*
	 * Initialise la pile avec les valeurs tabIdent. Executée après la déclaration des variables.
	 */
	public void initStack() {
		for (Map.Entry<String, Ident> entry : Yaka.tabIdent.getTable().entrySet())
		{				
			if(entry.getValue() instanceof IdVar){
				pile.push((IdVar) entry.getValue());
			}
		}
	}
	
	public void ecrireEntete() {
		String out = "entete\n";
		out += "ouvrePrinc " + pile.size() * 2 + "\n";
		ecrire(out);
	}
	
	public void ecrireEnt() {
		
	}
	
	public void ecrireChaine(String chaine) {
		ecrire("ecrireChaine " + chaine + "\n");
	}
	
	public void ecrireBool() {
		
	}
	
	public void lireEnt(String identLu) {
		
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			System.out.println("Erreur instruction lireEnt (ident "+ identLu +" non trouvé.)");
		}
		else {
			if(ident instanceof IdVar) {
				ecrire("lireEnt " + getOffset((IdVar)ident) + "\n");
			}
			else {
				ecrire("no sé qué faire avec lireEnt cte.\n");
			}
		}
	}
	
	public void aLaLigne() {
		ecrire("aLaLigne\n");
	}
	
	/*
	 * @return offset d'une variable
	 */
	protected int getOffset(IdVar var) {
		return(indexToOffset(pile.indexOf(var)));
	}
	
	/*
	 * calcule un offset à partir d'un index. Ex :
	 * 0 -> -2
	 * 1 -> -4
	 * 2 -> -6 ...
	 */
	protected int indexToOffset(int index) {
		return -2 * (index + 1);
	}
	
	public String toString() {
		
		return Integer.toString(pile.size());

	}
	
	private void ecrire(String str) {
		System.out.print(str);
	}
}
