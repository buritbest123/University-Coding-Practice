#include <stdio.h>

int main() {
  float Price;
  int tax = 7;
  printf("How much is price? You want.\n");
  scanf("%f", &Price);
  printf("Total Price is %.2f", (Price*tax)/100+Price);
  return 0;
}