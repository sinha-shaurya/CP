//Find number of islands given a matrix of 0(water) and 1s(land)
#include <iostream>
#include <vector>
#include <string.h>
#define MAX 1000
using namespace std;
int visited[MAX][MAX];
int a[MAX][MAX];
void dfs(int m, int n, int i, int j);
int num_islands(int m, int n)
{
    //run DFS from each node

    memset(visited, 0, MAX * MAX * sizeof(int));

    int islands = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (a[i][j] && visited[i][j] != 1)
            {
                
                dfs(m, n, i, j);
                islands += 1;
            }
        }
    }
    return islands;
}

void dfs(int m, int n, int i, int j)
{
    if (i < 0 || i > m || j < 0 || j > n)
        return;
    //check all adjacent of (i,j)
    visited[i][j] = 1;
    int xmove[] = {0, 0, 1, -1};
    int ymove[] = {-1, 1, 0, 0};
    for (int s = 0; s < 4; s++)
    {
        int x = i + xmove[s];
        int y = j + ymove[s];
        if (x >= 0 && x < m && y >= 0 && y < n && (visited[x][y] != 1) && (a[x][y]==1))
            dfs(m, n, x, y);
    }
}
int main()
{
    int m, n;
    cin >> m >> n;

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int x;
            cin >> x;
            a[i][j] = x;
        }
    }
    cout << num_islands(m, n) << endl;
    return 0;
}