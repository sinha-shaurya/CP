//brute force solution to coin change problem
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
int dp[100][100];
int change(int amount, int *a, int n)
{
    if (amount == 0)
        return 0;
    int ans = INT_MAX;
    int s = 0;
    for (int i = 0; i < n; i++)
    {
        
        if (amount - a[i] >= 0)
        {
            //printf("%d ", amount);
            /*
            s = change(amount - a[i], a, n);
            if (s + 1 < ans)
                ans = s + 1;
            */
            ans=fmin(ans,1+change(amount-a[i],a,n));
        }
    }
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
    int result = change(amount, a, n);
    printf("\n%d", result);
    return 0;
}