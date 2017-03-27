#include <vector>
#include <string>
#include <deque>

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


/*
*
* FIFO queue
* iterative solution. For each digit added, remove and copy every element in the queue 
* and add the possible letter to each element, then add the updated elements back into queue again. 
* Repeat this procedure until all the digits are iterated.
*/
vector<string> letterCombinations1(string digits)
{
    deque<string> q;
    if (digits.empty()) { return{}; }
    vector<string> mapping{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    q.push_back("");

    for (size_t i = 0; i < digits.size(); i++)
    {
        int x = digits[i] - '0';
        while (q.front().size() == i)
        {
            string t = q.front();
            q.pop_front();
            for (char s : mapping[x])
            {
                q.push_back(t + s);
            }
        }
    }

    vector<string> ans(q.begin(), q.end());
    return ans;
}

int main()
{
    vector<string> results = letterCombinations("123");
}