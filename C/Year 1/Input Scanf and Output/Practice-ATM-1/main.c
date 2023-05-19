#include <stdio.h>
int main(){  
    
    {
      int withdraw, balance ;
          printf("Please enter amount money are you going withdraw and  balance\n");
          scanf("%d %d", &withdraw, &balance);
        if (withdraw % 5 != 0)
          printf("Error");
        else if (balance-withdraw >= 0)
          printf("Here is your money %d" ,balance-withdraw);
        else if (balance-withdraw < 0)
          printf("Error");

    }
    return 0;
}
