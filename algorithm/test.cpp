#include <vector>
#include <string>

using namespace std;

bool isAnagram(string s, string t){

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

int main()
{
    vector<int> nums = { 1, 2, 2 };
    removeDuplicates(nums);
}