; Run the program (6488079P1Sec1.exe) in Command Prompt 
; nasm -f obj -d obj_type 6488079P1Sec1.asm
; bcc32 6488079P1Sec1.obj driver.obj asm_io.obj
; 6488079P1Sec1.exe
%include "asm_io.inc" ; 
segment _DATA public align=4 class=DATA use32

Message1_display db  "Input five numbers (any number): ", 10, 13, 0
Message2_display db  "The numbers are displayed below in descending order:", 10, 13, 0
array  times    5 dd 0

segment _BSS public align=4 class=BSS use32
x      resd     1     
       
group DGROUP _BSS _DATA 

segment _TEXT public align=1 class=CODE use32

        global  _asm_main
_asm_main:            
        mov     eax,    Message1_display
        call    print_string 

        mov     ebx, 0 
        userinput:
                call    read_int
                mov     [array+ebx], eax 
                inc     ebx 
                cmp     ebx, 5
                jl      userinput

        mov     ebx,0
        Outer_Loop: 
               mov      edx, 0
               Inner_Loop:
               mov      al, [array+edx] 
               cmp      al, [array+edx+1] 
               jg       Skip
               mov      cl, [array+edx+1]
               mov      [array+edx+1], al
               mov      [array+edx], cl
               
                Skip:
               inc      edx
               cmp      edx, 5
               jl       Inner_Loop
        inc     ebx
        cmp     ebx, 5
        jl      Outer_Loop

        mov ecx, 0
        mov eax, Message2_display
        call print_string
        Print:
                mov al, [array+ecx]
                mov [x], al
                mov eax, [x]
                call print_int
                mov eax , 0
                call print_char
                inc ecx
                cmp ecx , 5
                jl Print
ret