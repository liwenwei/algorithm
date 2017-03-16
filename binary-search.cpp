#include <vector>

using namespace std;

// Given a sorted array and a target value, return the index if the target is found.If not, 
// return the index where it would be if it were inserted in order.
int searchInsert(vector<int>& nums, int target)
{
    int low = 0;
    int high = nums.size();

    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (nums[mid] < target) low = mid + 1;
        else high = mid + 1;
    }

    return low;
}

vector<int> searchRange(vector<int>& nums, int target) 
{

}