#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int steps = 0;
int dp[1000][1000] = {0};
int length_lps(char *s, int lo, int hi);
int max(int a, int b);
int main()
{
    char s[1000];
    fgets(s, 1000, stdin);
    //remove trailing newline
    s[strcspn(s, "\n")] = 0;
    //initialise dp matrix
    memset(dp, 0, 1000 * 1000 * sizeof(int));
    int len = length_lps(s, 0, strlen(s) - 1);
    printf("Length of longest palindromic substring %d", len);
    printf("\n%d", steps);
    return 0;
}
//utility function to get max
int max(int a, int b)
{
    if (a > b)
        return a;
    else
        return b;
}
//calculate length of longest palindromic substring
int length_lps(char *s, int lo, int hi)
{
    int res;
    steps += 1;
    //base case
    if (lo > hi)
        return 0;
    else if (lo == hi)
        return 1;
    //check if answer is in dp matrix
    if (dp[lo][hi] != 0)
        return dp[lo][hi];
    //case 1 both ends match
    if (s[lo] == s[hi])
        res = 2 + length_lps(s, lo + 1, hi - 1);
    //case 2 both ends do not match
    else
    {
        int left = length_lps(s, lo + 1, hi);
        int right = length_lps(s, lo, hi - 1);
        res = max(left, right);
    }
    //save answer in dp matrix
    dp[lo][hi] = res;
    return res;
}