#include <vector>
#include <string>

using namespace std;

// tags: backtracing method

/*
* iterative solution
* The time complexity is too high compared to the backtracking method because 
* for each digit you must traverse the vector reuslt
*/
vector<string> letterCombinations(string digits)
{
    vector<string> result;
    result.push_back("");
    string mapping[10] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    for (size_t i = 0; i < digits.size(); i++)
    {
        vector<string> temp;
        string chars = mapping[digits[i] - '0'];
        for (size_t j = 0; j < chars.size(); j++)
        {
            for (size_t k = 0; k < result.size(); k++)
            {
                temp.push_back(result[k] + chars[j]);
            }
        }
        result = temp;
    }
    return result;
}

int main()
{
    vector<string> results = letterCombinations("123");
}