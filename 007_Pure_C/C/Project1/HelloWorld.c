// some functions including printf
#include <stdio.h>
// C doesn't actually have a boolean type -
// TRUE is 1 and FALSE is 0
// the actual boolean is just a int
#include <stdbool.h>
#define ELEMENTS_IN_1D_ARRAY(a1D)   ( sizeof( a1D       ) / sizeof( a1D[0]          )) // Total no. of elements in 1D array
#define ELEMENTS_IN_2D_ARRAY(a2D)   ( sizeof( a2D       ) / sizeof( a2D[0][0]       )) // Total no. of elements in 2D array
#define ROWS_IN_2D_ARRAY(a2D)       ( sizeof( a2D       ) / sizeof( a2D[0]          )) // No. of Rows in a 2D array
#define COLUMNS_IN_2D_ARRAY(a2D)    ( sizeof( a2D[0]    ) / sizeof( a2D[0][0]       )) // No. of Columns in a 2D array

void HelloWorld()
{
    // imported boolean useage example
    bool isTrue = true;
    if (isTrue)
        printf("Hello, World! True");
    else
        printf("Hello, World! False");

    // newline
    printf("\n");
    short a = 3;
    int b = 4.5;
    float c = 5.25;
    float sum = a + b + c;

    // %f - float
    // %s - string ... etc
    printf("The sum of a, b, and c is %f.", sum);

    // simple array iteration 0-9
    int numbers[10];
    // An array-type is implicitly converted into pointer type when you pass it into a function
    // so the sizeof(numbers) is 40 bytes because each int takes 4 bytes --- (bytes)4*(indexes)10 = 40
    // but a long type will take 8 bytes per index so it would be 8*80
    // sizeof(arr) / sizeof(arr[0]) - solves this problem
    int length = sizeof(numbers) / sizeof(numbers[0]);
    printf("\nint array: [");
    for (int i = 0; i < length; i++)
    {
        numbers[i] = i + 1;
        if (i == length - 1)
        {
            printf("%d", numbers[i]);
            break;
        }
        printf("%d, ", numbers[i]);
    }
    printf("]\n\n");

    // 2d array iteration
    int rect[15][11];
    int x = ROWS_IN_2D_ARRAY(rect);
    int y = COLUMNS_IN_2D_ARRAY(rect);
    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < y; j++)
        {
            rect[j][i] = 0;
            printf("%d", rect[j][i]);
        }
        printf("\n");
    }
}