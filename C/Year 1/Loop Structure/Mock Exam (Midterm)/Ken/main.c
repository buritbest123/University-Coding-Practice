#include <stdio.h>

int input;
int main()
{
    do
    {
        scanf("%d", &input);
    } while (input <= 0 || input % 2 == 0);
    
    for (int i = 0; i <= input; i++)
    {
        int j;
        for (j = 0; j < input - i; j++)
        {
            printf("-");
        }
        for (int k = 0; k < input - j; k++)
        {
            i % 2 == 1 ? printf("+") : printf("*");
        }
        printf("\n");
    }
    
    return 0;
}