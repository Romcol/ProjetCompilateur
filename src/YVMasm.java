
public class YVMasm extends YVM{
	
	private int msgCount;
	
	
	public void entete(){
		super.entete();
		ecrire("extrn lirent:proc, ecrent:proc");
		ecrire("extrn ecrbool:proc");
		ecrire("extrn ecrch:proc, ligsuiv:proc");
		ecrireDeb(".model SMALL");
		ecrireDeb(".386");
		ecrireDeb(".CODE");
		ecrire("debut :");
		ecrire("STARTUPCODE");
	}
	
	public void alloc() {
		super.alloc();
		ecrire("mov bp, sp");
		ecrire("sub sp," + Yaka.tabIdent.getNbVar() * 2);
	}

	public void iconst(int value) {
		super.iconst(value);
		ecrire("push word ptr " + value);
	}
	
	public void iload(int offset) {
		super.iload(offset);
		ecrire("push word ptr [bp" + offset + "]");
	}
	
	public void istore(int offset) {
		super.istore(offset);
		ecrire("pop ax");
		ecrire("mov word ptr [bp"+offset+"],ax");
	}
	
	public void iadd() {
		super.iadd();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("add ax,bx");
		ecrire("push ax");
	}

	public void imin(){
		super.imin();
		ecrire("pop bx");
		ecrire("mov ax,0");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	
	public void idiv(){
		super.idiv();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cwd");
		ecrire("idiv bx");
		ecrire("push ax");
	}
	public void imul(){
		super.imul();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("imul bx");
		ecrire("push ax");
	}
	
	public void isub() {
		super.isub();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	public void ecrireEnt() {
		super.ecrireEnt();
		ecrire("call ecrent");
	}
	
	public void ecrireChaine(String chaine){
		super.ecrireChaine(chaine);
		ecrireDeb(".DATA");
		ecrire("mess"+(msgCount)+" DB \""+chaine.replace("\"", "")+"$\"");
		ecrireDeb(".CODE");
		ecrire("lea dx, mess"+(msgCount++));
		ecrire("push dx");
		ecrire("call ecrch");
	}
	
	public void ecrireBool() {
		super.ecrireBool();
	}
	
	public void lireEnt(int offset){
		super.lireEnt(offset);
		ecrire("lea dx, [bp"+offset+"]");
		ecrire("push dx");
		ecrire("call lirent");
	}
	
	public void aLaLigne(){
		super.aLaLigne();
		ecrire("call ligsuiv");
	}
	
	public void queue(){
		super.queue();
		ecrire("nop");
		ecrire("EXITCODE");
		ecrire("End debut");
	}
	
	private void ecrire(String str) {
		Ecriture.ecrireString(out,"\t" + str + "\n");
	}
	
	private void ecrireDeb(String str) {
		Ecriture.ecrireString(out,str+"\n");
	}

}
