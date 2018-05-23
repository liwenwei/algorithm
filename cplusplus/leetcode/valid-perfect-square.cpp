


/*
* Derivation of the formula for sqrt:
* 1  = 1
* 4  = 1 + 3
* 9  = 1 + 3 + 5
* 16 = 1 + 3 + 5 + 7
* 25 = 1 + 3 + 5 + 7 + 9
* ...
* y = 1 + 3 + ... + (2n - 3) + (2n - 1) = n(2n - 1 + 1)/2 = n^2
*
* so a square number is 1+3+5+7+...+(2n-1)
*
* time complexity = O(sqrt(n))
*/
bool isPerfectSquare(int num) {
    int i = 1;
    while (num > 0)
    {
        num -= i;
        i += 2;
    }
    return num == 0;
}

/*
* using binary search
*/
bool isPerfectSquare1(int num) {
    int low = 1, high = num;
    while (low <= high)
    {
        int mid = (low + high) >> 1;
        if (mid*mid == num)
        {
            return true;
        }
        else if (mid*mid > num)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return false;
}

/*
* Integer Newton
* https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
* https://en.wikipedia.org/wiki/Newton%27s_method
*/
bool isPerfectSquare3(int num) {
    long x = num;
    while (x * x > num) {
        x = (x + num / x) >> 1;
    }
    return x * x == num;
}