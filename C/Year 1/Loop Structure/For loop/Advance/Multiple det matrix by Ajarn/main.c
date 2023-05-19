#include <stdio.h>
int main() {
    int rows, cols;
    scanf("%d%d", &rows, &cols);
    int mat[rows][cols];
    int vec[cols];
    int out[rows];
    // Fill in values for mat
    for (int i=0 ; i<rows ; i++) {
        for (int j=0 ; j<cols ; j++) {
            scanf("%d", &mat[i][j]);
        }
    }
    // Fill in values for vec
    for (int i=0 ; i<cols ; i++) {
        scanf("%d", &vec[i]);
    }
    for (int i=0 ; i<rows ; i++) {
        out[i] = 0;
        for (int j=0 ; j<cols ; j++) {
            out[i] = out[i] + (mat[i][j] * vec[j]);
        }
    }
    // Print out the results
    for (int i=0 ; i<rows ; i++) {
        printf("%d ", out[i]);
    }
    return 0;
}