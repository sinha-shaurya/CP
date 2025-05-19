//Citrix OT problem
//Given an array of length n containing the cost of moves.
//The starting position is index 0.
//You can either take one step or a prime number step ending with 3.
//The task is to calculate the maximum score(addition of costs) to reach the last (n-1)th index
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <string.h>
using namespace std;
int dp[1000];
int moves(int a[], int n, vector<int> primes, int start)
{
    if (start == n - 1)
        return 0;
    if (n <= 0)
        return 0;
    //check answer in dp
    if (dp[start] != -1)
        return dp[start];
    int ans = INT_MIN;
    int s = 0;
    for (int i = 0; i < primes.size(); i++)
    {
        if (start + primes[i] < n) //never go into a branch with no solution
            s = a[start] + moves(a, n, primes, start + primes[i]);
        ans = max(ans, s);
    }
    dp[start] = ans;
    return ans;
}
//utility function for primality test
bool is_prime(int n)
{
    if (n == 1)
        return false;
    int fact = 0;
    for (int i = 1; i <= n; i++)
    {
        if (n % i == 0)
            fact = fact + 1;
    }
    return (fact == 2);
}
int main()
{
    int n;
    cin >> n;
    //input a
    
    int* a=new int[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    
    //generate prime numbers
    vector<int> primes;
    primes.push_back(1);
    //optimise further probably by jumping in leaps of 10
    for (int i = 1; i <= n; i++)
    {
        if ((i % 10 == 3) && (is_prime(i)))
            primes.push_back(i);
    }
    memset(dp, -1, sizeof(dp));
    cout << moves(a, n, primes, 0) << endl;
    for(auto &i:dp){
        if(i!=-1)
            cout<<i<<" ";
    }
    return 0;
}