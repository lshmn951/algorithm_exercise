#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

   int n;
   cin >> n;
   while(n--){
       string str;
       bool b = false;
       cin >> str;
       stack<char> st;
       for(auto c:str){
           if(c=='('){
               st.push('(');
           }
           else if(c==')'){
               if(st.empty()){
                   cout << "NO"<<"\n";
                   b = true;
                   break;
               }
               else{
                   st.pop();
               }
           }
       }
       if(b){
           continue;
       }
       else{
           if(st.empty()){
               cout << "YES"<<"\n";
           }
           else{
               cout << "NO"<<"\n";
               while(!st.empty()){
                   st.pop();
               }
           }
       }
   }
}