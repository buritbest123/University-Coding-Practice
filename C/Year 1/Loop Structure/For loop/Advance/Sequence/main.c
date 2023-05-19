#include <stdio.h>
int add (int a, int b) {
    int sum = a + b;
    printf("the result is %d\n\n", sum);
    return sum;
}
int multiply (int v1, int v2) {
    // int result = v1 * v2;
    // return result;
    return v1 * v2;
}
float divide (float a, float b) {
    float results = a / b;
    return results;
    // return a / b;
}
void print_dollar_price(float price) {
    printf("$%.2f\n", price);
}
int main()
{
    float price = 4.567;
    print_dollar_price(price);
    // int output = multiply(5, 4);
    // printf("multiply: %d\n", output);
    printf("multiply: %d\n", multiply(5, 4));
    
    float out_div = divide(5, 2);
    printf("divide: %.2f\n", out_div);
    // printf("divide: %.2f\n", divide(5, 2));
    return 0;
}