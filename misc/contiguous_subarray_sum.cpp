//find sum of largest contiguous subarray
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <stdio.h>
#include <climits>
using namespace std;

int main()
{
	// your code goes here4
	int n;
	cin >> n;
	int a[n];
	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	//solution using Kadane's algorithm
	int local_sum = 0;
	int global_sum = INT_MIN; //negative infinity
	for (int i = 0; i < n; i++)
	{
		local_sum = max(a[i], a[i] + local_sum); //if sum is negative then discard
		global_sum = max(local_sum, global_sum);
	}
	printf("%d", global_sum);
	return 0;
}
