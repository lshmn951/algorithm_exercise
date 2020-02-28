#include <bits/stdc++.h>
using namespace std;

int result = 0;
int n,m,c;
int arr[10][10];
int res1,res2;

void com(int r,int k,int before,int tmp[5],int sel[5],int &re){
    if(k==r){
        int sum=0;
        int sum2 =0;
        for(int i=0;i<r;i++){
            sum+=sel[i];
            sum2+=sel[i]*sel[i];
        }
        
        if(sum<=c){
            re = max(re,sum2);
        }
        return ;
    }
    for(int i=before;i<m;i++){
        sel[k]=tmp[i];
        com(r,k+1,i+1,tmp,sel,re);
    }
}

void select(int k,int r,int c,int temp1[5],int temp2[5]){
    if(k==2){
        res1=0;
        res2=0;
        for(int i=1;i<=m;i++){
            com(i,0,0,temp1,new int [5],res1);   
        }
        for(int i=1;i<=m;i++){
            com(i,0,0,temp2,new int [5],res2); 
        }
        result = max(result,res1+res2);
    }
    else{
        for(int i=r;i<n;i++){
            for(int j=c;j+m<=n;j++){
                int idx1=0;
                int idx2=0;
                if(k==0){
                    for(int q=j;q<j+m;q++){
                        temp1[idx1++] = arr[i][q];
                    }
                }
                else{
                    for(int q=j;q<j+m;q++){
                        temp2[idx2++] = arr[i][q];
                    }
                }
                select(k+1,i,j+m,temp1,temp2);
            }
            c=0;
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        cin >> n >> m >> c;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin >> arr[i][j];
            }
        }
        result = 0;
        select(0,0,0,new int [5],new int [5]);
        cout << "#" << tc <<" "<<result<<"\n";
    }
}