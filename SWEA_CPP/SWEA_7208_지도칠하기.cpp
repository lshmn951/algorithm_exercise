#include <bits/stdc++.h>
using namespace std;

int n;
int country[8];
int copyc[8];
int arr[8][8];
int minc = INT32_MAX;

bool check(){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]==1){
                if(copyc[i]==copyc[j]){
                    return false;
                }
            }
        }
    }
    return true;
}

void per(int k,int r){
    if(k==r){
        if(check()){
            int num =0;
            for(int i=0;i<n;i++){
                if(country[i]!=copyc[i]){
                    num++;
                }
            }
            minc = min(minc,num);
        }
        return ;
    }
    for(int i=1;i<=4;i++){
        copyc[k] = i;
        per(k+1,r);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        cin >> n;
        for(int i=0;i<n;i++){
            cin >> country[i];
            copyc[i] = country[i];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin >> arr[i][j];
            }
        }
        minc = INT32_MAX;
        per(0,n);
        cout << "#" << tc << " " << minc <<"\n";
    }
}