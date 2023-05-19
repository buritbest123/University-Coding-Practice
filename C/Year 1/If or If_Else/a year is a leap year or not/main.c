//Write a C program to check whether a year is a leap year or not.
#include <stdio.h>
int main(){
  int year;
    printf("Pick any year you like\n");
      scanf("%d", &year);
    if(((year % 4 == 0) && (year % 100 !=0)) || (year % 400==0))
    {
        printf("LEAP YEAR");
    }
    else
    {
        printf("COMMON YEAR");
    }
    return 0;
}