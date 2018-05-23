#include <vector>

using namespace std;

/*
* Plateau Array(高原数组):
*
* 定义：
* 若子数组A[from,...,to]满足以下条件：
* - A[from] > A[from - 1];
* - A[to] > A[to + 1];
* 则称该数组为高原数组，通常用在求一个数组的局部最大；
*
*/


/*
* The local maximum of the array
*
* 使用索引left、right分别指向数组首尾，根据定义，该数组为高原数组
*  1. 求中点 mid = (left + right)/2
*  2. 如果 A[mid] > A[mid+1]，则子数组A[left...mid]为高原数组，因此舍弃后半段，令 right=mid
*  3. 如果 A[mid+1] > A[mid]，则子数组A[mid...right]为高原数组，因此舍弃前半段，令 left=mid+1
* 重复上诉过程，递归直至left==right
*/
int localMaximum(const int* nums, int size)
{
    int left = 0;
    int right = size - 1;
    int mid;
    while (left < right)
    {
        mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1])
            right = mid;
        else
            left = mid + 1;
    }
    return nums[left];
}

int main()
{
    int nums[] = { 6, 7, 4, 8, 3, 5, 9 };
    printf("The local maximum of the array from 0 to 5 is %d", localMaximum(nums, 6));
}