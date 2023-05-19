//Write a C program to input the month number and print the number of days in that month.
#include <stdio.h>
int main(){
  int month_number;
    printf("Enter month number (1-12): ");
      scanf("%d", &month_number);
    if(month_number==1 || month_number==3 || month_number==5 || month_number==7 || month_number==8 || month_number==10 || month_number==12)
    {
      printf("31 days");
    }
    else if(month_number==4 || month_number==6 || month_number==9 || month_number==11){
      printf("30 days");
    }
    else if (month_number==2){
      printf("28 or 29 days");
    }
    else 
      printf("Invalid input! Please enter month number between (1-12).");
      
  return 0;
}