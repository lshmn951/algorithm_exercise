#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int tc;
    cin >> tc;
    string str;
    while(tc--){
        cin >> str;
        list<char> list(0);
        auto cur = list.end();
        for(char a:str){
            if(a=='<'){
                if(cur!=list.begin()){
                    cur--;
                }
            }
            else if(a=='>'){
                if(cur!=list.end()){
                    cur++;
                }
            }
            else if(a=='-'){
                if(cur!=list.begin()){
                    cur--;
                    cur = list.erase(cur);
                }
            }
            else{
                list.insert(cur,a);
            }
        }
        for(char a:list){
            cout << a;
        }
        cout << "\n";
    }
   
}