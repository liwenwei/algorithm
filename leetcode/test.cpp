#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;

int lengthOfLongestSubstring(string s)
{
    vector<int> charIndex(256, -1);
    int longest = 0, m = 0;

    for (int i = 0; i < s.length(); i++)
    {
        m = max(charIndex[s[i]] + 1, m);
        charIndex[s[i]] = i;
        longest = max(longest, i - m + 1);
    }

    return longest;
}

bool isAnagram(string s, string t){
    if (s.length() != t.length()) return false;

    unordered_map<char, int> counts;
    for (size_t i = 0; i < s.length(); i++)
    {
        counts[s[i]]++;
        counts[t[i]]--;
    }
    for (auto count : counts)
    {
        if (count.second) return false;
    }

    return true;
}

vector<int> twoSum(vector<int>& numbers, int target)
{
    vector<int> indexVec;

    size_t len = numbers.size();
    if (len < 2) return indexVec;

    for (size_t i = 1; i < len; i++)
    {
        for (size_t j = i + 1; j < len; j++)
        {
            if ((numbers[i] + numbers[j]) == target)
            {
                indexVec.push_back(i + 1);
                indexVec.push_back(j + 1);
                return indexVec;
            }
        }
    }
    return indexVec;
}

vector<int> twoSumBetter(vector<int>& numbers, int target)
{
    vector<int> indexVec;
    size_t len = numbers.size();
    if (len < 2) return indexVec;

    int left = 0, right = len - 1;
    while (left < right)
    {
        int value = numbers[left] + numbers[right];
        if (value == target)
        {
            indexVec.push_back(left + 1);
            indexVec.push_back(right + 1);
            break;
        }
        else if (value > target)
        {
            right--;
        }
        else
        {
            left++;
        }
    }
    return indexVec;
}

int removeDuplicates(vector<int> &nums)
{
    vector<int>::iterator i;
    vector<int>::iterator j;
    for (i = nums.begin(); i != nums.end(); i++)
    {
        int temp = *i;
        for (j = i + 1; j != nums.end(); j++)
        {
            if (temp = *j)
            {
                nums.push_back(temp);
                if (i != nums.end())
                {
                    i++;
                }
            }
        }
    }
    return nums.size();
}