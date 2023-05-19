#include <stdio.h>

int main(void) {
  int BE;
    printf("What is birth on Buddhist calendar(B.E.)? I would like to change to Anno Domini(A.D.).\n");
      scanf("%d", &BE);
    printf("Your birth in Anno Domini is %d", BE-543);
  return 0;
}