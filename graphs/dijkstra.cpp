//Find length of shortest path between source and all vertices
// Conditions: No negative edge weights allowed
#include <iostream>
#include <stdio.h>
#include <vector>
#include <queue>
#define inf 1000000
using namespace std;
/**
 * Dijkstra without Priority Queue
 * Runs in O(V^2+E) time
 */
vector<int> shortestPath(int src, vector<pair<int, int>> adj[], int n)
{
    vector<int> dist(n, inf);
    vector<int> p(n, -1);     //to store path
    vector<bool> u(n, false); //store which vertices are visited

    dist[src] = 0; //distance of source from itself
    for (int i = 0; i < n; i++)
    {
        int v = -1;
        //find out the least distant edge among all edges
        //Can be optimised further using priority queue
        for (int j = 0; j < n; j++)
        {
            if (!u[j] && ((v == -1) || dist[j] < dist[v]))
                v = j;
        }
        u[v] = true;
        //edge relaxation for all nodes adjacent to v
        for (auto edge : adj[v])
        {
            int to = edge.first;
            int len = edge.second;
            if (dist[v] + len < dist[to])
            {
                dist[to] = dist[v] + len;
                p[to] = v;
            }
        }
    }
    //print path
    printf("Path from node %d\n", src);
    for (auto &i : p)
    {
        cout << i << " ";
    }
    cout << endl;
    return dist;
}
/**
 * Optimised Dijkstra to using Priority Queue
 * Runs in O((V+E)log V) time
*/
vector<int> dijkstra(int src, vector<pair<int, int>> adj[], int n)
{
    //store dist,node
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;

    vector<int> dist(n, inf);
    vector<int> path(n, -1);
    vector<bool> u(n, true);

    dist[src] = 0;
    q.push({0, src});

    while (!q.empty())
    {
        int d = q.top().first;
        int vertex = q.top().second;
        q.pop();

        //relax edges
        vector<pair<int, int>>::iterator it;
        for (it = adj[vertex].begin(); it != adj[vertex].end(); it++)
        {
            int next=it->first;
            int nextDist=it->second;
            if(dist[next]>dist[vertex]+nextDist)
            {
                dist[next]=dist[vertex]+nextDist;
                q.push({dist[next],next});
            }
        }
    }
    return dist;
}

int main()
{
    int v, e;
    cin >> v >> e;
    vector<pair<int, int>> adj[v];
    for (int i = 0; i < e; i++)
    {
        int m, n, w;
        cin >> m >> n >> w;
        adj[m].push_back({n, w});
    }
    int src;
    cin >> src;
    vector<int> dist = dijkstra(src, adj, v);
    cout << "Distance vector\n";
    for (auto &d : dist)
    {
        cout << d << " ";
    }
    return 0;
}