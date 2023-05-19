#include <stdio.h>
#include <conio.h>


unsigned limit;
unsigned guess;
unsigned factor;

int main()
{
printf ("Find prime up to : ");
scanf ("%u", &limit);

printf ("2\n");
printf ("3\n");
guess = 5;
while (guess <= limit)
{     factor = 3;
      while (factor*factor < guess &&  guess%factor != 0)
      factor +=2;
      if (guess%factor !=0)
      printf ("%d\n", guess);
      guess += 2;
}
return(0);
}
