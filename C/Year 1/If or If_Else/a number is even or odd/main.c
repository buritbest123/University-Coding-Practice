//Write a C program to check whether a number is even or odd
#include <stdio.h>
int main(){
  int num1;
    printf("Insert any number\n");
      scanf("%d", &num1);
  if (num1%2==0){
    printf("%d is even number", num1);
  }
  else{
    printf("%d is odd number", num1);
  }
  return 0;
}