#include <iostream>
#include <stdio.h>
#include <vector>
#include <cmath>
#include <string.h>
using namespace std;
int dp[1000][1000];

//start from 0th index solution with DP
int max_profit(int *cost, int *profit, int n, int capacity, int i)
{
    if (i >= n)
        return 0;
    //check if solution exists in dp array
    if (dp[capacity][i] != 0)
        return dp[capacity][i];

    int ans = 0;
    if (cost[i] > capacity)
        ans = max_profit(cost, profit, n, capacity, i + 1);
    else
        ans = max(profit[i] + max_profit(cost, profit, n, capacity - cost[i], i + 1), max_profit(cost, profit, n, capacity, i + 1));
    dp[capacity][i] = ans;
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

    cout << max_profit(cost, profit, n, capacity, 0) << endl;
    return 0;
}