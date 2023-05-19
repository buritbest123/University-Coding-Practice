#include <stdio.h>
void some_function(int a, int b) {
    printf("b4: %d %d\n", a, b);
    a = 9;
    b = 12;
    printf("af: %d %d\n", a, b);
}
void some_function_ref(int a, int *b) {
    printf("b4-r: %d %d\n", a, *b);
    a = 9;
    *b = 12;
    int sum = a + *b;
    printf("at-r: %d %d\n", a, *b);
}
int main() {
    int v1 = 5, v2 = 8;
    printf("0: v1=%d v2=%d\n", v1, v2);
    some_function(v1, v2);
    printf("1: v1=%d v2=%d\n", v1, v2);
    some_function_ref(v1, &v2);
    printf("2: v1=%d v2=%d\n", v1, v2);
    return 0;
}