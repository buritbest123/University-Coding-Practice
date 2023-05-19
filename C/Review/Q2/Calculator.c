#include <stdio.h>

int main(void)
{
int n1, n2;
char operator;
    do
    {
        scanf("%d%d %c", &n1, &n2, &operator);
        if (operator == '+')
        {
            printf("%d\n", n1 + n2);
        }
        else if (operator== '-')
        {
            printf("%d\n", n1 - n2);
        }
        else if (operator== '*')
        {
            printf("%d\n", n1 * n2);
        }
        else if (operator== '/')
        {
            if (n2 == 0)
            {
                printf("Cannot divide by zero!, You FOOL XD");
                break;
            }
            printf("%d\n", n1 / n2);
        }
    } while ((n1 != 999 && n2 != 999 ) && operator != 'C');
        printf("Goodbye!\n");
    return 0;
}