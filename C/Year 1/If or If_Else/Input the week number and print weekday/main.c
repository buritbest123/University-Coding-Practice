//Write a C program to input the week number and print weekday.
#include <stdio.h>
int main(){
  int week_number;
    printf("please insert the number of week\n");
      scanf("%d", &week_number);
  if (week_number == 1)
    printf("Monday");
  else if (week_number == 2)
    printf("Tuesday");  
  else if (week_number == 3)
    printf("Wednesday");
  else if (week_number == 4)
    printf("Thursday");    
  else if (week_number == 5)
    printf("Friday");
  else if (week_number == 6)
    printf("Saturday");    
  else if (week_number == 7)
    printf("Sunday");  
  else
    printf("Invalid input! Please enter week number between 1-7.");
  return 0;
}