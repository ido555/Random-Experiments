#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

#define MAX_DATA 512
#define MAX_ROWS 100
struct Address {
    int id;
    int set;
    char name[MAX_DATA];
    char email[MAX_DATA];
};

void printAddress(struct Address *address){
    printf("id: %d \t set: %d \t name: %s \t email: %s \t",
     address->id, address->set, address->name, address->email);
};

struct Database {
    struct Address rows[MAX_ROWS];
};

struct Connection {
    // stdio.h file
    FILE *file;
    struct Database *db;
};

void throwErr(const char *message)
{
    // c error library
    if (errno) {
        perror(message);
    // my errors
    } else {
        printf("ERROR: %s\n", message);
    }

    exit(1);
}

void loadDatabase(struct Connection *con){
    // (file read)
    /* fread(
     pointerToRead,
     total size of objects (sizeof(pointerToRead) 
     number of objects to read (1 address)
     file to write to)
     */
    // return value - Number of objects read successfully
    int retCount = fread(con->db, sizeof(struct Database), 1, con->file);
    if (retCount != 1)
        throwErr("Failed to load database");
};

struct Connection *openDatabase(const char *filename, char mode){
    // if malloc fails it returns NULL
    struct Connection *con = malloc(sizeof(struct Connection));
    if(con == NULL)
        throwErr("Memory error");

    con->db = malloc(sizeof(struct Database));
    if (con->db)
        throwErr("Memory error");
};