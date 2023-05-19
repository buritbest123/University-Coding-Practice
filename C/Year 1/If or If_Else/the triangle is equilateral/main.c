/*Write a C program to check whether the triangle is equilateral (สามเหลี่ยมด้านเท่า
), isoscele(สามเหลี่ยมหน้าจั่ว
) or scalene triangle(สามเหลี่ยมด้านไม่เท่า).*/
#include <stdio.h>
int main(){
  int a, b, c;
    printf("Input three angles of triangle\n");
      scanf("%d %d %d", &a, &b, &c);
  if ((a == b) && (b==c))
    printf("Triangle is equilateral");
  else if ((a==b) || (a==c) ||(b==c))
    printf("Triangle is isosceles");
  else 
    printf("Triangle is scalene triangle");
  return 0;
}