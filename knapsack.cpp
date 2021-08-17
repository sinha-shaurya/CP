#include <iostream>
#include <stdio.h>
#include <vector>
#include <cmath>
#include <string.h>
using namespace std;
int dp[1000][1000];

//start from last index
int max_profit(int *cost, int *profit, int n, int capacity)
{
    if (n == 0 || capacity == 0)
        return 0;
    //check if solution exists in dp array
    if (dp[capacity][n] != 0)
        return dp[capacity][n];

    int ans = 0;
    if (cost[n - 1] > capacity)
        ans = max_profit(cost, profit, n, capacity);
    else
        ans = max(profit[n - 1] + max_profit(cost, profit, n - 1, capacity - cost[n - 1]), max_profit(cost, profit, n - 1, capacity));
    dp[capacity][n] = ans;
    return ans;
}

void display(int *a, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << *(a + i) << " ";
    }
    cout << "\n";
}
int main()
{
    int n;
    cin >> n;
    int *cost = new int[n];
    int *profit = new int[n];
    for (int i = 0; i < n; i++)
        cin >> cost[i];
    for (int i = 0; i < n; i++)
        cin >> profit[i];
    int capacity;
    cin >> capacity;
    //setup dp array
    memset(dp, 0, 1000 * 1000 * sizeof(int));
    cout << max_profit(cost, profit, n, capacity) << endl;
    return 0;
}