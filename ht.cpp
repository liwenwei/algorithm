#include <unordered_map>

using namespace std;

unordered_map<char, int> frequency(const char str[])
{
    unordered_map<char, int> freq;
    for (size_t i = 0; str[i]; i++)
    {
        unordered_map<char, int>::iterator iter = freq.find(str[i]);
        if (iter == freq.end())
        {
            freq.emplace(str[i], 1);
        }
        else
        {
            (*iter).second++;
        }
    }

    return freq;
}