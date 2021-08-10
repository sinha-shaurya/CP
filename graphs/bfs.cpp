#include<bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;

vector<int> adj[N];
bool visited[N];
int dist[N];

int main()
{
    int n, m;
    int u, v;
    cin >> m >> n; //m is edges,n is nodes
    while (m--)
    {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    //code for BFS
    memset(dist, -1, sizeof(dist));
    memset(visited, 0, sizeof(visited));
    queue<int> q;
    int src;
    //enter BFS source
    cin>>src;
    dist[src] = 0;
    visited[src] = 1;
    q.push(src);
    while (!q.empty())
    {
        u= q.front();
        q.pop();
        for (auto &vertex : adj[u])
        {
            if (dist[vertex]==-1)
            {
                dist[vertex] = dist[u] + 1;
                visited[vertex]=1;
                q.push(vertex);
            }
        }
    }
    for(auto i:dist)
    {
        if(i!=-1)
            cout<<i<<" ";
    }

    return 0;
}