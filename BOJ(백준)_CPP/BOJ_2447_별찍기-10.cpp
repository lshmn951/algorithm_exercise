#include <bits/stdc++.h>
using namespace std;

char arr[2187][2187];

void print(int x,int y,int size){
    if(size==3){
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(i==x+1 &&j==y+1){
                    arr[i][j] = ' ';
                }
                else{
                    arr[i][j] = '*';
                }
            }
        }
        return ;
    }
    for(int i=x;i<x+size;i+=size/3){
        for(int j=y;j<y+size;j+=size/3){
            if(i==x+size/3 &&j==y+size/3){
                   continue;
            }
            else{
                print(i,j,size/3);
            }
        }
    }
}

int main(){
    int n;
    cin >> n;
    print(0,0,n);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]=='*'){
                cout<< '*';
            }
            else{
                cout << ' ';
            }
        }
        cout << "\n";
    }
}