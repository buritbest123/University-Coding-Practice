#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main(void)
{   // Ranges for the credit card numbers to be tested for validity (inclusive) and the number of tests to be performed
    long long cardNumber; // This variable is global as it will likely be used in other areas of a larger program.
    do
    {
        printf("Enter your credit card number here: ");
        scanf("%lld", &cardNumber); 
    } while (cardNumber < 1); // This loop will keep asking for a number until the user enters a valid cardNumber.

    int digit, digit_1, digit_2, digit1, digit1_1, digit1_2, sum = 0, sum_1 = 0, sum_total, sum_lastdigit, first2digits, firstdigits;
    // (Group 1) This is the first digit of the credit card number.
    long long credit_num1 = cardNumber / 10; // (Diviide 10) because we need to get the second-to-last digit.
    while (credit_num1 > 0) // This loop will keep going until the credit_num1 is 0.
    {
        digit = credit_num1 % 10; // This will get the last digit of the credit card number.
        credit_num1 /= 100; // It will always shift left 2 digits (Start from last digits). 
        digit = digit * 2; // (Multiply 2) because we need to double the digit, and then check digit in (if statement).
        if (digit > 9) // If the digit is greater than 9, and then seperate the digits.
        {
            digit_1 = digit % 10; // Get the units
            digit /= 10;          
            digit_2 = digit % 10; // Get the tens
            digit = digit_1 + digit_2; // we need to add the digits together.
        }
        sum = sum + digit;
    }
    // (Group2) This is the second digit of the credit card number (no need to /10 at first).
    long long credit_num2 = cardNumber;
    while (credit_num2 > 0) // This loop will keep going until the credit_num2 is 0.
    {
        digit1 = credit_num2 % 10; // This will get the last digit of the credit card number.
        credit_num2 /= 100;        // It will always shift left 2 digits (Start from last digits). 
        if (digit1 > 9)            // Same as Group 1
        {
            digit1_1 = digit1 % 10;
            digit1 /= 10;
            digit1_2 = digit1 % 10;
            digit1 = digit1_1 + digit1_2;
        }
        sum_1 = sum_1 + digit1;
    }

    sum_total = sum + sum_1;         // This is the group sum of the first two digits of the credit card number.
    sum_lastdigit = sum_total % 10;  // sum_lastdigit == 0

    // Card Length Check
    long long creditdigit = cardNumber; 
    int digit_length = 0;
    while (creditdigit != 0)
    {
        creditdigit /= 10;
        digit_length++;
    } // Use digit_length that we count to find firstdigits and first2digits (why pow because it will shift 10++ times depends on digit_length that we count).
    firstdigits = cardNumber / pow(10, digit_length - 1); // This will get the first digit of the credit card number.
    first2digits = cardNumber / pow(10, digit_length - 2); // This will get the first two digits of the credit card number.
    
    // Card Number Check
    if (sum_lastdigit == 0 && digit_length == 15 && (first2digits == 34 || first2digits == 37))
    {
        printf("The number is a valid AMEX card number.\n");
    }
    else if (sum_lastdigit == 0 && digit_length == 16 && (first2digits == 51 || first2digits == 52 || first2digits == 53 || first2digits == 54 || first2digits == 55))
    {
        printf("The number is a valid Mastercard number.\n");
    }
    else if (sum_lastdigit == 0 && (digit_length == 13 || digit_length == 16) && firstdigits == 4)
    {
        printf("The number is a valid Visa card number.\n");
    }
    else
    {
        printf("Invalid");
    }
}