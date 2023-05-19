#include <stdio.h>
/*
return_type function_name(... int x, int y, ...) {
    // c statments
    return ...;
}
*/
float compute_sum(float v1, float v2) {
    return v1+v2;
}
void print_a_value(float v) {
    printf("%.2f", v);
}
int main() {
    float sum = compute_sum(1.5, 2.4);
    float complex_sum = compute_sum(compute_sum(1.5, 2.4), 2.4);
    print_a_value(compute_sum(1.5, 2.4));
    return 0;
}