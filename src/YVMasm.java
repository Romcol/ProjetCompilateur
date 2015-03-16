
public class YVMasm extends YVM{

	public void iadd() {
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("add ax,bx");
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
	
	public void ecrire(String out) {
		System.out.println("\t" + out);
	}
}
