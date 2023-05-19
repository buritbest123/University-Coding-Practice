//Write a C program to count a total number of notes in a given amount
#include <stdio.h>
int main(){
  int notes;
    printf("please input your money to change\n");
      scanf("%d", &notes);
  int fivehundred = notes/500;
  int hundred = (notes%500)/100;
  int fifty = (notes%100)/50;
  int twenty = (notes%50)/20;
  int ten = (notes%10)/10;
  int five = (notes%10)/5;
  int two = (notes%2)/2;
  int one = (notes%500)%5;
    printf ("500: %d\n100: %d\n50: %d\n20: %d\n10: %d\n5: %d\n2: %d\n1: %d\n", fivehundred, hundred, fifty, twenty, ten, five, two, one);
  return 0;
}