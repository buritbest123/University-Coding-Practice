//Write a C program to input any character and check whether it is the alphabet, digit, or special character.
#include <stdio.h>
int main(){
  char alphabet;
  printf("input any character\n");
    scanf("%c", &alphabet);
  if((alphabet>='a'&& alphabet<='z') || (alphabet>='A' && alphabet<='Z')) {
    printf("%c is the alphabet", alphabet);
  }
  // อย่าลืมว่า char ใช้ 'Letters, Digits 0-9, Special symbols'
  else if (alphabet>='0' && alphabet<='9') {
    printf("%c is the digit", alphabet);
    }
  else {
    printf("%c is the special character", alphabet);
  }
  return 0;
}

