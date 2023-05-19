//7. Write a C program to check whether a character is an alphabet or not.
#include<stdio.h>
int main(){
  char character;
    printf("Insert anything\n");
      scanf("%c", &character);
  if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
    printf("%c is an alphabet", character);
  }
  else {
    printf("%c is not an alphabet", character);
  }
  return 0;
}