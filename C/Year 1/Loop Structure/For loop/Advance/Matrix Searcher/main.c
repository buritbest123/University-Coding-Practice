#include <stdio.h>

#define N 10
#define M 12
int DATA[N][M];
int target; //the given target from the user

void scanArrayData(){
  //////////  Start of your code  //////////
  /*
    TODO: Scan the 2-D array data in here
  */
  for( int i = 0 ; i < N ; i++ )  {
    for( int j = 0 ; j < M ;j ++ )  {
      scanf("%d",&DATA[i][j]);
    }
  }
  //////////  End of your code  //////////
  
}

int match(int t, int v) {

  int ismatch;

  //////////  Start of your code  //////////

  /*
    TODO: Write an algorithm to confirm the match between the target 't' and the value in DATA array 'v'
  */
  if (v==t) {
    ismatch=1;
  }
  else {
    ismatch = 0;
  }
  //////////  End of your code  //////////
  return ismatch;
}

int main() {
  scanArrayData();
  //////////  Start of your code  //////////
    scanf("%d", &target);
  /*
    TODO: Write a program that uses the function match to check the match of the data in the array and the target
      target must be the given global variable 'target'
        You are not allowed to compare the value directly without calling the match function
  */
    for( int i = 0 ; i < N ; i++ ){
    for( int j = 0 ; j < M ; j++ ){
      if( match(target,DATA[i][j])) {
        printf("The target has been found at position[%d %d]\n",i,j);
      }
    }
  }
  
  //////////  End of your code  //////////

  return 0;
}