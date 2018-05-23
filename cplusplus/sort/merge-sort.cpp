#include <algorithm>
using namespace std;

int temp[1024];

void merge(int arr[], int start, int mid, int end)
{
    int i = start;
    int j = mid + 1;
    int size = 0;
    while (i <= mid && j <= end)
        temp[size++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    while (i <= mid)
        temp[size++] = arr[i++];
    while (j <= mid)
        temp[size++] = arr[j++];
    for (i = 0; i < size; i++)
        arr[i + start] = temp[i];
}

void merge_sort_recursive(int arr[], int start, int end)
{
    if (start >= end)
        return;
    int mid = (start + end) / 2;
    merge_sort_recursive(arr, start, mid);
    merge_sort_recursive(arr, mid + 1, end);
    merge(arr, start, mid, end);
}

int main()
{
    int arr[] = { 3, 56, 2, 7, 45, 8, 1 };
    merge_sort_recursive(arr, 0, sizeof(arr) / sizeof(int) - 1);
    return 0;
}