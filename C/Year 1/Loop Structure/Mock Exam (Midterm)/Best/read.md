Write a program using nested loop to print out the given pattern of triangle.

The program first asks the user to input the height of the triangle.

Then, the program should check whether the height is **the odd number that greater than zero** or not. If it is not, the program keeps asking the user to re-input. 

Once the program receives the proper height number, the program should print out the triangle based on the example given. The symbols used in this questions are minus (-), plus(+) and star(*). 

For this question, the use of the selection for each case of height is not allowed (see the example of restriction below). You will get **ZERO** if you cannot show the understanding of printing the pattern using nested loop.

**The following is an example of the code that will be graded as a ZERO score (so DO NOT do something like this):**

```
if(height == 1)
  printf("-");
if(height == 3)
  printf("--- \n --+  \n -**");

```

**Case 1**

Sample input:
```
1
```
Sample output:
```
-
+
```

**Case 2**

Sample input:
```
-1
0
-8
2
4
6
3
```
Sample output:
```
---
--+
-**
+++
```

**Case 3**

Sample input:
```
8
7
```
Sample output:
```
-------
------+
-----**
----+++
---****
--+++++
-******
+++++++
```


**Case 4**

Sample input:
```
9
```
Sample output:
```
---------
--------+
-------**
------+++
-----****
----+++++
---******
--+++++++
-********
+++++++++
```