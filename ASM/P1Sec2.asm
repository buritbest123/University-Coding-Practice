%include "asm_io.inc"

segment _DATA public align=4 class=DATA use32

Input           db  "Please enter Number: "     , 0 ; String input
Messagemid      db  "Middle Number: "           , 0 ; String of middle
MessageEND      db  "Sorted Number in order: "  , 0 ; String for array
intarr times 5  dw                                0 ; Array

segment _BSS public align=4 class=BSS use32
NumI         resd     1     ; Variable I
NumJ         resd     1     ; Variable J
NumInput     resd     1     ; Variable Input
NumOut       resd     1     ; Variable Output
       

group DGROUP _BSS _DATA
segment _TEXT public align=1 class=CODE use32

        global  _asm_main ; voidmain()
_asm_main:
        enter 0,0
        pusha
    loopI:
        mov edx , [NumI]
        mov eax , Input
        call print_string
        call read_int
        mov [NumInput]     , eax
        mov [NumJ]         , edx
    loopJ:
        mov ebx , [NumJ]
        mov edx , [NumI]
        mov al  , [NumInput]
        cmp [intarr+ebx-1] , al
        jnge N_IF
        mov cl  , [intarr+ebx-1]
        mov [intarr+ebx]   , cl
        dec ebx
        mov [NumJ]         , ebx
        cmp ebx , 0
        jg loopJ
    N_IF:
        mov al  , [NumInput]
        mov ebx , [NumJ]
        mov [intarr+ebx]  , al
    Break:
        mov edx , [NumI]
        inc edx
        mov [NumI]        , edx
        cmp edx , 5
        jnz loopI
        mov ecx , 0
        mov eax , MessageEND
        call print_string
    Print:
        mov al  , [intarr+ecx]
        mov [NumOut]      , al
        mov eax , [NumOut]
        call print_int
        mov eax , 0
        call print_char
        inc ecx
        cmp ecx , 5
        jnz Print
        mov eax , Messagemid
        call print_nl
        call print_string
        mov al  , [intarr+2]
        mov [NumOut]      , al
        mov eax , [NumOut]
        call print_int

popa
 mov al, 0
 leave
ret