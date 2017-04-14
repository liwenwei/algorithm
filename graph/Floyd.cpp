#include <vector>
using namespace std;

void MinPath(int start, int end, const vector<vector<int> >& next, vector<int>& path)
{
    path.push_back(start);
    int s = start;
    while (s != end)
    {
        s = next[s][end];
        path.push_back(s);
    }
}

void MinPath(int start, int end,
    const vector<int>& pre, vector<int>& path)
{
    path.push_back(end);
    int e = end;
    while (start != e)
    {
        e = pre[e];
        path.push_back(e);
    }
    reverse(path.begin(), path.end());
}

void Floyd(const vector<vector<int> >& graph, vector<vector<int> >& sp)
{
    sp = graph;
    int size = (int)graph.size();
    int k, i, j;
    for (k = 0; k < size; k++)
    {
        for (i = 0; i < size; i++)
        {
            for (j = 0; j < size; j++)
            {
                if (sp[i][j] > sp[i][k] + sp[k][j])
                {
                    sp[i][j] = sp[i][k] + sp[k][j];
                }
            }
        }
    }
}


void Floyd2(const vector<vector<int> >& graph,
    vector<vector<int> >& sp, vector<vector<int> >& next)
{
    sp = graph;
    int size = (int)graph.size();
    int k, i, j;
    for (i = 0; i < size; i++)
        for (j = 0; j < size; j++)
            next[i][j] = j;	// next

    for (k = 0; k < size; k++)
    {
        for (i = 0; i < size; i++)
        {
            for (j = 0; j < size; j++)
            {
                if (sp[i][j] > sp[i][k] + sp[k][j])
                {
                    sp[i][j] = sp[i][k] + sp[k][j];
                    next[i][j] = next[i][k];
                }
            }
        }
    }
}

void Min_Floyd(const vector<vector<int> >& graph)
{
    int N = (int)graph.size();
    vector<vector<int> > sp(N, vector<int>(N, INT_MAX));	//最短路径的值
    vector<vector<int> > next(N, vector<int>(N, -1));		//直接后继
    Floyd2(graph, sp, next);

    //输出所有结点间的最短路径
    vector<int> path;
    int i, j;
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < N; j++)
        {
            path.clear();
            MinPath(i, j, next, path);
            Print(i, j, sp[i][j], path);
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
    
    Min_Floyd(graph);

    return 0;
}