//egg dropping problem
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <chrono>
using namespace std;
int egg_drop(int, int);
int cases = 0;
int dp[1000][1000];
int main()
{
    int n, k;
    //n eggs ,k floors
    cin >> n >> k;
    cout << egg_drop(n, k) << endl;
    cout << "Cases computed=" << cases << endl;
    return 0;
}
int egg_drop(int eggs, int floors)
{
    cases += 1;
    if(floors<=1||eggs==1)
        return floors;
    if (dp[eggs][floors] != 0)
        return dp[eggs][floors];
    int min_attempts = INT_MAX;
    int res = 0;
    for (int i = 1; i <= floors; i++)
    {
        res = max(egg_drop(eggs - 1, i - 1), egg_drop(eggs, floors - i));
        if (res < min_attempts)
            min_attempts = res;
    }
    dp[eggs][floors] = min_attempts + 1;
    return min_attempts + 1;
}