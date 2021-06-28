//efficiently merge 2 sorted arrays
//this solution takes O(n) space and O(n) time
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
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
    int m, n;
    cin >> m >> n;
    int a[m], b[n];
    cout << "Enter" << m << " elements" << endl;
    for (int i = 0; i < m; i++)
    {
        int x;
        cin >> x;
        a[i] = x;
    }
    cout << "Enter" << n << " elements" << endl;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        b[i] = x;
    }

    //main logic
    int aux[m + n];
    int i = 0, j = 0, k = 0;
    while ((i < m) && (j < n))
    {
        if (a[i] <= b[j])
            aux[k++] = a[i++];
        else
            aux[k++] = b[j++];
    }
    while (i < m)
    {
        aux[k++] = a[i++];
    }

    while (j < n)
    {
        aux[k++] = b[i++];
    }
    display(aux, m + n);
    //split back
    for (i = 0; i < m; i++)
    {
        a[i] = aux[i];
    }
    j=0;
    for (; i < (m + n); i++)
    {
        b[j++] = aux[i];
    }
    display(a, m);
    display(b, n);
    return 0;
}