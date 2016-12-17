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

int atoi(string str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if (str.length() == 0) return 0;

    //2. Remove Spaces
    while (str[index] == ' ' && index < str.length())
        index++;

    //3. Handle signs
    if (str[index] == '+' || str[index] == '-'){
        sign = str[index] == '+' ? 1 : -1;
        index++;
    }

    //4. Convert number and avoid overflow
    while (index < str.length()){
        int digit = str[index] - '0';
        if (digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if (INT_MAX / 10 < total || INT_MAX / 10 == total && INT_MAX % 10 < digit)
            return sign == 1 ? INT_MAX : INT_MIN;

        total = 10 * total + digit;
        index++;
    }
    return total * sign;
}

int main()
{
    string s1 = "a";
    string s2 = "";
    cout << strStr(s1, s2) << endl;
}