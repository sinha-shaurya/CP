#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int rotOrange(int **grid, int m,int n){
    //count number of oranges
    int count =0;
    queue<pair<int,int>> q;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]!=0)
                count+=1;
            if(grid[i][j]==2)
                q.push({i,j});
        }
    }
    //print queue
    for(int i=0;i<q.size();i++){
        cout<<q.front().first<<q.front().second<<endl;
        q.pop();
    }
    return count;
}

int main(){
    int n=3;
    int m=3;
    // int grid[n][m]={{2,1,1},{1,1,0},{0,1,1}};
    int **grid = new int*[n];
    //add to grid
    for(int i=0;i<n;i++){
        grid[i]=new int[m];
    }
    grid[0]= {2,1,1};
    
    //call rotting oranges function
    cout<<rotOrange(grid)<<endl;
}