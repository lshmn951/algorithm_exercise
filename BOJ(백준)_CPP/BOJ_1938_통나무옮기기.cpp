#include <bits/stdc++.h>
using namespace std;

struct Log{
    int x,y;
    int type;
    int cnt;
    Log(int x1=0,int y1=0,int t1=0,int c1=0){
        x = x1;
        y = y1;
        type = t1;
        cnt = c1;
    }
};

int n1;
char arr[50][50];
bool visit[50][50][2];
Log logs[2];
int result = 0;

bool move(int &r,int &c,int &t,int i,int n){
    if(t==0){// |자 모양 통나무
        if(i==0){// 위로
            if(r-2>=0 && arr[r-2][c]=='0'){
                r--;
                return true;
            }
        }
        else if(i==1){//아래
            if(r+2<n && arr[r+2][c]=='0'){
                r++;
                return true;
            }
        }
        else if(i==2){//왼쪽
            if(c-1>=0){
                int num=0;
                for(int j=r-1;j<=r+1;j++){
                    if(arr[j][c-1]=='0'){
                        num++;
                    }
                }
                if(num==3){
                    c--;
                    return true;
                }
            }
        }
        else if(i==3){//오른쪽
            if(c+1<n){
                int num=0;
                for(int j=r-1;j<=r+1;j++){
                    if(arr[j][c+1]=='0'){
                        num++;
                    }
                }
                if(num==3){
                    c++;
                    return true;
                }
            }
        }
        else if(i==4){//회전
            if(c+1<n && c-1>=0){
                int num=0;
                for(int j=r-1;j<=r+1;j++){
                    if(arr[j][c+1]=='0'){
                        num++;
                    }
                    if(arr[j][c-1]=='0'){
                        num++;
                    }
                }
                if(num==6){
                    t = 1;
                    return true;
                }
            }
        }
    }
    else if(t==1){// ㅡ자 모양 통나무
        if(i==0){// 위로
            if(r-1>=0){
                int num=0;
                for(int j=c-1;j<=c+1;j++){
                    if(arr[r-1][j]=='0'){
                        num++;
                    }
                }
                if(num==3){
                    r--;
                    return true;
                }
            }
        }
        else if(i==1){//아래
            if(r+1<n){
                int num=0;
                for(int j=c-1;j<=c+1;j++){
                    if(arr[r+1][j]=='0'){
                        num++;
                    }
                }
                if(num==3){
                    r++;
                    return true;
                }
            }
        }
        else if(i==2){//왼쪽
            if(c-2>=0 && arr[r][c-2]=='0'){
                c--;
                return true;
            }
        }
        else if(i==3){//오른쪽
            if(c+2<n && arr[r][c+2]=='0'){
                c++;
                return true;
            }
        }
        else if(i==4){//회전
            if(r+1<n && r-1>=0){
                int num=0;
                for(int j=c-1;j<=c+1;j++){
                    if(arr[r-1][j]=='0'){
                        num++;
                    }
                    if(arr[r+1][j]=='0'){
                        num++;
                    }
                }
                if(num==6){
                    t = 0;
                    return true;
                }
            }
        }
    }
    return false;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    string str;
    cin >> n1;
    bool bn=true;
    bool en=true;
    for(int i=0;i<n1;i++){
        cin >> str;
        for(int j=0;j<n1;j++){
            arr[i][j] =str[j];
            visit[i][j][0] = false;
            visit[i][j][1] = false;
        }
    }
    for(int i=0;i<n1;i++){
        for(int j=0;j<n1;j++){
            if(arr[i][j]=='B'){
                if(bn){
                    if(arr[i][j+1]=='B'){
                        logs[0] = Log(i,j+1,1,0);
                    }
                    else if(arr[i+1][j]=='B'){
                        logs[0] = Log(i+1,j,0,0);
                    }
                    bn=false;
                }
                arr[i][j]='0';
            }
            if(arr[i][j]=='E'){
                if(en){
                    if(arr[i][j+1]=='E'){
                        logs[1] = Log(i,j+1,1,0);
                    }
                    else if(arr[i+1][j]=='E'){
                        logs[1] = Log(i+1,j,0,0);
                    }
                    en=false;
                }
                arr[i][j]='0';
            }
        }
    }
    queue<Log> que;
    que.push(Log(logs[0].x,logs[0].y,logs[0].type,0));
    visit[logs[0].x][logs[0].y][logs[0].type]=true;
    while(!que.empty()){
        Log temp = que.front();
        que.pop();
        if(temp.x==logs[1].x && temp.y==logs[1].y && temp.type==logs[1].type){
            result = temp.cnt;
            while(!que.empty()){
                que.pop();
            }
        }
        for(int i=0;i<5;i++){
            int r = temp.x;
            int c = temp.y;
            int t = temp.type;
            if(move(r,c,t,i,n1)&&!visit[r][c][t]){
                visit[r][c][t]=true;
                que.push(Log(r,c,t,temp.cnt+1));
            }
        }
    }
    cout << result;
}
//반례https://www.acmicpc.net/board/view/32550