#include <algorithm>

using namespace std;

int squareCnt(const int x, const int y)
{
    int count = 0;
    for (int i = 1; i < x; i++)
    {
        for (int j = 1; j < y; j++)
        {
            count += min(i, j);
        }
    }
    return count;
}

int main()
{
    printf("The count of square inside the 19*19 grid is: %d", squareCnt(19, 19));
    return 0;
}
