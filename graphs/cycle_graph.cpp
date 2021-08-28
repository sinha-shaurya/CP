//Find cycle in Undirected graph using BFS
#include <iostream>
#include <vector>
#include <queue>
#include<utility>
using namespace std;
const int N = 1e9 + 7;
bool checkCycleBFS(vector<int> adj[], int v, int src);
bool checkCycle(vector<int> adj[], int v)
{
    for (int i = 0; i <v; i++)
    {
        //run BFS for each node
        if (checkCycleBFS(adj, v, i))
            return true;
    }
    return false;
}
bool checkCycleBFS(vector<int> adj[], int v, int src)
{
    vector<bool> visited(v + 1, false); //visited array
    queue<pair<int, int>> q;
    q.push({src, -1});
    visited[src]=true;
    while(!q.empty()){
        int u=q.front().first;
        int parent=q.front().second;//get parent for this node
        q.pop();
        //cout<<u<<parent<<endl;
        //check for adjacent nodes
        for(auto i:adj[u]){
            if(!visited[i]){
                visited[i]=true;
                q.push({i,u});
            }
            else if(i!=parent){
                return true;
            }
        }
    }
    return false;
}
int main()
{
    int v, e;
    cin >> v >> e;
    vector<int> adj[v + 1]; //1 indexed adjacency list
    for (int i = 0; i < e; i++)
    {
        int m, n;
        cin >> m >> n;
        adj[m].push_back(n);
        adj[n].push_back(m);
    }
    cout<<checkCycle(adj,v)<<endl;
    return 0;
}