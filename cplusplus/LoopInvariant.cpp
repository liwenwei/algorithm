#include <iostream>
using namespace std;

/*
* 第一个缺失的整数
* 给定一个数组A[0...N-1]，找到从1开始，第一个不在数组中的正整数
*
* 1.可以使用hashtable，但是time complexity = O(N), auxiliary space = O(n)
*
* 2. 使用循环不变式推导
* 思路：将找到的元素放到正确的位置上，如果最终发现某个元素一直没有找到，则该元素即为所求
* 整理算法描述：
* 若A[i]=i，i+1，继续比较后面的元素
* 若A[i]<i或A[i]>N或A[A[i]] = A[i]，丢弃A[i]
* 若A[i]>i，则将A[A[i]]和A[i]交换
*/

void swap(int& a, int& b)
{
    int temp = a;
    a = b;
    b = temp;
}

int FirstMissNumber(int* nums, int size)
{
    int miss = 1;
    int i = 0;
    while (i < size)
    {
        if (nums[i] <= miss || nums[i] >= size)
        {
            if (nums[i] <= miss)
                miss++;
            i++;
            continue;
        }

        if (nums[nums[i]] != nums[i])
        {
            swap(nums[nums[i]], nums[i]);
        }
        else
        {
            nums[i] = nums[size - 1];
            size--;
        }
    }
    return miss;
}

int main()
{
    int nums[] = { 3, 5, 1, 2, -3, 7, 14, 8 };
    printf("The first missing number is %d:", FirstMissNumber(nums, 8));
}