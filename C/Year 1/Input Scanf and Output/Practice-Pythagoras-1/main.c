#include <stdio.h>
#include <math.h>
int main() {
  int a, b, c;
  printf("Enter one short sides and long sides of triangle\n");
  scanf("%d %d", &a, &c);
  b = sqrt(c*c-a*a);
  printf("Short sides is %d", b);
  return 0;
}