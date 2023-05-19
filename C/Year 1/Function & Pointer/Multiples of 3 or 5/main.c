#include <stdio.h>
int i;
int Multiple_3_5(int number_below){
  int sum = 0;
  for(i=1;i<number_below;i++){
    if ( i%15 == 0 ){
      sum += i;
    }else if ( i%3 == 0 ){
      sum += i;
    }else if ( i%5 == 0 ){
      sum += i;
    }
  }
 return sum;
}
int main() {
    printf("%d", Multiple_3_5(1000));
  return 0;
}