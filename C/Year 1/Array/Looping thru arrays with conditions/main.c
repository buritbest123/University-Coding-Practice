#include <stdio.h>
int main(){
int size, sum=0, product=1;
  scanf("%d", &size);
  int n[size];
  for(int i=0;i<size; i++){
    scanf("%d", &n[i]);
  }
  // ถ้า element number is even เอามาบวกกัน และ !ถ้าไม่เอามาคูณกัน
  for(int i=0;i<size; i++){ 
    if(n[i]%2==0){
      sum+=n[i];
    }else{
      product*=n[i];
    }
  }
    printf("%d %d", sum, product);
  return 0;
}