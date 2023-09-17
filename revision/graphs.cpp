#include<iostream>
#include<vector>
#include<queue>
#include<stdlib.h>
#include<cstring>
#include<climits>


using namespace std;

vector<int> bfs(vector<vector<int,int>> adj,int src){
    queue<int> q;
    q.push(src);
    int visited[adj.size()]={0};
    while(!q.empty()){
        int node=q.front();
        q.pop();
        visited[node]=1;
        for(auto i:adj[node]){
            if(!visited[i])
                q.push(i);
        }
    }
}

void dfsHelper(vector<vector<int>> adj, int src,int *vis,vector<int> &out){
    vis[src]=1;
    out.push_back(src);
    for(auto i: adj[src]){
        if(!vis[i])
            dfsHelper(adj,i,vis,out);
    }
}

vector<int> dfs(vector<vector<int>> adj, int src){
    int *vis=(int*)calloc(adj.size(),sizeof(int));
    vector<int> out(adj.size());
    dfsHelper(adj,src,vis,out);
    return out;
}

vector<int> topoSort(vector<int> adj[],int n){
    //Kahn's algorithm to find topological sort for given graph
    //calculate indegree of all vertices
    int ind[n]={0};
    for(int i=0;i<n;i++){
        for(auto j:adj[i]){
            ind[j]+=1;
        }
    }
    //push indegree of 0 to queue
    queue<int> q;
    vector<int> toposort;
    for(int i=0;i<n;i++){
        if(ind[i]==0)
            q.push(i);
    }
    //add neighbours of node which are of 0 indegree
    while(!q.empty()){
        int node = q.front();
        toposort.push_back(node);
        q.pop();
        for(auto i:adj[node]){
            ind[i]-=1;//reduce indegree
            if(ind[i]==0)
                q.push(i);
        }
    }
    return toposort;
}

vector<int> dijkstra(int V,vector<vector<pair<int,int>>> adj, int S){
    priority_queue<pair<int,int> , vector<pair<int,int>> , greater<pair<int,int>>> pq;
    vector<int> dist(V,1e9);
    //push source to priority queue and set distance to 0
    pq.push({0,S});
    dist[S]=0;
    //run dijkstra's algo
    while(!pq.empty()){
        int d=pq.top().first;
        int node= pq.top().second;
        pq.pop();
        for(auto i:adj[node]){
            int neighbour=i.second;
            int distance = i.first;
            //edge relaxation
            if(distance+d<dist[neighbour]){
                dist[neighbour]=distance+d;
                pq.push({distance+d,neighbour});
            }
        }
    }

    return dist;
}
int main(){
    
}