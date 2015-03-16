
public class YVMasm extends YVM{
	
	private int msgCount;
	
	public void iadd() {
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("add ax,bx");
		ecrire("push ax");
	}
	public void imin() {
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	public void iminun(){
		ecrire("pop bx");
		ecrire("mov ax,0");
		ecrire("sub ax,bx");
		ecrire("push ax");
	}
	public void iload(int offset) {
		ecrire("push word [bp" + offset + "]");
	}
	
	public void iconst(int value) {
		ecrire("push word ptr " + value);
	}
	
	public void istore(int offset) {
		ecrire("pop ax");
		ecrire("mov word ptr[bp"+offset+"],ax");
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
		ecrire("cwd");
		ecrire("imul bx");
		ecrire("push ax");
	}
	public void aLaLigne(){
		ecrire("call ecrent");
	}
	public void lireEnt(int offset){
		ecrire("lea dx, [bp-"+offset+"]");
		ecrire("push dx");
		ecrire("call lirent");
	}
	public void ecrireChaine(String chaine){
		ecrire(".DATA");
		ecrire("mess"+(msgCount)+"DB \""+chaine+"$\"");
		ecrire(".CODE");
		ecrire("lea dx, mess"+(msgCount++));
		ecrire("push dx");
		ecrire("call ecrch");
	}
	public void entete(){
		ecrire("extrn lirent:proc, ecrent:proc");
		ecrire("extrn ecrbool:proc");
		ecrire("extrn ecrch:proc, ligsuiv:proc");
		ecrire(".model SMALL");
		ecrire(".586");
		ecrire(".CODE");
		ecrire("debut :");
		ecrire("STARTUPCODE");
	}
	public void ouvrePrinc(int offset){
		ecrire("mov bp, sp");
		ecrire("sub sp,"+offset);
	}
	public void queue(){
		ecrire("nop");
		ecrire("EXITCODE");
		ecrire("End debut");
	}
	public void ecrire(String out) {
		System.out.println("\t" + out);
	}
}
