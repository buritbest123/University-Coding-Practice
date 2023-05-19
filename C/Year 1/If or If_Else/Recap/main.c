#include <stdio.h>

int main() {
  //Input 1) price 2) membership status 3)age
  float total_price;
  char member_status;
  int age, cash_credit;

    printf("What is your total price? Are you a member status Y/N? How old are you? pay cash or credit type 0 for cash type 1 for credit card\n");
      scanf("%f %c %d %d", &total_price, &member_status, &age, &cash_credit);

    if (member_status=='Y')
      {
      if (age>60)
        printf("%.2f is your total price.", total_price=total_price-total_price*(20.0/100.0));
      else 
        printf("%.2f is your total price.", total_price=total_price-total_price*(10.0/100.0));
      }
    else if (member_status=='N')
    {
      if (cash_credit==1)
        printf("%.2f is your total price.", total_price=total_price-total_price*(5.0/100.0));
      else if (cash_credit==0)
        printf("%.2f is your total price", total_price);
    }
    else if (member_status!='Y' && member_status !='N')
      printf("Invalid Input");
  return 0;
}
