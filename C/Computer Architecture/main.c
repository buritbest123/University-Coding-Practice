#include <stdio.h>
int size = 5;
void printArray(int array[]) {
  for (int i = 0; i < size; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}

int main(void) {
  int Numlist[size];
  int i = 0;
  printf("Please enter 5 number\n");
  do {
    scanf("%d", &Numlist[i]);
    i++;
  } while (i < size);

  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      if (Numlist[i] > Numlist[j]) {
        int temp = Numlist[i];
        Numlist[i] = Numlist[j];
        Numlist[j] = temp;
      }
    }
  }
  printf("Sort number in Descending order : ");
  printArray(Numlist);
  return 0;
}