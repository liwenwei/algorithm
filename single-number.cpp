#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    /*
    * This XOR operation works because it's like XORing all the numbers by itself.
    * So if the array is {2,1,4,5,2,4,1} then it will be like we are performing this operation
    * ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.
    */
    int singleNumber(vector<int>& nums) {
        int result = 0;
        for (auto iter = nums.begin(); iter != nums.end(); iter++)
        {
            result ^= *iter;
        }
        return result;
    }
};

int main()
{
    Solution solution;

    vector<int> nums = { 2, 1, 4, 5, 2, 4, 1 };
    cout << solution.singleNumber(nums);
}