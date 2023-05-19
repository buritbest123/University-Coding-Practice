//Write a C program to find the maximum between three numbers
#include <stdio.h>
int main(){
  int num1, num2, num3;
    printf("Please insert three numbers to find the maximum\n");
    scanf("%d %d %d", &num1, &num2, &num3);
  if (num1 > num2 && num1 > num3)
    printf("%d is the maximum number", num1);
  else if (num2 > num1 && num2 > num3)
    printf("%d is the maximum number", num2);
  else if (num3 > num1 && num3 > num2)
    printf("%d is the maximum number", num3);
  return 0;
}