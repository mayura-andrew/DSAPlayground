#include<stdio.h>

int gcd(int, int);
int main() {
    printf("Hello World\n");
    int x = gcd(6, 2);
    printf("%d\n", x);
    return 0;
}

int gcd(int a, int b) {
    {while (a > 0){
        if( b > a) {
            int temp = a; a = b; b = temp;
    }
    a -=b;
    }
    return b;
    }
}