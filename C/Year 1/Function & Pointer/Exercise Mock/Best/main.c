#include <stdio.h>
#define N 5
float DATA[N];

// ========= Start of your code ========= //
/*
    TODO: Write a function `float_to_int` that returns an integer value of an input number.

    The following is the function prototype
    of the function `float_to_int`.
*/
    int float_to_int(float input){
      int integer_value;
      if(input>=0.0){
        integer_value = input;
      }
      return integer_value;
    }
    
// ========= End of your code ========= //

// ========= Start of your code ========= //
/*
    TODO: Write a function `is_prime` that check whether an input number is prime number or not. 
    TODO: a function return 1 if the input number is a prime number, 0 if the input number is not a prime number.

    The following is the function prototype
    of the function `is_prime`.
*/
  int is_prime(int n){
  int i;
    for(i=2;i<n;i++){
      if( n%i==0 )
      return 0;
    }
      if(i==n)
      return 1;
      return 0;
  }
// ========= End of your code ========= //


int main(void) {
  int total_value=0;
  //Scan the 1-D array data
  for (int i = 0; i < N; i++) {
    scanf("%f",&DATA[i]);  
  }
  // ========= Start of your code ========= //
    /*
        TODO: Apply the `float_to_int` function on
              all elements in the input array. You can create another int array to keep the return output from the `float_to_int` function
    */
    int int_data[N];
    for(int i=0;i<N;i++){
      int_data[i] = float_to_int(DATA[i]);
    }
  // ========= End of your code ========= //


  // ========= Start of your code ========= //
    /*
        TODO: Apply the `is_prime` function on
              all elements in the input array.
        TODO: Calculate the summation of an element that is prime number and store the value in total_value variable.
    */
    for(int i=0;i<N;i++){
      if (is_prime(int_data[i])){
        total_value += int_data[i];
      }
    }
  // ========= End of your code ========= //

  //print total_value
  printf("%d", total_value);
  
  //////////  End of your code  //////////
  
  return 0;
}