// Shortest Path Fisrt

#include <vector>
#include <algorithm>

using namespace std;

#define INFINITY 10000

void Dijkstra(const vector<vector<int>>& graph, int src, vector<int>& spath)
{
    int graphSize = graph.size();
    vector<bool> S(graphSize, false);
    spath = graph[src];

    S[src] = true; // Move src vertex into S vertex set
    spath[src] = 0;

    int k, j, md;
    for (size_t num = 0; num < graphSize; num++) // Find the shortest path for all vertices, move the remind N-1 vertices into S set
    {
        k = -1;  // 候选结点编号
        md = -1; // min distance
        for (size_t j = 0; j < graphSize; j++)
        {
            if (S[j] == false)
            {
                if (md < 0 || md > spath[j])
                {
                    md = spath[j];
                    k = j;
                }
            }
        }

        S[k] = true;
        for (j = 0; j < graphSize; j++)
        {
            if (S[j] == false)
            {
                spath[j] = min(spath[j], spath[k] + graph[k][j]);
            }
        }
    }
}

void Dijkstra(const vector<vector<int>>& graph, int src, vector<int>& spath, vector<int>& pre)
{
    int graphSize = graph.size();
    vector<bool> S(graphSize, false);
    spath = graph[src];

    S[src] = true; // Move src vertex into S vertex set
    spath[src] = 0;

    int k, j, md;
    for (size_t num = 0; num < graphSize; num++) // Find the shortest path for all vertices, move the remind N-1 vertices into S set
    {
        k = -1;  // 候选结点编号
        md = -1; // min distance
        for (size_t j = 0; j < graphSize; j++)
        {
            if (S[j] == false)
            {
                if (md < 0 || md > spath[j])
                {
                    md = spath[j];
                    k = j;
                }
            }
        }

        S[k] = true;
        for (j = 0; j < graphSize; j++)
        {
            if (S[j] == false)
            {
                if (spath[j] > spath[k] + graph[k][j])
                {
                    spath[j] = spath[k] + graph[k][j];
                    pre[j] = k;
                }
            }
        }
    }
}

int main()
{
    const int N = 8;
    vector<vector<int> > graph(N, vector<int>(N, INFINITY));
    graph[0][5] = 24;
    graph[0][2] = 47;
    graph[0][4] = 70;
    graph[1][3] = 31;
    graph[1][6] = 74;
    graph[1][7] = 79;
    graph[2][1] = 55;
    graph[2][3] = 88;
    graph[2][4] = 23;
    graph[2][6] = 66;
    graph[3][7] = 29;
    graph[4][1] = 31;
    graph[4][6] = 42;
    graph[5][2] = 25;
    graph[5][3] = 120;
    graph[6][7] = 66;

    int src = 0;
    vector<int> spath(N);
    vector<int> pre(N, src);
    Dijkstra(graph, 0, spath, pre);
    return 0;
}