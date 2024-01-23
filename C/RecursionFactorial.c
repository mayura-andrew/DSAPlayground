#include<stdio.h>


int fact(int);
int main() {
    int n;
    n = fact(5);
    printf("%d\n", n);
    printf("%d\n", fact(5));
    return 0;
}
int fact(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * fact(n-1);
    }
}
