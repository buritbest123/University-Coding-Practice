#include <stdio.h>

int main(void) {
  int input;
  int loopDeterminer;
  int i;
  for(; ;) {
    loopDeterminer = 1;
    printf("Input a number: ");
    scanf("%d", &input);
    while(input != 0) {
      for(i = 0; i < loopDeterminer; i++) {
        printf("*");
      }
      loopDeterminer++;
      printf("\n");
      input --;
    }
  }
}