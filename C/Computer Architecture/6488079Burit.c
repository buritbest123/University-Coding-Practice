#include <stdio.h>
void printArray(int Array[]) {
    for (int i = 0; i < 5; i++)
    {
        printf("%d ", Array[i]);
    }
}    
int main ()
{
    int number[5];
    int i = 0, j, x; 
    printf("Input five numbers (any number): \n");
    do {
        scanf("%d", &number[i]);
        i++;
    } while (i < 5);
    /*  sorting begins ... */
    for (i = 0; i < 5; i++)
    {
        for (j = i + 1; j < 5; j++)
        {
            if (number[i] < number[j])
            {
                x = number[i];
                number[i] = number[j];
                number[j] = x;
            }
        }
    }
    printf("The numbers are displayed below in descending order: \n");
    printArray(number);
    return 0;
}