#include <iostream>  
#include <cstdio>  
#include <cstring>  
#include <queue>

using namespace std;
#define ROW 5
#define COL 5

// 4 neighbours: up, down, left, right
int dx[4] = { 0, 1, -1, 0 };
int dy[4] = { 1, 0, 0, -1 };

struct Point
{
    int x;
    int y;
};

struct node{
    Point point;
    int dist;
};

int bfs(int maze[][COL], Point src, Point dest)
{
    bool visited[ROW][COL];
    memset(visited, false, sizeof visited);

    visited[src.x][src.y] = true;

    queue<node> q;
    node s = { src, 0 };
    q.push(s);

    while (!q.empty())
    {
        node curr = q.front();
        Point pt = curr.point;

        if (pt.x == dest.x && pt.y == dest.y)
            return curr.dist;

        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int row = pt.x + dx[i];
            int col = pt.y + dy[i];
            if ((row <= ROW && col <= COL && row >= 0 && col >= 0) &&
                !visited[row][col] && maze[row][col])
            {
                visited[row][col] = true;
                node adjNode = { { row, col }, curr.dist + 1 };
                q.push(adjNode);
                printf("(%d, %d)\n", row, col);
            }
        }
    }

    return -1;
}

int main()
{
    int maze[ROW][COL] = {
        1, 0, 1, 1, 1,
        1, 0, 1, 0, 1,
        1, 1, 1, 1, 1,
        1, 0, 0, 0, 1,
        1, 1, 1, 1, 1,
    };

    Point src = { 0, 0 };
    Point dest = { 4, 4 };

    int dist = bfs(maze, src, dest);

    cout << "Shortest Path is " << dist << endl;

    return 0;
}
