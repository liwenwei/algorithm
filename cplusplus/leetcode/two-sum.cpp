#include <unordered_map>
#include <vector>


using namespace std;

// tag: hash table

vector<int> twoSum(vector<int> &numbers, int target)
{
    //Key is the number and value is its index in the vector.
    unordered_map<int, int> hash;
    vector<int> result;
    for (size_t i = 0; i < numbers.size(); i++)
    {
        int numToFind = target - numbers[i];

        if (hash.find(numToFind) != hash.end())
        {
            result.push_back(hash[numToFind] + 1);
            result.push_back(i + 1);
            return result;
        }

        hash[numbers[i]] = i;
    }
    return result;
}