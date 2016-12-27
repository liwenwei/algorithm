
int sum(int n)
{
    if (n <= 2)
        return n;

    return sum(n - 1) + sum(n - 2);
}