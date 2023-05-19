#include <stdio.h>

int main(void) {
  int celcius, kelvin;
    printf("What celcius(°C) you would like to change to kelvin   (K)?\n");
      scanf("%d", &celcius);
    printf("Celcius : %d °C\nKelvin : %.2f K",celcius, (celcius/5)*5+273.15 );

  return 0;
}