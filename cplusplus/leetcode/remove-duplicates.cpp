#include <vector>

using namespace std;


/*
* Remove Duplicates from Sorted Array II, duplicates are allowed at most twice
*
* For example,
* Given sorted array nums = [1,1,1,2,2,3],
* Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
int removeDuplicates(vector<int>& nums)
{
    if (nums.size() == 0 || nums.size() == 1) return nums.size();

    vector<int> temp;
    for (size_t i = 0; i < nums.size();)
    {
        int count = 0;
        while (count + i < nums.size() && nums[count + i] == nums[i]) count++;
        if (count > 1)
        {
            temp.push_back(nums[i]);
            temp.push_back(nums[i]);
            i += count;
        }
        else
        {
            temp.push_back(nums[i]);
            i++;
        }
    }
    return temp.size();
}

int removeDuplucates1(vector<int>& nums)
{
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i - 2])
            nums[i++] = n;
    return i;
}

int main()
{
    vector<int> nums = { 1, 1, 1, 2 };
    int length = removeDuplicates(nums);
}