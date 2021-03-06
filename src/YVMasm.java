
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
	}
	
	public void main()
	{
		super.main();
		ecrire("debut :");
		ecrire("STARTUPCODE");
		ecrire("main :");
	}
	
	public void alloc() {
		super.alloc();
		ecrire("enter "+Yaka.tabIdent.getNbVar() * 2+",0");
	}

	public void iconst(int value) {
		super.iconst(value);
		ecrire("push word ptr " + value);
	}
	
	public void iload(int offset) {
		super.iload(offset);
		ecrire("push word ptr [bp" + strOffset(offset) + "]");
	}
	
	public void istore(int offset) {
		super.istore(offset);
		ecrire("pop ax");
		ecrire("mov word ptr [bp"+strOffset(offset)+"],ax");
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
	
	public void isup(){
		super.isup();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("jle $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void isupegal(){
		super.isupegal();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("jl $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void iinf(){
		super.iinf();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("jge $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void iinfegal(){
		super.iinfegal();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("jg $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void iegal(){
		super.iegal();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("jne $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void inegal(){
		super.inegal();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("cmp ax,bx");
		ecrire("je $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void iand(){
		super.iand();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("mul ax,bx");
		ecrire("cmp ax,1");
		ecrire("jne $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void ior(){
		super.ior();
		ecrire("pop bx");
		ecrire("pop ax");
		ecrire("add ax,bx");
		ecrire("cmp ax,0");
		ecrire("jg $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
	}
	public void inot(){
		super.inot();
		ecrire("pop ax");
		ecrire("cmp ax,0");
		ecrire("jne $+6");
		ecrire("push -1");
		ecrire("jmp $+4");
		ecrire("push 0");
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
		ecrire("call ecrbool");

	}
	
	public void lireEnt(int offset){
		super.lireEnt(offset);
		ecrire("lea dx, [bp"+strOffset(offset)+"]");
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
	
	// ITERATION
	

	public void iffaux(String label) {
		super.iffaux(label);
		ecrire("pop ax");
		ecrire("cmp ax, 0");
		ecrire("je " + label);
	}
	
	public void igoto(String label) {
		super.igoto(label);
		ecrire("jmp " + label);		
	}
	
	public void label(String label) {
		super.label(label);
	}

	
	private void ecrire(String str) {
		Ecriture.ecrireString(out,"\t" + str + "\n");
	}
	
	private void ecrireDeb(String str) {
		Ecriture.ecrireString(out,str+"\n");
	}
	
	//FUNCTION
	
	public void ouvBloc(int n)
	{
		super.ouvBloc(n);
		ecrire("enter "+n+",0");
	}
	
	public void fermeBloc(int n)
	{
		super.fermeBloc(n);
		ecrire("leave");
		ecrire("ret "+n);
	}

	public void ireturn(int n)
	{
		super.ireturn(n);
		ecrire("pop ax");
		ecrire("mov [bp"+strOffset(n)+"],ax");
	}

	public void call(String s)
	{
		super.call(s);
		ecrire("call "+s);
	}
	
	public void reserveRetour(){
		super.reserveRetour();
		ecrire("sub sp,2");
	}
	
	public String strOffset(int offset) {
		if(offset < 0)
			return "-" + Math.abs(offset);
		else
			return "+" + Math.abs(offset);
	}
}
