import java.util.Map;
import java.util.Stack;


public class YVM implements Constants{

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
		out += "ouvrePrinc " + pile.size() * 2;
		ecrire(out);
	}
	public void ecrireOp(Operation op) {
		ecrire(this.getOperationString(op));
	}
	
	public void iconst(int value){
		ecrire("iconst "+value);
	}
	public void iload(int offset){
		ecrire("iload "+offset);
	}
	public void istore(int offset){
		ecrire("istore "+offset);
	}
	public String getOperationString(Constants.Operation op) {
		String ret = "";
		
		switch (op) {
		case EQUAL: ret = "iequal"; break;
		case NEQUAL: ret = "inequal"; break;
		case INF: ret = "inf"; break;
		case SUP: ret = "isup"; break;
		case SUPEQ: ret = "isupeq"; break;
		case INFEQ: ret = "iinfeq"; break;
		case PLUS : ret = "iadd"; break;
		case MINUS: ret = "imin"; break;
		case MINUSUN: ret = "iminun"; break;
		case MUL: ret = "imul"; break;
		case DIV: ret = "idiv"; break;
		case AND: ret = "iand"; break;
		case OR: ret = "ior"; break;
		case NOT: ret = "inot"; break;
		}
		return ret;
	}
	
	public void ecrireEnt() {
		
	}
	
	public void ecrireChaine(String chaine) {
		ecrire("ecrireChaine " + chaine);
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
				ecrire("lireEnt " + getOffset((IdVar)ident));
			}
			else {
				ecrire("no sé qué faire avec lireEnt cte.");
			}
		}
	}
	
	public void aLaLigne() {
		ecrire("aLaLigne");
	}
	
	/*
	 * @return offset d'une variable
	 */
	public int getOffset(IdVar var) {
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
		System.out.print(str + "\n");
	}
}
