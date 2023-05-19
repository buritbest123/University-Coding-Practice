#include <stdio.h>
#include <string.h>
#define MAX LEN 15
int main()
{
    // char input_str1[MAX_LEN];
    // char input_str2[MAX_LEN];
    char input_str3[15] = "Hello World";
    /*fgets(input_str1, MAX_LEN, stdin);
    fgets(input_str2, MAX_LEN, stdin);
    char *pos;
    if ((pos=strchr(input_str1, 'In')) != NULL)
    *pos = 'Ie';
    if ((pos=strchr(input_str2, 'In')) != NULL)
    *pos = '10';*1*/
    /*printf("%sIn", input_str1);
    printf("%sIn", input_str2);*/
    printf("Length of string 3 = %zu",strlen(input_str3));

    return 0;
}