#include <stdio.h>
#include <string.h>
int main() {
    char greeting_msg[25+1] = "hello world";
    printf("%s\n", greeting_msg);
    printf("%d\n", (int)strlen(greeting_msg));
    // greeting_msg = "good morning!"; // This is NOT correct
    strcpy(greeting_msg, "good morning!");
    printf("%s\n", greeting_msg);
    printf("%d\n", (int)strlen(greeting_msg));
    return 0;
}