#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
    char word1[20+1];
    char word2[20+1];
    scanf("%s", word1);
    scanf("%s", word2);
    // int i=0;
    // while (word2[i] != '\0') {
    //     // ...
    //     i++;
    // }
    int is_found = 0;
    for (int i=0 ; i<strlen(word2)-strlen(word1)+1 ; i++) {
        // Scan each character until the length of word1
        int count = 0;
        for (int j=0 ; j<strlen(word1) ; j++) {
            // j+i here used to shift the scanning window
            // i can be thought of as the starting point of each window
            if (tolower(word1[j]) == tolower(word2[j+i])) {
                count++;
            }
        }
        // Check the number of matched characters
        if (count == strlen(word1)) {
            // found a match
            is_found = 1;
            printf("found at %d to %d positions\n",
                i,
                i+(int)strlen(word1)-1);
        }
    }
    if (!is_found) {
        printf("not found");
    }
    return 0;
}