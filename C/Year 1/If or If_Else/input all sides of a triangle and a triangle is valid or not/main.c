// Write a C program to input all sides of a triangle and check whether a triangle is valid or not.
#include <stdio.h>
int main (){
  int a, b, c;
    printf("please insert three inputs\n");
      scanf("%d %d %d", &a, &b, &c);
    if ((a+b)>c){
    if ((a+c)>b){
    if ((b+c)>a){
          printf("Triangle is valid");
          }
        }
      }
    else{
      printf("Triangle is not valid");  
    }      
  return 0;
}
    
