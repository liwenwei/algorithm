#include <iostream>
#include <string>

using namespace std;

/*
* Reverse part of string
* Given a string "abcdef", n = 2, output "cdefab"
*/

/*
* 暴力位移法，每次循环左移1位，调用k次即可
* time complexity = O(kn), space complexity = O(1)
*/

/*
* 三次拷贝
* S[0..k] -> T[0..k]
* S[k+1..N-1] -> S[0..N-k-1]
* T[0..K] -> S[N-K..N-1]
* time complexity = O(N), space complexity = O(K)
*/


/*
* Transpose matrix
* (AB)' = B'A'
* like abcdef
* X=ab   X'=ba
* Y=cdef Y'=fedc
* (X'Y')=(bafedc)'=cdefab
*/
void reverseStr(char* str, int from, int to)
{
    while (from < to)
    {
        char temp = str[from];
        str[from++] = str[to];
        str[to--] = temp;
    }
}

void leftRotateStr(char* str, int m, int n)
{
    reverseStr(str, 0, m - 1);
    reverseStr(str, m, n - 1);
    reverseStr(str, 0, n - 1);
}

int main()
{
    string str = "abcdef";
    leftRotateStr(&str[0], 2, 6);
    cout << str << endl;
}