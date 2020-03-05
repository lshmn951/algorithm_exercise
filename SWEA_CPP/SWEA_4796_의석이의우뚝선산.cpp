#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=1;tc<=T;tc++){
        int n;
        bool up;
        int pre;
        int cur;
        int res=0;
        int ucnt=0;
        int dcnt=0;
        cin >> n;
        cin >> pre >> cur;
        if(pre>cur){
            up = false;
            dcnt++;
        }
        else{
            up = true;
            ucnt++;
        }
        pre = cur;
        n-=2;
        while(n--){
            cin >> cur;
            if(up){
                if(pre<cur){
                    ucnt++;
                }
                else{
                    up = false;
                    dcnt++;
                }
            }
            else{
                if(pre>cur){
                    dcnt++;
                }
                else{
                    up=true;
                    res += ucnt*dcnt;
                    ucnt=1;
                    dcnt=0;
                }
            }
            pre = cur;
        }
        if(dcnt>0){
            res += ucnt*dcnt;
        }
        cout << "#" << tc << " " << res << "\n";
    }
}