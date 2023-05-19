//Write a C program to find the maximum between two numbers.

#include <stdio.h>
int main(){
  int num1, num2;
  // input two numbers from user
    printf("Please insert two numbers to find the maximum\n");
      scanf("%d %d", &num1, &num2);
  // compare with num1 and num2
    if (num1>num2)
      printf("%d is maximum", num1);
    else 
      printf("%d is maximum", num2);
  return 0;
}