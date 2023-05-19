//Write a C program to check whether a number is negative, positive, or zero
#include <stdio.h>
int main(){
  int num1;
    printf("Input any number\n");
    scanf("%d", &num1);
    if (num1>0)
      printf("%d is a positive number",num1);
    else if (num1==0)
      printf("%d is zero", num1);
    else if (num1<0)
      printf("%d is negative number", num1)
      ;
  return 0;
}