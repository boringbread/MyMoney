#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
    char string[] = "this is sample string";
    char toAppend[] = " to check.";
    
    strcat(string, toAppend);
    
    printf("%s", string);
    return 0;
}
