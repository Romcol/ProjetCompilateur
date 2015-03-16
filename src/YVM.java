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
	 * Initialise la pile avec les valeurs tabIdent. Execut�e apr�s la d�claration des variables.
	 */
	public void initStack() {
		for (Map.Entry<String, Ident> entry : Yaka.tabIdent.getTable().entrySet())
		{				
			if(entry.getValue() instanceof IdVar){
				pile.push((IdVar) entry.getValue());
			}
		}
	}
	
	public void entete() {
		ecrire("entete");
	}
	
	public void alloc() {
		ecrire("ouvrePrinc " + pile.size() * 2);
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

	
	public void iadd() {
		ecrire("iadd");
	}
	public void imin() {
		ecrire("imin");
	}
	
	public void idiv(){
		ecrire("idiv");
	}

	public void imul(){
		ecrire("imul");
	}
	
	public void isub() {
		ecrire("isub");
	}
	
	public void ecrireEnt() {
		ecrire("ecrireEnt");
	}
	
	public void ecrireChaine(String chaine) {
		ecrire("ecrireChaine " + chaine);
	}
	
	public void ecrireBool() {
		ecrire("ecrireBool");
	}
	
	public void lireEnt(String identLu) {
		
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			System.out.println("Erreur instruction lireEnt (ident "+ identLu +" non trouv�.)");
		}
		else {
			if(ident instanceof IdVar) {
				lireEnt(getOffset((IdVar)ident));
			}
			else {
				System.out.println("lireEnt impossible avec une constante");
			}
		}
	}
	
	public void lireEnt(int offset) {
		ecrire("lireEnt " + offset);
	}
	
	public void aLaLigne() {
		ecrire("aLaLigne");
	}
	
	public void queue(){
		ecrire("queue");
	}
	
	/*
	 * @return offset d'une variable
	 */
	public int getOffset(IdVar var) {
		return(indexToOffset(pile.indexOf(var)));
	}
	
	/*
	 * calcule un offset � partir d'un index. Ex :
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
		System.out.print("\n\t;" + str + "\n");
	}


	public void ecrireOp(Constants.Operation op) {
		switch (op) {
			case EQUAL: 	break;
			case NEQUAL: 	break;
			case INF: 		break;
			case SUP: 		break;
			case SUPEQ:		break;
			case INFEQ:		break;
			case PLUS :		iadd(); break;
			case MINUS:		imin(); break;
			case SUB: 		isub(); break;
			case MUL: 		imul(); break;
			case DIV: 		idiv(); break;
			case AND: 		break;
			case OR: 		break;
			case NOT: 		break;
		}
	}
}
