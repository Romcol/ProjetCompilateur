import java.io.OutputStream;


public class YVM implements Constants{
	
	protected OutputStream out;
	
	public YVM() {
		this.out = Ecriture.ouvrir("test/out.asm");
	}

	public void addVar(IdVar var) {
	}
	
	public void entete() {
		ecrire("entete");
	}
	
	public void alloc() {
		ecrire("ouvrePrinc " + Yaka.tabIdent.getNbVar() * 2);
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
	public void isup(){
		ecrire("isup");
	}
	public void isupegal(){
		ecrire("isupegal");
	}
	public void iinf(){
		ecrire("iinf");
	}
	public void iinfegal(){
		ecrire("iinfegal");
	}
	public void iegal(){
		ecrire("iegal");
	}
	public void inegal(){
		ecrire("inegal");
	}
	public void iand(){
		ecrire("iand");
	}
	public void ior(){
		ecrire("ior");
	}
	public void inot(){
		ecrire("inot");
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
			ecrireErreur("Erreur instruction lireEnt (ident "+ identLu +" non trouvé.)");
		}
		else {
			if(ident instanceof IdVar) {
				lireEnt(ident.getValue());
			}
			else {
				ecrireErreur("lireEnt impossible avec une constante");
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
	 * calcule un offset à partir d'un index. Ex :
	 * 0 -> -2
	 * 1 -> -4
	 * 2 -> -6 ...
	 */
	protected int indexToOffset(int index) {
		return -2 * (index + 1);
	}

	
	private void ecrire(String str) {

		Ecriture.ecrireString(out,"\n\t;" + str + "\n");
	}


	public void ecrireOp(Constants.Operation op) {
		switch (op) {
			case EQUAL: 	iegal();	break;
			case NEQUAL: 	inegal();	break;
			case INF: 		iinf(); 	break;
			case SUP: 		isup(); 	break;
			case SUPEQ:		isupegal(); break;
			case INFEQ:		iinfegal(); break;
			case PLUS :		iadd(); 	break;
			case MINUS:		imin(); 	break;
			case SUB: 		isub(); 	break;
			case MUL: 		imul(); 	break;
			case DIV: 		idiv(); 	break;
			case AND: 		iand();		break;
			case OR: 		ior();		break;
			case NOT: 		inot();		break;
		}
	}
	
	
	public void ecrireErreur(String message) {
		System.out.println(message + 
				" (in \"" + Yaka.token.image + "\"," +
				"line:" + Yaka.token.beginLine
				+ ", column:" + Yaka.token.beginColumn + "-" + Yaka.token.endColumn + ")");
	}
}
