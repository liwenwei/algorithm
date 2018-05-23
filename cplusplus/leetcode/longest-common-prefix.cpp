#include <vector>
#include <string>

using namespace std;

string longestCommonPrefix(vector<string>& strs)
{
    if (strs.size() == 0) return "";
    string pre = strs[0];
    for (size_t i = 0; i < strs.size(); i++)
    {
        while (strs[i].find(pre) != 0)
            pre = pre.substr(0, pre.length() - 1);
    }
    return pre;
}