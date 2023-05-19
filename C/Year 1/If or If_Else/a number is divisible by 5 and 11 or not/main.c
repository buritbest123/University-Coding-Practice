//Write a C program to check whether a number is divisible by 5 and 11 or not
#include <stdio.h>
int main(){
  int num1;
    printf("Please insert any number\n");
      scanf("%d", &num1);
  if (num1%5 == 0 && num1%11 == 0){
    printf("Your number can divisible by 5 and 11");
  }
  else{ 
    printf("Your number can't divisible by 5 and 11");
  }
  return 0;
}