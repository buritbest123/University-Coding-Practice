//Write a C program to input any alphabet and check whether it is vowel or consonant.
#include <stdio.h>
int main(){
  char character;
  printf("Input any alphabet\n");
    scanf("%c", &character);
  if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' || character=='A' || character=='E' || character=='I' || character=='O' || character=='U') 
  {
    printf("%c is vowel", character);
  }
  else
    printf("%c is consonant", character);
 return 0;
}