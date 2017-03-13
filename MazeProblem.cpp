#include <iostream>  
#include <cstdio>  
#include <cstring>  

using namespace std;

int vis[10][10], Map[10][10];
int head, tot;
int dx[4] = { 0, 1, -1, 0 };
int dy[4] = { 1, 0, 0, -1 };

struct node{
    int x;
    int y;
    int pre;
}num[1100];

void print(int n)
{
    if (num[n].pre != -1){
        print(num[n].pre);
        printf("(%d, %d)\n", num[n].x, num[n].y);
    }
    return;
}

void bfs()
{
    //注意区分head和tot,前一个表示每一步，后一个表示有多少种尝试  
    tot = 0;
    head = 0;
    num[tot].x = 0, num[tot].y = 0, num[tot++].pre = -1;
    while (head < tot)
    {
        for (int i = 0; i < 4; i++)
        {
            int m = num[head].x + dx[i];
            int n = num[head].y + dy[i];
            if (m >= 5 || n >= 5 || m < 0 || n < 0 || Map[m][n] == 1)
                continue;
            Map[m][n] = 1;
            num[tot].x = m;
            num[tot].y = n;
            num[tot].pre = head;
            tot++;
            if (m == 4 && n == 4)
                print(head);
        }
        head++;
    }
}


int main()
{
    int maze[5][5] = {
        0, 1, 0, 0, 0,
        0, 1, 0, 1, 0,
        0, 0, 0, 0, 0,
        0, 1, 1, 1, 0,
        0, 0, 0, 1, 0,
    };
    printf("(0, 0)\n");
    bfs();
    printf("(4, 4)\n");
    return 0;
}
