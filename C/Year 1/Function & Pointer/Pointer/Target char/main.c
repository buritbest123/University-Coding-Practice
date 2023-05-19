#include <stdio.h>
#include <string.h>
int main()
{
    char str[50] = "This is a sample string";
    char ex = 'p';
    char *result = strchr(str, ex);
    printf("%s", result);
    return 0;
}