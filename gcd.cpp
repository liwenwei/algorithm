#include <stdio.h>

// Greatest Common Divisor

/* Stardand Function*/
int gcd(int a, int b)
{
    int temp = 0;
    while (a != 0){
        temp = a; a = b%a; b = temp;
    }
    return b;
}

/* Recursive Function */
int gcdr(int a, int b)
{
    if (a == 0) return b;
    return gcdr(b%a, a);
}

int main()
{
    int a, b, c;
    a = 299792458;
    b = 6447287;
    c = 256964964;

    printf("a=%d, b=%d, c=%d\n", a, b, c);

    printf("gcd(a,b)=gcd(%d,%d)=%d\n", a, b, gcd(a, b));
    printf("gcd(a,b)=gcdr(%d,%d)=%d\n", a, b, gcdr(a, b));

    printf("gcd(a,c)=gcd(%d,%d)=%d\n", a, c, gcd(a, c));
    printf("gcd(a,c)=gcdr(%d,%d)=%d\n", a, c, gcdr(a, c));

    printf("gcd(c,b)=gcd(%d,%d)=%d\n", c, b, gcd(c, b));
    printf("gcd(c,b)=gcdr(%d,%d)=%d\n", c, b, gcdr(c, b));

    printf("gcd(a,b,c)=gcd(%d,gcd(%d,%d))=%d\n", a, b, c, gcd(a, gcd(b, c)));
    printf("gcd(a,b,c)=gcdr(%d,gcdr(%d,%d))=%d\n", a, b, c, gcdr(a, gcdr(b, c)));

    return 0;
}