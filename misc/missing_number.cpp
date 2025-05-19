//given an array of length n which can contain only numbers from [1,n] only, find the missing the missing number and the repeated number
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include<stdio.h>
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
	//one number is missing and other is repeated in array of length n
	//find the missing number and the repeating number
	//let missing number be x and repeated number be y
	double square_sum = 0;
	double sum = 0;
	for (int i = 0; i < n; i++)
	{
		square_sum += pow(a[i], 2);
		sum += a[i];
	}
	double eq1 = (n * (n + 1) / 2) - sum;//x-y
	double eq2 = (((n * (n + 1) * (2 * n + 1)) / 6) - square_sum) / eq1; //x+y
	double x = (eq1 + eq2) / 2.0;
	double y = x - eq1;
	printf("%d %d",x,y);
	return 0;
}
