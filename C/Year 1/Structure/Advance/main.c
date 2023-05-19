#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LEN 20

int manage_string(char *a1, char *a2){
    //TODO: swap string in a1 and a2
    //TODO: count and return total vowels (including both uppercase and lowercase)
    //vowels are a, e, i, o, u in English
    char temp[MAX_LEN];
    strcpy(temp, a1);
    strcpy(a1, a2);
    strcpy(a2,temp);
    
    int count = 0;
    for(int i=0; i<a1[i];i++){
        if((a1[i] == 'A' || a1[i] == 'E') || (a1[i] == 'I' || a1[i] == 'O') || (a1[i] == 'U')){
          count++;
        }
        if((a1[i] == 'a' || a1[i] == 'e') || (a1[i] == 'i' || a1[i] == 'o') || (a1[i] == 'u')){
          count++;
        }
    }
    for(int j=0; j<a2[j];j++){
         if((a2[j] == 'A' || a2[j] == 'E') || (a2[j] == 'I' || a2[j] == 'O') || (a2[j] == 'U')){
          count++;
        }
        if((a2[j] == 'a' || a2[j] == 'e') || (a2[j] == 'i' || a2[j] == 'o') || (a2[j] == 'u')){
          count++;
        }
    }
    return count;
}

int main()
{
    char name1[MAX_LEN], name2[MAX_LEN];
    int num_vowels = 0;
    scanf("%s",name1);
    scanf("%s",name2);
    ///// Start of you code /////
    // call function manage_string 
    num_vowels = manage_string(name1, name2);
    // TODO: print string in name1, name2
    printf("%s\n%s\n",name1, name2);
    // TODO: print the number of vowels in name1 and name2 that return from manage_string function
    printf("%d", num_vowels);
    ///// End of you code /////

    return 0;
}