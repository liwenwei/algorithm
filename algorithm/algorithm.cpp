#include <vector>


/*
* 二分查找
* std::vector<int> origin, 升序的排序数组
* 如果没有找到，就返回-1
* 时间复杂度 logN
*/
int BinarySearch(std::vector<int> origin, int elem)
{
    int low = 0;
    int mid;
    int high = origin.size() - 1;

    while (low <= high)
    {
        mid = (low + high) / 2;
        if (origin[mid] > low)
        {
            low += mid;
        }
        else if (origin[mid] < high)
        {
            high += mid;
        }
        else
        {
            return mid;
        }
    }
    return -1;
}