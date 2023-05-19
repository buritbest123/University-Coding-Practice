Write your code in the provided sections to complete a program.

* This program first receives an input array of size N=5. 
* It then applies the self-defined function, named `float_to_int`, on all elements in the array to transform float to integer data type. 
* It then applies the self-defined function, named `is_prime`, on all elements in the array to identify the prime number.
* It then stores the summation of elements in the array **which are prime numbers** in the `total_value` variable.
* Finally, it prints the `total_value` value.

![alt text](mock_q1.png)

**Note that**: What is prime number?
A prime number is a whole number greater than 1, whose only two whole-number factors are 1 and itself.  The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, and 29.

**IMPORTANT**:
- We assume that the input numbers are float positive data type such as 4.5, 5.2, 7.1.
- You MUST write and use a self-defined function following the function prototype given in the `main.c` including `float_to_int` and `is_prime`. Otherwise, you will get a ZERO score.
- You can create new variables but cannot delete the exiting variables.
- Please read the *TODO* in the provided code.

**Case 1**
Sample input:
```
4.1
2.1
3.5
8.7
3.2
```
Sample output: (2+3+3)
```
8
```

**Case 2**
Sample input:
```
3.5
6.9
7.5
14.2
20.5
```
Sample output: (3+7)
```
10
```

**Case 3**
Sample input:
```
1.7
2.7
3.7
4.7
5.7
```
Sample output: (2+3+5)
```
10
```

