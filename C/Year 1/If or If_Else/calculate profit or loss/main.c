//Write a C program to calculate profit or loss.
#include <stdio.h>
int main(){
  int i_buy, i_sell;
    printf ("What products are you buy and you want to sell\n");
      scanf("%d %d", &i_buy, &i_sell);
  if (i_sell>i_buy)
    printf("Your profit is %d", i_sell-i_buy);
  else if (i_buy==i_sell)
    printf("You don't get any profit or loss");
  else 
    printf("Your loss is %d", i_buy-i_sell);
  return 0;
}