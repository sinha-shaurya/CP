//DP solution to coin change problem
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#define MAX 100000
int dp[MAX];
int change(int amount, int *a, int n)
{

    if (n <= 0)
        return -1;
    
    if (dp[amount] != -1)
    {
        return dp[amount];
    }

    if (amount == 0)
        return 0;
    int ans = INT_MAX;
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        //dp is not checked if amount is less than 0, so index is always valid
        if (amount - a[i] >= 0)
        {
            s = change(amount - a[i], a, n);
            if (s + 1 < ans)
                ans = s + 1;
        }
    }
    dp[amount] = ans;
    return ans;
}
int main()
{
    int amount;
    int n;
    scanf("%d %d", &amount, &n);
    int *a = (int *)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    //initialise DP array
    for (int i = 0; i < MAX; i++)
    {
        dp[i] = -1;
    }
    int result = change(amount, a, n);
    if (result == INT_MAX)
        result = -1; //no solution case
    printf("%d", result);
    return 0;
}