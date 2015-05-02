
	;entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.386
.CODE
	debut :
	STARTUPCODE

	;ouvrePrinc 8
	mov bp, sp
	sub sp,8

	;iconst 1
	push word ptr 1

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;iconst 2
	push word ptr 2

	;istore -6
	pop ax
	mov word ptr [bp-6],ax

	;iload -6
	push word ptr [bp-6]

	;iload -4
	push word ptr [bp-4]

	;isup
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0

	;iffaux SINON1:
	pop ax
	cmp ax, 0
	je SINON1

	;ecrireChaine "OK"
.DATA
	mess0 DB "OK$"
.CODE
	lea dx, mess0
	push dx
	call ecrch

	;iload -6
	push word ptr [bp-6]

	;iload -4
	push word ptr [bp-4]

	;iinf
	pop bx
	pop ax
	cmp ax,bx
	jge $+6
	push -1
	jmp $+4
	push 0

	;iffaux SINON2:
	pop ax
	cmp ax, 0
	je SINON2

	;ecrireChaine "POK"
.DATA
	mess1 DB "POK$"
.CODE
	lea dx, mess1
	push dx
	call ecrch

	;goto FSI2
	jmp FSI2

SINON2:

	;ecrireChaine "OK"
.DATA
	mess2 DB "OK$"
.CODE
	lea dx, mess2
	push dx
	call ecrch

	;iload -6
	push word ptr [bp-6]

	;iload -4
	push word ptr [bp-4]

	;iinf
	pop bx
	pop ax
	cmp ax,bx
	jge $+6
	push -1
	jmp $+4
	push 0

	;iffaux SINON3:
	pop ax
	cmp ax, 0
	je SINON3

	;ecrireChaine "POK"
.DATA
	mess3 DB "POK$"
.CODE
	lea dx, mess3
	push dx
	call ecrch

	;goto FSI3
	jmp FSI3

SINON3:

	;ecrireChaine "OK"
.DATA
	mess4 DB "OK$"
.CODE
	lea dx, mess4
	push dx
	call ecrch

FSI3:

FSI2:

	;goto FSI1
	jmp FSI1

SINON1:

	;ecrireChaine "POK"
.DATA
	mess5 DB "POK$"
.CODE
	lea dx, mess5
	push dx
	call ecrch

FSI1:

	;queue
	nop
	EXITCODE
	End debut
