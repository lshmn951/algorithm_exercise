#include <bits/stdc++.h>
using namespace std;

int m = INT32_MAX;
int copym[12];

void dfs(int before, int (&arr)[4], int (&month)[12], int temp)
{
    if(before>11){
        m = min(m,temp);
        return ;
    }
    for(int i=0;i<4;i++){
        if(i==0){
            dfs(before+1,arr,month,temp+(month[before]*arr[0]));
        }
        else if(i==1){
            dfs(before+1,arr,month,temp+arr[1]);
        }
        else if(i==2){
            dfs(before+3,arr,month,temp+arr[2]);
        }
        else if(i==3){
            dfs(before+12,arr,month,temp+arr[3]);
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    int arr[4];
    int month[12];
    cin >> T;
    for (int tc = 1; tc <= T; tc++)
    {
        m = INT32_MAX;
        for (int i = 0; i < 4; i++)
        {
            cin >> arr[i];
        }
        for (int i = 0; i < 12; i++)
        {
            cin >> month[i];
        }
        dfs(0, arr, month, 0);
        cout << "#" << tc << " " << m << "\n";
    }
}