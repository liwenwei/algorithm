// SPFA, shortest path faster algorithm
#include <queue>
using namespace std;

const int N = 7;

/*
* 计算start到其他所有点的最短路径
* N为节点数
*/
void SPFA(int graph[N][N], int N, int* path, int start)
{
    int i;
    for (i = 0; i < N; i++)
        path[i] = 1000000;
    path[start] = 0;

    queue<int> q;
    q.push(0);
    int t, count = 0;
    while (!q.empty())
    {
        t = q.front();
        q.pop();
        for (i = 0; i < N; i++)
        {
            if (graph[t][i] != 0)
            {
                if (path[i] > path[t] + graph[t][i])
                {
                    path[i] = path[t] + graph[t][i];
                    q.push(i);
                }
            }
        }
    }
}

void SPFA1(int graph[N][N], const int* vertex, int N, int* gas, int start)
{
    int i;
    vector<vector<int> > path(N, vector<int>(N));
    for (i = 0; i < N; i++)
    {
        gas[i] = 0;
        path[i][i] = 1;
    }
    gas[start] = vertex[start];


    queue<int> q;
    q.push(0);
    int t;
    int count = 0;
    while (!q.empty())
    {
        t = q.front();
        q.pop();
        for (i = 0; i < N; i++)
        {
            if (graph[t][i] != 0)
            {
                if (gas[t] >= graph[t][i])	//保证能够有足够多的汽油到达i点
                {
                    if ((path[t][i] == 0) && (gas[i] < gas[t] - graph[t][i] + vertex[i]))	//到t的路径中没有出现过i，且经过t的汽油量能够剩余更多
                    {
                        gas[i] = gas[t] - graph[t][i] + vertex[i];
                        q.push(i);

                        path[i] = path[t];
                        path[i][i] = 1;
                    }
                }
            }
        }
    }
}

int main()
{
    int graph[N][N] = { 0 };
    graph[0][1] = 4;
    graph[0][2] = 3;
    graph[0][3] = 5;
    graph[1][0] = 4;
    graph[1][2] = 2;
    graph[1][4] = 3;
    graph[2][0] = 3;
    graph[2][1] = 2;
    graph[2][4] = 4;
    graph[3][0] = 5;
    graph[3][4] = 3;
    graph[3][5] = 2;
    graph[4][1] = 3;
    graph[4][2] = 4;
    graph[4][3] = 3;
    graph[4][5] = 5;
    graph[4][6] = 6;
    graph[5][3] = 2;
    graph[5][4] = 5;
    graph[5][6] = 7;
    graph[6][4] = 6;
    graph[6][5] = 7;
    int vertex[] = { 7, 5, 4, 3, 4, 7, 0 };

    int start = 0;	//起点
    int path[N];	//最短路的值
    SPFA(graph, N, path, start);
}