#include <bits/stdc++.h>
using namespace std;

struct Hero{
    int x,y;
    int s;
    int cnt;
    Hero(int x,int y,int s,int cnt){
        this->x = x;
        this->y = y;
        this->s = s;
        this->cnt = cnt;
    }  
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n,m,t;
    int arr[100][100];
    bool visit[100][100][2];
    int dirs[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    int res=0;
    cin >> n >> m >> t;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> arr[i][j];
        }
    }
    queue< Hero > que;
    que.push(Hero(0,0,0,0));
    while(!que.empty()){
        int x = que.front().x;
        int y = que.front().y;
        int cnt = que.front().cnt;
        int s = que.front().s;
        que.pop();
        if(x==n-1 && y==m-1 && cnt<=t){
            res = cnt;
            break;
        }
        for(int i=0;i<4;i++){
            int r = x+dirs[i][0];
            int c = y+dirs[i][1];
            if(r<0 || c<0 || r>=n || c>=m){
                continue;
            }
            if(s==0){
                if(arr[r][c]==2 && !visit[r][c][s]){
                    visit[r][c][s] = true;
                    que.push(Hero(r,c,1,cnt+1));
                }
                else if(arr[r][c]==0 && !visit[r][c][s]){
                    visit[r][c][s] = true;
                    que.push(Hero(r,c,0,cnt+1));
                }
            }
            else{
                if(arr[r][c]!=2 && !visit[r][c][s]){
                    visit[r][c][s] = true;
                    que.push(Hero(r,c,s,cnt+1));
                }
            }
        }
    }
    if(res==0){
        cout << "Fail";
    }
    else{
        cout << res;
    }
}