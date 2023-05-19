// 0. Write a C program to check whether a character is an uppercase or lowercase alphabet.
#include <stdio.h>
int main(){
  char chr;
    printf("Insert any character\n");
      scanf("%c", &chr);
  if (chr>='a' && chr<='z')
    printf("%c is lowercase alphabet", chr);
  else if (chr>='A' && chr<='Z')
    printf("%c is uppercase alphabet", chr);
  else
    printf("%c is not the alphabet", chr);
  return 0;
}