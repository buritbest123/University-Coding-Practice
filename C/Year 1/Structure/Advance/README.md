Write your code in the provided sections to complete a program.

This program first recieves two input strings (`name1`, `name2`). Then, it calls function `manage_string`. The function prototype of `manage_string` is provided as follows.

```
int manage_string(char *a1, char *a2);
```

- The `manage_string` function is used to swap the values of two input strings.
- The `manage_string` function is used to count the number of vowels (a, e, i, o and u) occurance found from two input strings. For example: a word 'CheesE' contains 3 vowels occurance (e, e and E) 
- The `manage_string` will return the number of vowels found from two input strings.

Finally, the program prints string in `name1`, `name2`, and the number of vowels found from two input strings.

**Note that**:
- We assume that the number of characters in `name1` and `name2` are less than or equal to 9.
- You can create new variables but cannot delete the exiting variables.
- You are allowed to make use of the built-in functions in `<string.h>` 
- Please read the *TODO* in the provided code.
- You are **NOT** allowed to modify the other parts of the code, except the provided sections. Otherwise, you will get a ZERO score.


**Case 1**

Sample input:`name1`="mickey" and `name2`="MOUSE"
```
mickey
MOUSE
```
Sample output: `name1`="MOUSE", `name2`="mickey" and the number of vowels=5
```
MOUSE
mickey
5
```

**Case 2**

Sample input:`name1`="MARIO" and `name2`="mark"
```
MARIO
mark
```
Sample output: `name1`="mark", `name2`="MARIO" and the number of vowels=4
```
mark
MARIO
4
```

**Case 3**

Sample input:`name1`="xyz" and `name2`="BCD"
```
xyz
BCD
```
xyz
Sample output: `name1`="BCD", `name2`="MARIO" and the number of vowels=0
```
BCD
xyz
0
```