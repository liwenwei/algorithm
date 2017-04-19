#define _CRT_SECURE_NO_DEPRECATE
#include <cstdio>
#include <vector>
#include <queue>
#include <list>

using namespace std;

void BFS(vector<vector<int> > adjacencyList, int parent[], int level[], int start)
{
    /*
    * we start from node 'start', so node 'start' is at level 0.
    * All immidiate neighbours are at level 1 and so on.
    */
    level[start] = 0;

    queue<int> VertexQueue; // Queue of vertices to be processed

    VertexQueue.push(start);

    while (!VertexQueue.empty())
    {
        int newVertex = VertexQueue.front();
        vector<int>::iterator itr = adjacencyList[newVertex].begin();

        while (itr != adjacencyList[newVertex].end())
        {
            if (level[*itr] == -1)
            {
                level[*itr] = level[newVertex] + 1;
                parent[*itr] = newVertex;
                VertexQueue.push(*itr);
            }
            ++itr;
        }
        VertexQueue.pop();
    }
}

int main2()
{
    const int vertices = 5;
    int edges, v1, v2, weight;

    printf("Enter the number of edges -\n");
    scanf("%d", &edges);

    vector<vector<int> > adjacencyList(vertices + 1);

    printf("Enter the edges V1 -> V2\n");
    for (int i = 0; i < edges; i++)
    {
        scanf("%d%d", &v1, &v2);
        // Adding Edges
        adjacencyList[v1].push_back(v2);
        adjacencyList[v2].push_back(v1);
    }

    printf("\nThe Adjacency List-\n");
    for (int i = 0; i < adjacencyList.size(); i++)
    {
        printf("adjacencyList[%d]", i);

        vector<int>::iterator itr = adjacencyList[i].begin();
        while (itr != adjacencyList[i].end())
        {
            printf(" -> %d", *itr);
            itr++;
        }
        printf("\n");
    }

    int parent[vertices + 1];
    int level[vertices + 1];

    for (int i = 0; i <= vertices; ++i) {
        //Initialising our arrays
        parent[i] = 0;
        level[i] = -1;
    }

    printf("\nEnter the Starting Vertex -\n");
    scanf("%d", &v1);

    BFS(adjacencyList, parent, level, v1);

    //Level Array
    printf("\nLevel and Parent Arrays -\n");
    for (int i = 1; i <= vertices; ++i) {
        printf("Level of Node %d is %d, Parent is %d\n", i, level[i], parent[i]);
    }

    return 0;
}