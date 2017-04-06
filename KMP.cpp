#include <string>

using namespace std;

/*
* Brute Force
* Time complexity = O(m*n)
*/
int BruteForceSearch(const char* str, const char* pattern)
{
    int i = 0;
    int j = 0;
    int size = strlen(pattern);
    int last = strlen(str) - size;
    while (j < size && i <= last)
    {
        if (pattern[j] == str[i + j])
        {
            j++;
        }
        else
        {
            j = 0;
            i++;
        }
    }

    if (j >= size) return i;
    return -1;
}

int BruteForceSearch1(const char* str, const char* pattern)
{
    int str_len = strlen(str);
    int pat_len = strlen(pattern);
    int index = -1;
    for (size_t i = 0; i <= str_len - pat_len; i++)
    {
        for (size_t j = 0; j <= pat_len; j++)
        {
            if (pattern[j] == str[i + j])
            {
                if (j == pat_len - 1)
                {
                    return i;
                }
            }
            else
            {
                break;
            }
        }
    }

    return -1;
}

void GetNext(const char* p, int next[])
{
    int nLen = (int)strlen(p);
    next[0] = -1;
    int k = -1;
    int j = 0;
    while (j < nLen - 1)
    {
        // 此刻，k即next[j-i]，且p[k]表示前缀，p[j]表示后缀
        // 备注：k==-1表示为找到k前缀与k后缀相等，首次分析可先忽略
        if (k == -1 || p[j] == p[k])
        {
            ++j;
            ++k;
            next[j] = k;
        }
        else // p[j]与p[k]失配，则继续递归计算前缀p[next[k]]
        {
            k = next[k];
        }
    }
}

int KMP(const char* p)
{
    int nLen = (int)strlen(p);
    if (nLen == 0)
        return -1;
    int* next = new int[nLen];	//仿照KMP求"伪next"
    next[0] = -1;	//哨兵：串首标志
    int k = -1;
    int j = 0;
    while (j < nLen - 1)
    {
        if ((k == -1) || (p[j + 1] == p[k]))
        {
            ++k;
            ++j;
            next[j] = k;
        }
        else
        {
            k = next[k];
        }
    }
    next[0] = 0;	//恢复成逻辑上的0

    int nLast = next[nLen - 1];
    delete[] next;
    if (nLast == 0)
        return -1;
    if (nLen % (nLen - nLast) == 0)
        return nLen - nLast;
    return -1;
}

int main()
{
    char* str = "liwenwei";
    char* pattern = "ei";
    printf("BruteForceSearch: %d\n", BruteForceSearch(str, pattern));
    printf("BruteForceSearch1: %d\n", BruteForceSearch1(str, pattern));
}