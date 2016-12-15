#include <string>
#include <iostream>

using namespace std;

int strStr(string haystack, string needle)
{
    if (needle.length() > haystack.length()) return -1;
    if (haystack == needle) return 0;

    bool isEqual = false;
    for (size_t i = 0; i < haystack.length(); i++)
    {
        int begin = i;
        for (size_t j = 0; j < needle.length(); j++)
        {
            if (needle[j] == haystack[begin])
            {
                isEqual = true;
            }
            else
            {
                isEqual = false;
                break;
            }
            begin++;
        }

        if (isEqual)
        {
            return i;
        }
    }

    return -1;
}

int main()
{
    string s1 = "";
    string s2 = "";
    cout << strStr(s1, s2) << endl;
}