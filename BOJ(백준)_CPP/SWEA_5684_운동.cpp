#include <bits/stdc++.h>
using namespace std;

int n,m;
struct comp{
    bool operator()(pair<int,int> p1,pair<int,int> p2){
        return p1.second>p2.second;
    }
};
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        cin >> n >> m;
        vector<vector<pair<int,int > > > build(n+1);
        bool visit[n+1];
        while(m--){
            int s,e,c;
            cin >> s >> e >> c;
            build[s].push_back({e,c});
        }
        
        int res=INT32_MAX;
        for(int start=1;start<=n;start++){
            priority_queue<pair<int,int>,vector<pair<int,int>>,comp> que;
            int dist[n+1];
            fill(dist,dist+n+1,INT32_MAX);
            for(int i=0;i<build[start].size();i++){
                que.push({build[start][i].first,build[start][i].second});
                dist[build[start][i].first] = build[start][i].second;
            }
            while(!que.empty()){
                int v = que.top().first;
                int d = que.top().second;
                que.pop();
                if(v==start){
                    break;
                }
                if(d>dist[v]){
                    continue;
                }
                for(int i=0;i<build[v].size();i++){
                    int temp1 = build[v][i].first;
                    int temp2 = build[v][i].second;
                    if(dist[temp1]>temp2+dist[v]){
                        dist[temp1] = temp2+ dist[v];
                        que.push({temp1,temp2});
                    }
                }
            }
            res = res>dist[start]?dist[start]:res;
        }
        cout << "#" << tc <<" ";
        if(res==INT32_MAX){
            cout << -1 << "\n";
        }
        else {
            cout << res << "\n";
        }
    }
}