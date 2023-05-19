// New Method Function + Pointer 
#include <stdio.h>
int n, m;
int find_min(int *matrix, int n, int m){
  int min = matrix[0];
  int i, j;
  for(i=0;i<n;i++){
    for(j=0;j<m;j++){
      if(*(matrix+i+j)<min){
        return min = *(matrix+i+j);
      }
    }
  }
  return min;
} 
int main(){
    scanf("%d %d", &n, &m);
  int matrix[n][m];
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      scanf("%d", &matrix[i][j]);
    }
  }
  printf("%d", find_min(&matrix[0][0], n, m));
  return 0;
}
/* Original use inly function
#include <stdio.h>
int find_min (int n, int m){
  if(n<=m)
    return n;
    return m;
}
int main(){
  int n, m, i, j, min;
    scanf("%d %d", &n, &m);
  int array[n][m];
  for (int i=0; i<n; i++){
    for (int j=0; j<m; j++){
      scanf("%d", &array[i][j]);
        
        if(i==0 && j==0){
          min = array[0][0];
        }
        else{
          min = find_min(min, array[i][j]);
        }
    }
  }
  printf("%d", min);
  return 0;
}
*/