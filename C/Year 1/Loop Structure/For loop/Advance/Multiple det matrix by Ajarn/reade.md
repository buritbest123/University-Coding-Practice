Write a program to compute a matrix-vector multiplication.

In particular, the program first accepts the number of rows and columns of an input matrix, and then asks a user to fill in all values:

```
3 4
1 2 3 4
5 6 7 8
9 0 1 2
```

Next, the program asks for an input vector, where its size is the same as the number of columns of the matrix to facilitate the multiplication operation.

```
-1 -1 -1 -1
```

After that it computes the matrix-vector multiplication. The figure below shows an example of how to compute `y[1]`,

![matrix-vector-mul](./example_matvec.png)

```
y[1] = (A[1,0] * x[0]) + 
       (A[1,1] * x[1]) +
       (A[1,2] * x[2]) +
       (A[1,3] * x[3])
```

Finally, the program prints out the results.

```
-10 -26 -12
```

**Case 1**

Sample input:
```
3 4
1 2 3 4
5 6 7 8
9 0 1 2
-1 -1 -1 -1
```

Sample output:
```
-10 -26 -12
```

**Case 2**

Sample input:
```
2 5
5 4 3 2 1
8 7 0 2 1
-1 1 -1 1 -1
```

Sample output:
```
-3 0
```
