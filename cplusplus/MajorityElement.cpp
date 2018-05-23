#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

/*
* The majority element in an arrayA[] of size n is an element that more than n/2 times (and hence
* there is at most one such element )
*
* Find the majority element
* Method 1: Basic
* have two loops and keep track of the maximum count for all different elements\
* Time Complexity: O(n*n)
* Auxiliary Space: O(1)
*
* Method 2: Sort array
* Sort the array, return A[n/2]
* Time Complexity: O(n*logn)
* Auxiliary Space: O(n)
*
* Method 3: Using hash table
* Time Complixity: O(n)
* Auxiliary Space: O(n/2)
*
* Method 4: Using Moore's Voting Algorithm
* Time Complixity: O(n)
* Auxiliary Space: O(1)
**/

// Sort the array ascending, return n/2
int majorityElement1(vector<int> nums)
{
    sort(nums.begin(), nums.end());
    return nums[nums.size() / 2];
}

// Using hash table
int majorityElement2(vector<int> nums)
{
    unordered_map<int, int> map;

    for (size_t i = 0; i < nums.size(); i++)
    {
        unordered_map<int, int>::iterator iter = map.find(nums[i]);
        if (iter == map.end())
        {
            map.emplace(nums[i], 1); // If the num not exsit in the hashtable, init to 1
        }
        else
        {
            if ((*iter).second >= nums.size() / 2)
            {
                return nums[i];
            }
            (*iter).second++; // If the num already exist in the hashtable, count++
        }
    }
    return -1;
}

// Using Moore's Majority Voting Algorithm
int majorityElement3(vector<int> nums)
{
    int candidate = nums[0];
    int counter = 0;
    for (size_t i = 0; i < nums.size(); i++)
    {
        if (counter == 0){
            counter++;
            candidate = nums[i];
        }
        else if (candidate == nums[i]) {
            counter++;
        }
        else {
            counter--;
        }
    }
    return candidate;
}

int main()
{
    vector<int> nums = { 1, 2, 1, 3, 1 };
    printf("Method1: %d\n", majorityElement1(nums));
    printf("Method2: %d\n", majorityElement2(nums));
    printf("Method3: %d\n", majorityElement3(nums));
    return 0;
}