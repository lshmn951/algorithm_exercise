#include <bits/stdc++.h>
using namespace std;

int arr[2000][2000];
bool visit[2000][2000];
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int dirs[2][2] = {{1,0},{0,1}};
    
    int T;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        int n,m;
        cin >> n >> m;
        for(int i=0;i<n;i++){
            string str;
            cin >> str;
            for(int j=0;j<m;j++){
                arr[i][j] = str[j];
                visit[i][j] = false;
            }
        }
        char res[n+m-1];
        queue<pair<int,int>> que;
        que.push({0,0});
        int idx =1;
        res[0] = arr[0][0];
        visit[0][0] = true;
        while(idx<n+m-1){
            queue<pair<int,int>> q;
            int size = que.size();
            char cur = 'z'+1;
            while(size--){
                int x = que.front().first;
                int y = que.front().second;
                que.pop();
                for(int i=0;i<2;i++){
                    int r = x+dirs[i][0];
                    int c = y+dirs[i][1];
                    if(r<n &&c<m &&!visit[r][c]){
                        if(arr[r][c]<cur){
                            while(!q.empty()){
                                q.pop();
                            }
                            cur = arr[r][c];
                            q.push({r,c});
                        }
                        else if(arr[r][c]==cur){
                            q.push({r,c});
                        }
                        visit[r][c] = true;
                    }
                }
            }
            res[idx++] = cur;
            que = q;
        }
        cout << "#" << tc << " "; 
        for(int i=0;i<n+m-1;i++){
            cout << res[i];
        }
        cout << "\n";
    }
}