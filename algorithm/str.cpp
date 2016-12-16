#include <string>
#include <iostream>

using namespace std;

int strStr(string haystack, string needle)
{
    if (haystack.length() < needle.length()) return -1;
    if (haystack.length() == needle.length() || needle == "") return 0;

    for (size_t i = 0; i < haystack.length() - needle.length() + 1; i++)
    {
        for (size_t j = 0; j < needle.length(); j++)
        {
            if (needle[j] != haystack[i + j]) break;
            if (j == needle.length() - 1) return i;
        }
    }

    return -1;
}

int main()
{
    string s1 = "a";
    string s2 = "";
    cout << strStr(s1, s2) << endl;
}