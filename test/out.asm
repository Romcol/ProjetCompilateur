
	;entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.386
.CODE
	debut :
	STARTUPCODE

	;ouvrePrinc 10
	mov bp, sp
	sub sp,10

	;iconst 2
	push word ptr 2

	;iconst 2
	push word ptr 2

	;iconst 3
	push word ptr 3

	;imul
	pop bx
	pop ax
	imul bx
	push ax

	;iload -10
	push word ptr [bp-10]

	;ecrireEnt
	call ecrent

	;aLaLigne
	call ligsuiv

	;iconst 2
	push word ptr 2

	;iconst 2
	push word ptr 2

	;iconst 2
	push word ptr 2

	;iconst 1
	push word ptr 1

	;iconst 2
	push word ptr 2

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;ecrireEnt
	call ecrent

	;queue
	nop
	EXITCODE
	End debut
