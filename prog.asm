	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
	debut :
	STARTUPCODE
	mov bp, sp
	sub sp,4
	push word ptr 8
	pop ax
	mov word ptr [bp-2],ax
.DATA
	mess0 DB "c1=$"
.CODE
	lea dx, mess0
	push dx
	call ecrch
	push word ptr [bp-2]
	call ecrent
	call ligsuiv
.DATA
	mess1 DB "-45=$"
.CODE
	lea dx, mess1
	push dx
	call ecrch
	push word ptr 2
	pop bx
	mov ax,0
	sub ax,bx
	push ax
	push word ptr [bp-2]
	pop bx
	pop ax
	imul bx
	push ax
	push word ptr 3
	pop bx
	mov ax,0
	sub ax,bx
	push ax
	push word ptr 4
	pop bx
	pop ax
	imul bx
	push ax
	push word ptr 2
	pop bx
	pop ax
	imul bx
	push ax
