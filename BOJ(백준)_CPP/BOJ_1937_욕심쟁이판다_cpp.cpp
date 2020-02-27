#include <bits/stdc++.h>
using namespace std;

struct Point{
    int x,y;
    int idx;
    Point (int x1=0,int y1=0, int idx1=0){
        x = x1;
        y = y1;
        idx = idx1;
    }
};
bool cmp(Point p1,Point p2){
    if(p1.idx<p2.idx){
        return true;
    }
    return false;
}
bool isin(int r, int c,int n){
    return r>=0 && c>=0 && r<n && c<n;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int arr[n][n];
    int dp[n][n];
    int dirs[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    int cmax = 0;
    vector<Point> vp;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> arr[i][j];
            dp[i][j] = 1;
            vp.push_back(Point(i,j,arr[i][j]));
        }
    }
    sort(vp.begin(),vp.end(),cmp);
    
    for(int i=0;i<vp.size();i++){
        int x = vp[i].x;
        int y = vp[i].y;
        int id = vp[i].idx;
        int m=0;
        for(int j=0;j<4;j++){
            int r = x+dirs[j][0];
            int c = y+dirs[j][1];
            if(!isin(r,c,n)){
                continue;
            }
            if(arr[r][c]<id){
                m = max(m,dp[r][c]);
            }
        }
        dp[x][y] = dp[x][y] +  m;
        cmax = max(cmax,dp[x][y]); 
        //cout << vp[i].x << " "<<vp[i].y << " "<<vp[i].idx << " " << dp[x][y] <<"\n";
    }
    cout << cmax;
}