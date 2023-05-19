#include <stdio.h>
int main() {
  int n,m;
  scanf("%d%d", &n, &m);
  int matrixA[n][m];
  for (int i=0;i<n;i++){
    for (int j=0;j<m;j++){
      scanf("%d", &matrixA[i][j]);
    }
  }
  for (int j=0;j<n;j++){
    for (int i=0;i<m;i++){
      printf("%d ", matrixA[i][j]);
    }
    printf("\n");
  }
  return 0;
}