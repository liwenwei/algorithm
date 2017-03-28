#include <vector>
#include <algorithm>

using namespace std;

/*
*
* 1. If there is no duplicate element, the answer is simply 2^n
* 2. we are given an array (a1, a2, a3, ..., an) with each of them appearing (k1, k2, k3, ..., kn) times, 
* the number of subset is (k1+1)(k2+1)...(kn+1).
*/
vector<vector<int>> subsetsWithDup(vector<int>& nums)
{
    vector<vector<int>> totalset = { {} };
    for (size_t i = 0; i < nums.size();)
    {
        int total = 0;
        while (total + i < nums.size() && nums[total + i] == nums[i]) total++;
        int previousN = totalset.size();
        for (size_t j = 0; j < previousN; j++)
        {
            vector<int> instance = totalset[j];
            for (size_t k = 0; k < total; k++)
            {
                instance.push_back(nums[i]);
                totalset.push_back(instance);
            }
        }
        i += total;
    }
    return totalset;
}

int main()
{
    vector<int> sums = { 1, 2, 2 };
    vector<vector<int>> results = subsetsWithDup(sums);
}