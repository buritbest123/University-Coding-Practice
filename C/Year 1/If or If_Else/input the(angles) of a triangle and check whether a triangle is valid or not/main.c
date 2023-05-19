//Write a C program to input the(angles) of a triangle and check whether a triangle is valid or not.
#include <stdio.h>
int main (){
  int a, b, c;
    printf("please insert three inputs\n");
      scanf("%d %d %d", &a, &b, &c);
    if ((a*a)+(b*b)==(c*c))
      printf("Triangle is valid");
    else 
     printf("Triangle is not valid");   
  return 0;
}