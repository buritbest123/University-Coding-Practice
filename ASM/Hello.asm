%include "asm_io.inc"

segment _DATA public align=4 class=DATA use32

Message db  "Please enter 5 Number:", 10, 13, 0
MessageEND db  "Sorted Number in decending order:", 10, 13, 0
Array  times    5 dd 0

segment _BSS public align=4 class=BSS use32
NumOut       resd     1     ; Variable Output
       

group DGROUP _BSS _DATA

segment _TEXT public align=1 class=CODE use32

        global  _asm_main
_asm_main:
        mov     eax,    Message
        call    print_string

        mov     ebx,0 ; i
        LInput: ; input 5 number
        call    read_int
        mov     [Array+ebx],eax ; input by mov eax to arr[i]
        inc     ebx ; i++
        cmp     ebx,5
        jl      LInput

        mov     ebx,0 ; i
        OuterLoop: 
               mov      edx,0
               InnerLoop:
               mov      al,[Array+edx] ;bl = Array[j]
               cmp      al,[Array+edx+1] ;(eax ,> Array[eax])
               jg       Skip
               mov      cl,[Array+edx+1]
               mov      [Array+edx+1],al
               mov      [Array+edx],cl
               
                Skip:
               inc      edx
               cmp      edx,5
               jl       InnerLoop
        inc     ebx
        cmp     ebx,5
        jl      OuterLoop

        mov ecx , 0
        mov eax , MessageEND
        call print_string
    Print:
        mov al  , [Array+ecx]
        mov [NumOut]      , al
        mov eax , [NumOut]
        call print_int
        mov eax , 0
        call print_char
        inc ecx
        cmp ecx , 5
        jl Print


ret