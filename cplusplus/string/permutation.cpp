/* string full arrangement */

#include <iostream>

using namespace std;

void print(const int* a, int size)
{
    for (size_t i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl;
}

bool isDuplicate(const int* a, int n, int t)
{
    while (n < t)
    {
        if (a[n] == a[t])
            return false;
        n++;
    }
    return true;
}

void Reverse(int* from, int* to)
{
    int temp;
    while (from < to)
    {
        temp = *from;
        *from = *to;
        *to = temp;
        from++;
        to--;
    }
}

void permutation(int* a, int size, int n)
{
    if (n == size - 1)
    {
        print(a, size);
    }
    for (size_t i = n; i < size; i++)
    {
        if (isDuplicate(a, n, i)) continue; // a[i]是否与[n,i)重复
        swap(a[i], a[n]);
        permutation(a, size, n + 1);
        swap(a[i], a[n]);
    }
}

void permutation1(int* a, int size, int n)
{
    if (n == size - 1) print(a, size);
    // using hashtable if the size is large
    int dup[256] = { 0 }; // define a array to store all digits
    for (size_t i = n; i < size; i++)
    {
        if (dup[a[i]] == 1) continue;
        dup[a[i]] == 1;
        swap(a[i], a[n]);
        permutation1(a, size, n + 1);
        swap(a[i], a[n]);
    }
}

bool next_permutation(int* a, int size)
{
    // 后找
    int i = size - 2;
    while ((i >= 0) && (a[i] >= a[i + 1]))
        i--;
    if (i < 0)
        return false;

    // 从大的数字中找到最小的
    int j = size - 1;
    while (a[j] <= a[i])
        j--;

    // 交换
    swap(a[j], a[i]);

    // 翻转
    Reverse(a + i + 1, a + size - 1);
    return true;
}

int main()
{
    int a[] = { 1, 2, 3, 4 };
    permutation(a, sizeof(a) / sizeof(int), 0);
    return 0;
}