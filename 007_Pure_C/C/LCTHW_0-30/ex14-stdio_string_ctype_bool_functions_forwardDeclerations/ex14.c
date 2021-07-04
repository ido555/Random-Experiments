#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

// forward declarations - declaration of an identifier
// (for function, variable, etc...) for which the programmer has not yet given a complete definition
// required for a compiler to know certain properties of an identifier
bool isValid(char ch);
void print_letters(char str[]);

void print_letters(char str[])
{
    printf("sizeof str is: %d\n", strlen(str));
    for (int i = 0; i < strlen(str); i++)
    {
        if (isValid(str[i]))
        {
            putc(str[i], stdout);
        }
    }
}

bool isValid(char ch)
{
    // ctype used here
    return isalpha(ch) || isblank(ch);
}

int main()
{
    char str[] = "arg1 arg2 hello3";
    print_letters(str);
    return 0;
}