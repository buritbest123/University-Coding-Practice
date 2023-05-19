/*#include <stdio.h> 111
int Print_Number(int n){
  scanf("%d", &n);
  return n;
}
int main() {
  int n1;
    printf("The total is :  %d\n", Print_Number(n1));
  return 0;
}*/

/*#include <stdio.h> 222
float find_square(float n){
  scanf("%f", &n);
  float output = n*n;
  return output;
}
int main(){
  float input;
    printf("%.2f", find_square(input));
  return 0;
}*/

/*#include <stdio.h> 333
int swap_number(int n1, int n2){
    printf("Before swapping:n1=%d,n2=%d\n", n1,n2);
    printf("After swapping:n1=%d,n2=%d\n", n2,n1);
    return 0;
}
int main(){
  int num1,num2;
  scanf("%d%d", &num1, &num2);
  swap_number(num1,num2);
  return 0;
}*/

/*#include <stdio.h> 444
int check_even_odd(int n1){
  if(n1%2==0){
    printf("The entered number is even.");
  }else{
    printf("The entered number is odd");
  }
  return 0;
}
int main(){
  int input;
    scanf("%d", &input);
    check_even_odd(input);
  return 0;
}*/

/*#include<stdio.h> 555
void sum_series(int n1, int n2, int n3, int n4 ,int n5){
  int sum = n1+n2+n3+n4+n5;
    printf("The sum of the series is: %d", sum);
}
int main(){
int num1 = 1, num2 = 1, num3 = 2, num4 = 6, num5 = 24;
  sum_series(num1, num2, num3, num4, num5);
  return 0;
}

#include <stdio.h>

int fact(int);
void main()
{
    int sum;
    sum=fact(1)/1+fact(2)/2+fact(3)/3+fact(4)/4+fact(5)/5;
	printf("\n\n Function : find the sum of 1!/1+2!/2+3!/3+4!/4+5!/5 :\n");
	printf("----------------------------------------------------------\n");    
    printf("The sum of the series is : %d\n\n",sum);
}

Exercise-5 with Solution
int fact(int n)
    {
        int num=0,f=1;
        while(num<=n-1)
        {
            f =f+f*num;
            num++;
        }
    return f;
    }*/

/* Haven't solve yet
#include <stdio.h> 666
int 
int main(){

  return 0;
}
*/

/*#include<stdio.h>
int check_prime(int n1);
int main(){
int input;
  scanf("%d", &input);
  check_prime(input);
  if (check_prime(input))
    printf("The number %d is a prime number.", input);
  else 
    printf("The number %d is not a prime number.", input);
  return 0;
}
int check_prime(int n1){
  for (int i=2;i<n1;i++){
    if(n1%i==0)
      return 0;
    }
      return 1;
  }*/

/*Exercise-8 with Solution
#include <stdio.h>
int n,i;
int largest(int arr[], int n);
int main(){
    scanf("%d", &n);
  int array1[n];
  for(i=0;i<n;i++){
    scanf("%d", &array1[i]);
  }
  printf("The largest element in the array is : %d", largest(array1, n));
  return 0;
}
int largest(int arr[], int n)
{
    int i,max = arr[0];
    for (i = 0; i < n; i++){
        if (arr[i] > max)
            max = arr[i];
    }
    return max;
}*/
/*Exercise-12 with Solution
#include <stdio.h>
int find_max(int array1[], int n);
int find_min(int array1[], int n);
int main(){
  int n;
    scanf("%d", &n);
  int array1[n];
  for(int i=0;i<n;i++){
    scanf("%d", &array1[i]);
  }
  printf("Minnimum value is: %d\nMaximum value is: %d",find_min(array1, n), find_max(array1, n));
  return 0;
}
int find_max(int array1[], int n){
  int max = array1[0];
  for(int i=0;i<n;i++){
    if(max<array1[i]){
      max = array1[i];
    }   
  }
  return max;
}
int find_min(int array1[], int n){
  int min = array1[0];
  for(int i=0;i<n;i++){
    if(min>array1[i]){
      min = array1[i];
    }   
  }
  return min;
}*/