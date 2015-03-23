
public class YVMasm extends YVM{
	
	private int msgCount;
	
	
	public void entete(){
		ecrire("extrn lirent:proc, ecrent:proc");
		ecrire("extrn ecrbool:proc");
		ecrire("extrn ecrch:proc, ligsuiv:proc");
		ecrireDeb(".model SMALL");
		ecrireDeb(".586");
		ecrireDeb(".CODE");
		ecrire("debut :");
		ecrire("STARTUPCODE");

	}
	
	public void alloc() {
		ecrire("mov bp, sp");
		ecrire("sub sp," + pile.size() * 2);
	}

	public void iconst(int value) {
		ecrire("push word ptr " + value);
	}
	
	public void iload(int offset) {
		ecrire("push word ptr [bp" + offset + "]");
	}
	
	public void istore(int offset) {
		ecrire("pop ax");
		ecrire("mov word ptr [bp"+offset+"],ax");
	}
	
	public void iadd() {
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("add ax,bx");
		ecrire("push ax");
	}

	public void imin(){
		ecrire("pop bx");
		ecrire("mov ax,0");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	
	public void idiv(){
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cwd");
		ecrire("idiv bx");
		ecrire("push ax");
	}
	public void imul(){
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("imul bx");
		ecrire("push ax");
	}
	
	public void isub() {
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	public void ecrireEnt() {
		ecrire("call ecrent");
	}
	
	public void ecrireChaine(String chaine){
		ecrireDeb(".DATA");
		ecrire("mess"+(msgCount)+" DB \""+chaine.replace("\"", "")+"$\"");
		ecrireDeb(".CODE");
		ecrire("lea dx, mess"+(msgCount++));
		ecrire("push dx");
		ecrire("call ecrch");
	}
	
	public void ecrireBool() {
	}
	
	public void lireEnt(int offset){
		ecrire("lea dx, [bp"+offset+"]");
		ecrire("push dx");
		ecrire("call lirent");
	}
	
	public void aLaLigne(){
		ecrire("call ligsuiv");
	}
	
	public void queue(){
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
