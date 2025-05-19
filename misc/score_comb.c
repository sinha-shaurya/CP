//number of ways to reach a score given an array of n integers used to make up that score
//variation of coin change problem
#include <stdio.h>
#include <stdlib.h>
#include<string.h>
int combinations(int n, int *a, int score, int index);
int dp[1000][1000];
int main()
{
  int n;
  int *a;
  int score;
  printf("Enter n and score\n");
  scanf("%d %d", &n, &score);
  a = (int *)malloc(n * sizeof(int));
  for (int i = 0; i < n; i++)
  {
    scanf("%d", (a + i));
  }
  //initialise dp array
  memset(dp,-1,1000*1000*sizeof(int));
  int combs = combinations(n, a, score, 0);
  printf("%d\n", combs);
  return 0;
}

int combinations(int n, int *a, int score, int index)
{
  if (score == 0)
    return 1;
  if (index >= n || score < 0)
    return 0;
  if (dp[index][score] != -1)
    return dp[index][score];
  //case 1: Take element at index
  //case 2: Do not take element at index
  dp[index][score] = combinations(n, a, score - a[index], index) + combinations(n, a, score, index + 1);
  return dp[index][score];
}