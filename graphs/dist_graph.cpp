//Algorithm to find shortest distance in Directed Acyclic Graph with weights
#include <iostream>
#include <vector>
#include <utility>
#include <queue>
using namespace std;
const int N = 1e5 + 5;
const int inf = 1e9 + 7;

//Kahn's Algorithm to get the topological sort
vector<int> findTopoSort(vector<pair<int, int>> adj[], int n)
{
    vector<int> topo;
    int *indegree = new int[n + 1];
    //find indegree of all vertices
    for (int i = 0; i < n; i++)
    {
        for (auto v : adj[i])
        {
            indegree[v.first]++;
        }
    }
    queue<int> q;
    for (int i = 0; i < n; i++)
    {
        if (indegree[i] == 0)
            q.push(i);
    }
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        topo.push_back(node);
        for (auto i : adj[node])
        {
            indegree[i.first]--;
            if (indegree[i.first] == 0)
                q.push(i.first);
        }
    }
    return topo;
}

//Find Shortest Path in DAG
int* getShortestPath(vector<pair<int, int>> adj[], int n, int src)
{
    vector<int> topo = findTopoSort(adj, n);
    //initialise array with inf
    int *dist = new int[n];
    for (int i = 0; i < n; i++)
    {
        dist[i] = inf;
    }

    dist[src] = 0;
    //start iterating on the toposort
    for (auto i : topo)
    {
        if (dist[i] != inf)
        {
            for (auto vertex : adj[i])
            {
                if (dist[vertex.first] > dist[i] + vertex.second)
                    dist[vertex.first] = dist[i] + vertex.second;
            }
        }
    }

    return dist;
}
int main()
{
    int v, e;
    //v vertices, e edges
    cin >> v >> e;
    vector<pair<int, int>> adj[v];
    for (int i = 0; i < e; i++)
    {
        int m, n, w;
        cin >> m >> n >> w;
        adj[m].push_back({n, w});
    }
    //find topological sort
    cout << "Topological Sort: ";
    vector<int> topo = findTopoSort(adj, v);
    for (auto &i : topo)
    {
        cout << i << " ";
    }
    int src;
    cin >> src;
    cout << endl;
    cout << "Shortest Path Array: ";
    int *dist = getShortestPath(adj, v, src);
    for (int i = 0; i < v; i++)
    {
        cout << dist[i] << " ";
    }
    cout << endl;
    return 0;
}