#include <stdio.h>

// (a,b,\0) - null terminator takes 1 index
// TODO figure out why and how strings longer the specifed buffer do weird stuff?
// DONE explanation (maybe): any chars that would otherwise overflow 'input'
// get stored in some sort of system buffer? and then somehow it keeps "feeding" the 'input'
// buffer until all chars were printed
static char input[4];

int main(int argc, char** argv) {
    /* Print Version and Exit Information */
    puts("bad Lisp Version 0.00001");
    puts("Press Ctrl+c to Exit\n");

    while (1) {
        // fputs = puts - but without a newline
        // string, file stream to write to
        fputs("Lisp but bad> ", stdout);
        
        // user string input, max chars to write, file stream to read from;
        fgets(input, sizeof(input), stdin);

        /* Echo input back to user */
        printf("echo> %s", input);
    }

    return 0;
}