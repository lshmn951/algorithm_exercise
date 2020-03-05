#include <bits/stdc++.h>
using namespace std;
struct Micro{
    int num;
    int dir;
};
int n,m,sum;
vector<Micro> arr[100][100];
vector<Micro> arr2[100][100];
int dirs[5][2] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
bool isin(int x,int y){
    return x>0 && y>0 && x<n-1 && y<n-1; 
}
void move(){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j].size()>0){
                int num = arr[i][j].back().num;
                int d = arr[i][j].back().dir;
                int r = i+dirs[d][0];
                int c = j+dirs[d][1];
                arr[i][j].pop_back();
                if(!isin(r,c)){
                    sum -= (num-num/2);
                    num/=2;
                    if(d==1){
                        d=2;
                    }
                    else if(d==2){
                        d=1;
                    }
                    else if(d==3){
                        d=4;
                    }
                    else if(d==4){
                        d=3;
                    }
                    if(num==0){
                        d=0;
                    }
                }
                if(arr2[r][c].size()==0){
                    arr2[r][c].push_back({num,d});
                }
                else{
                    if(arr2[r][c].back().num>num){
                        arr2[r][c].insert(arr2[r][c].begin(),{num,d});
                    }
                    else{
                        arr2[r][c].push_back({num,d});
                    }
                }
            }
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr2[i][j].size()==1){
                arr[i][j].push_back(arr2[i][j].front());
                arr2[i][j].pop_back();
            }
            else if(arr2[i][j].size()>1){
                int num = arr2[i][j].back().num;
                int d = arr2[i][j].back().dir;
                arr2[i][j].pop_back();
                int size = arr2[i][j].size();
                while(size--){
                    num+=arr2[i][j].back().num;
                    arr2[i][j].pop_back();
                }
                arr[i][j].push_back({num,d});
            }
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    int pre=0;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        int k;
        sum = 0;
        for(int i=0;i<pre;i++){
            for(int j=0;j<pre;j++){
                arr[i][j].clear();
                arr2[i][j].clear();
            }
        }
        cin >> n >> m >>k;
        while(k--){
            int r,c,num,d;
            cin >> r >> c >> num >> d;
            arr[r][c].push_back({num,d});
            sum += num;
        }
        while(m--){
            move();
        }
        cout << "#" << tc <<" "<<sum <<"\n";
        pre = n;
    }
}