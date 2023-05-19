#include <stdio.h>

int main() {
  int Width, Height;
  
    printf("How much width? you would like to compute the area of rectangle.\n");
      scanf("%d", &Width);
    printf("What about height?\n");        
      scanf("%d", &Height);
    printf("Your area in rectangle is %d", Width*Height);
  return 0;
}