#include <bits/stdc++.h>
using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    int result = 0;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    for (int i = n - 1; i >= 0 && arr[i] > 0; i--)
    {
        if (i - 1 > -1)
        {
            if (arr[i] + arr[i - 1] < arr[i] * arr[i - 1])
            {
                result += arr[i] * arr[i - 1];
                i--;
            }
            else
            {
                result += arr[i];
            }
        }
        else
        {
            result += arr[i];
        }
    }
    for (int i = 0; i < n && arr[i] < 0; i++)
    {
        if (i + 1 < n)
        {
            if (arr[i] + arr[i + 1] < arr[i] * arr[i + 1])
            {
                result += arr[i] * arr[i + 1];
                i++;
            }
            else
            {
                result += arr[i];
            }
        }
        else
        {
            result += arr[i];
        }
    }
    cout << result << "\n";
}