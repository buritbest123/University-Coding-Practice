; nasm -f obj -d obj_type Testcode.asm
; bcc32 Testcode.obj driver.obj asm_io.obj
; Testcode.exe

%include "asm_io.inc"
segment _DATA public align=4 class=DATA use32
message db "Descending sort five integers from user input: " , 10 ,0
message_output db "Output: ",0xa, 0
array times 5 dw 0

group DGROUP  _DATA

segment _TEXT public align=1 class=CODE use32
        global  _asm_main
_asm_main:
    
    mov ebx,0
    scanloop:
        call read_int
        mov [array+ebx] , eax
        inc ebx
        cmp ebx , 5
        jl scanloop



    mov edx ,1
    Outloop: 
        mov esi , edx
        
        beginwhile: 
            cmp esi ,0
            jg beginwhile2
            jl endwhile
            
            
            mov esi , edx
            beginwhile2:
                mov bl , [array+esi]
                mov cl , [array+esi-1]
                cmp bl , cl
                jg swap
                jmp endwhile2
            
            swap:
                mov [array+esi-1],bl
                mov [array+esi], cl
                jmp endwhile2
            
            endwhile2:
                jmp endwhile
            
        endwhile:
            sub esi ,1
            cmp esi ,0
            jg beginwhile    
    
    add edx ,1
    cmp edx ,5
    jl  Outloop
            
   
    mov ecx ,0
    print:
        mov al,[array+ecx]
        call print_int
        mov eax, 32
        call print_char
        add ecx ,1
        cmp ecx ,5
        jl print
ret

