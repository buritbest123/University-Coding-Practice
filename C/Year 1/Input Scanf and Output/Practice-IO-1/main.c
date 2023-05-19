//Install Library ST = Standard IO = Input and out put
#include <stdio.h>

//main fuction
    int main() {

//input int = Integer (จำนวนเต็ม only) char = Character float = floating point (ทศนิยม)
    int member, father, mother, sister1;
    char namef[127];
    float height;

/*Display Question: Memeber, Father name,and Height and Getting value from Users*/
    printf("How many members in your family?\n");
      scanf("%d", &member);
    printf("What is your father first name (cm)?\n");
      scanf("%s", &namef);
    printf("What tall is your father?\n");   scanf("%f", &height);

// Displaying all values of given variable
    printf("Your members family is %d\nFather name is %s\nYour father tall is %.1f ", member, namef, height);
  return 0;
}