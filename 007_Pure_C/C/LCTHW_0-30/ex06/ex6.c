#include <string.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{

    // structs are NOT objects
    // more like just a bunch of variables slapped together
    struct User
    {
        long long id;
        char password[255];
        char username[255];
    } User;

    typedef struct
    {
        long long id;
        char password[255];
        char username[255];
    } UserType;

    struct User jeffery;
    UserType jeff;

    // strcpy can be dangerous may omit the null terminator if dest is longer than src
    strcpy( jeffery.username, "Jeffery123");
    strcpy( jeffery.password, "abcdef");
    jeffery.id = 1442L;

    strcpy( jeff.username, "Jeff123");
    strcpy( jeff.password, "abcdefg");
    jeff.id = 1443L;

    // &jeff - pass the actual address in memory to the function 
    //printBook( &jeff );
    return 0;
};

// TODO requires better understanding of pointers and C syntax. come back later
// void printUser(struct UserType *user ) {
//     // -> is like Object.variable in OOP?
//    printf( "username  : %s\n", user->username);
//    printf( "password  : %s\n", user->password);
// }