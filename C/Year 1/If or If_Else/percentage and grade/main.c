/* Write a C program to input marks of five subjects Physics, Chemistry, Biology,
Mathematics, and Computer. Calculate percentage and grade according to the
following:
a. Percentage >= 90% : Grade A
b. Percentage >= 80% : Grade B
c. Percentage >= 70% : Grade C
d. Percentage >= 60% : Grade D
e. Percentage >= 40% : Grade E
f. Percentage < 40% : Grade F*/

#include <stdio.h>
int main(){
  int phy, chem, bio, math, comp;
  float per;
    printf("Please input your score on five subjects.\n");
      scanf("%d %d %d %d %d", &phy, &chem, &bio, &math, &comp);
  per = (phy + chem + bio + math + comp) / 5.0;
    printf("Percentage = %.2f\n", per);
    if (per>=90)
      printf("Grade A");
    else if (per>=80 && per<90)
      printf("Grade B");
    else if (per>=70 && per<80)
      printf("Grade C");
    else if (per>=60 && per<70)
      printf("Grade D");
    else if (per>=40 && per<60)
      printf("Grade E");
    else if (per<40)
      printf("Grade F");

  return 0;
}