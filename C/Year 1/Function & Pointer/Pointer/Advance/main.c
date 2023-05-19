#include <stdio.h>
void swap(int *v1, int *v2) {
    int temp = *v1;
    *v1 = *v2;
    *v2 = temp;
}
int compute_sum(int *arr, int size) {
    int sum = 0;
    for (int i=0 ; i<size ; i++) {
        sum += arr[i];
    }
    return sum;
}
float compute_avg(int *arr, int size) {
    float sum = 0;
    for (int i=0 ; i<size ; i++) {
        sum += arr[i];
    }
    return sum / size;
}
int main() {
    int num = 5;
    int *p_num;
    float *p_num2;
    // Point p_num to an integer variable
    p_num = &num;  // & -> get the address
    // Dereference --> access variable 
    // that the pointer is pointing to
    (*p_num)++;
    printf("%d\n", *p_num);
    // Pass-by-reference
    int x = 5, y = 10;
    printf("%d %d\n", x, y);
    swap(&x, &y);
    printf("%d %d\n", x, y);
    // Pointer with array
    int lab_scores[5] = {11,12,13,14,15};
    // Access array elements
    int i;
    for (i=0 ; i<5 ; i++) {
        printf("%d ", *(lab_scores+i));
    }
    printf("\n");
    for (i=0 ; i<5 ; i++) {
        printf("%d ", lab_scores[i]);
    }
    printf("\n");
    // Pass an array into a function
    int sum = compute_sum(lab_scores, 5);
    printf("sum=%d\n", sum);
    float avg = compute_avg(&lab_scores[0], 5);
    printf("%.2f\n", avg);
    // Pass the address of the first element in `lab_scores`
    avg = compute_avg(lab_scores, 5);
    printf("%.2f\n", avg);
    return 0;
}