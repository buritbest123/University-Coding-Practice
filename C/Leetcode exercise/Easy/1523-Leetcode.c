// 1523. Count Odd Numbers in an Interval Range
/*
Given two non-negative integers low and high. 
Return the count of odd numbers between low and high (inclusive).
*/
/*
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
*/

#include <stdio.h>

int countOdds(int low, int high){
   int count = 0;
        if (low % 2 == 1) {
            count++;
        } 
        if (high % 2 == 1) {
            count++;
        } 
    count += high - low;
    count /= 2;   
    return count;
}

int main () {
    int low, high;
        scanf("%d %d", &low , &high);
        printf("%d", countOdds(low, high));
    return 0;
}