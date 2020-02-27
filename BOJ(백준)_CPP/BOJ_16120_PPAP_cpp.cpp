#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    string str;
    int cnt=0;
    bool b = true;
    cin >> str;
    for(int i=0;i<str.length();i++){
        if(str[i]=='P'){
            cnt++;
        }
        else if(str[i]=='A'){
            if(str[i+1]!='P'){
                b = false;
                break;
            }
            else{
                if(cnt>=2){
                    cnt--;
                    i++;
                }
                else{
                    b = false;
                    break;
                }
            }
        }
    }
    if(cnt>1){
        b = false;
    }
    if(b){
        cout << "PPAP";
    }
    else{
        cout << "NP";
    }
}