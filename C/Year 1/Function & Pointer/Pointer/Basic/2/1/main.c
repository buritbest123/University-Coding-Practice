#include <stdio.h>
int main() {
    int num = 5;
    // Create a pointer that will point to an int
    int *p_num;
    // Point `p_num` to `num`
    p_num = &num;
    printf("%d\n", *p_num);
    // Change `num` to 15
    num = 15;
    printf("%d\n", *p_num);
    // Change the value of the address in `p_num`
    *p_num = 42;
    printf("%d\n", num);
    printf("%d\n", *p_num);
    int num2 = 13;
    // Point `p_num` to `num2`
    p_num = &num2;
    printf("%d\n", *p_num);
    printf("%d\n", num);
    // Change the value of the address in `p_num`
    *p_num = 0;
    printf("%d\n", num);
    printf("%d\n", num2);
    // Print out the address
    printf("%p\n", p_num);
    printf("%p\n", &num2);
    printf("%p\n", &num);
    return 0;
}