
	;entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.386
.CODE

max:

	;ouvbloc 6
	enter 6,0

	;iload 6
	push word ptr [bp+6]

	;istore -6
	pop ax
	mov word ptr [bp-6],ax

	;iload -6
	push word ptr [bp+-6]

	;iload 4
	push word ptr [bp+4]

	;isup
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0

	;iffaux SINON1
	pop ax
	cmp ax, 0
	je SINON1

	;iload -6
	push word ptr [bp+-6]

	;ireturn 8
	pop ax
	mov [bp+8],ax

	;goto FSI1
	jmp FSI1

SINON1:

	;iload 4
	push word ptr [bp+4]

	;ireturn 8
	pop ax
	mov [bp+8],ax

FSI1:

	;fermebloc 4
	leave
	ret 4

min:

	;ouvbloc 0
	enter 0,0

	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	;iinf
	pop bx
	pop ax
	cmp ax,bx
	jge $+6
	push -1
	jmp $+4
	push 0

	;iffaux SINON2
	pop ax
	cmp ax, 0
	je SINON2

	;iload 6
	push word ptr [bp+6]

	;ireturn 8
	pop ax
	mov [bp+8],ax

	;goto FSI2
	jmp FSI2

SINON2:

	;iload 4
	push word ptr [bp+4]

	;ireturn 8
	pop ax
	mov [bp+8],ax

FSI2:

	;fermebloc 4
	leave
	ret 4

sup:

	;ouvbloc 0
	enter 0,0

	;iload 6
	push word ptr [bp+6]

	;iload 4
	push word ptr [bp+4]

	;isup
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0

	;ireturn 8
	pop ax
	mov [bp+8],ax

	;fermebloc 4
	leave
	ret 4

	;entete main
	debut :
	STARTUPCODE
	main :

	;ouvbloc 8
	enter 8,0

	;iconst 5
	push word ptr 5

	;lireEnt -4
	lea dx, [bp-4]
	push dx
	call lirent

	;aLaLigne
	call ligsuiv

	;iload -2
	push word ptr [bp+-2]

	;iload -4
	push word ptr [bp+-4]

	;iconst 5
	push word ptr 5

	;iconst 2
	push word ptr 2

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;iconst 1
	push word ptr 1

	;iload -2
	push word ptr [bp+-2]

	;iload -4
	push word ptr [bp+-4]

	;iconst 5
	push word ptr 5

	;isub
	pop bx
	pop ax
	sub ax,bx
	push ax

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;iload -2
	push word ptr [bp+-2]

	;iconst 2
	push word ptr 2

	;imul
	pop bx
	pop ax
	imul bx
	push ax

	;iload -4
	push word ptr [bp+-4]

	;aLaLigne
	call ligsuiv

	;iload -6
	push word ptr [bp+-6]

	;aLaLigne
	call ligsuiv

	;iload -8
	push word ptr [bp+-8]

	;queue
	nop
	EXITCODE
	End debut
