#include <bits/stdc++.h>
using namespace std;

int r,c;
string str;
char block[7] = {'|','-','+','1','2','3','4'};
char bmap[26][26];
int sd[2][2];
bool check(int ,int , char, int);
bool isin(int,int);
bool sdcheck();
bool b;
int r2=0,c2=0;
char ch;
int main(){

    cin >> r >> c;

    for(int i=1;i<=r;i++){
        cin >> str;
        for(int j=1;j<=c;j++){
            bmap[i][j] = str[j-1];
            if(bmap[i][j]=='M'){
                sd[0][0] = i;
                sd[0][1] = j;
            }
            if(bmap[i][j]=='Z'){
                sd[1][0] = i;
                sd[1][1] = j;
            }
        }
    }
    
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            if(bmap[i][j]!='.'&&bmap[i][j]!='M'&&bmap[i][j]!='Z'){
                check(i,j,bmap[i][j],0);
                if(r2!=0){
                    i = r+2;
                    break;
                }
            }
        }
    }
    cout << r2 << " "<< c2 << " "<< ch;
}

bool check(int x,int y,char c,int depth){
//    cout << x <<" " << y <<" "<< c <<" "<< depth <<"\n";
    if(depth>1){
        return false;
    }
    if(c=='|' || c=='+' || c=='2' || c=='3'){
    if(isin(x-1,y) && bmap[x-1][y]=='.'){
         for(int i=0;i<7;i++){
            if(check(x-1,y,block[i],depth+1)){
                bmap[x-1][y] = block[i];
                if(sdcheck()){
                    r2 = x-1;
                    c2 = y;
                    ch = block[i];
                }
            }
        }
        return false;
    }
    else if(isin(x-1,y) && bmap[x-1][y]=='-'||bmap[x-1][y]=='2'||bmap[x-1][y]=='3'){
        return false;
    }
    }
    if(c=='|' || c=='+' || c=='1' || c=='4'){
    if(isin(x+1,y) && bmap[x+1][y]=='.'){
        for(int i=0;i<7;i++){
            if(check(x+1,y,block[i],depth+1)){
                bmap[x+1][y] = block[i];
                if(sdcheck()){
                    r2 = x+1;
                    c2 = y;
                    ch = block[i];
                }
            }
        }
        return false;
    }
    else if(isin(x+1,y) &&bmap[x+1][y]=='-'||bmap[x+1][y]=='1'||bmap[x+1][y]=='4'){
        return false;
    }
    }
    if(c=='-' || c=='+' || c=='3' || c=='4'){
    if(isin(x,y-1) && bmap[x][y-1]=='.'){
        for(int i=0;i<7;i++){
            if(check(x,y-1,block[i],depth+1)){
                bmap[x][y-1] = block[i];
                 
                if(sdcheck()){
                    r2 = x;
                    c2 = y-1;
                    ch = block[i];
                }
            }
        }
        return false;
    }
    else if(isin(x,y-1) && bmap[x][y-1]=='|'||bmap[x][y-1]=='3'||bmap[x][y-1]=='4'){
        return false;
    }
    }
    if(c=='-' || c=='+' || c=='2' || c=='1'){
    if(isin(x,y+1) && bmap[x][y+1]=='.'){
        for(int i=0;i<7;i++){
            if(check(x,y+1,block[i],depth+1)){
                bmap[x][y+1] = block[i];
                if(sdcheck()){
                    r2 = x;
                    c2 = y+1;
                    ch = block[i];
                }
            }
        }
        return false;
    }
    else if(isin(x,y+1) &&bmap[x][y+1]=='|'||bmap[x][y+1]=='2'||bmap[x][y+1]=='1'){
        return false;
    }
    }
    if(c=='|'){
        if(isin(x,y-1) && bmap[x][y-1]=='-'||bmap[x][y-1]=='+'||bmap[x][y-1]=='1'||bmap[x][y-1]=='2'){
            return false;
        }
        if(isin(x,y+1) && bmap[x][y+1]=='-'||bmap[x][y+1]=='+'||bmap[x][y+1]=='3'||bmap[x][y+1]=='4'){
            return false;
        }
    }
    else if(c=='-'){
        if(isin(x-1,y) && bmap[x-1][y]=='|'||bmap[x-1][y]=='+'||bmap[x-1][y]=='1'||bmap[x-1][y]=='4'){
            return false;
        }
        if(isin(x+1,y) && bmap[x+1][y]=='|'||bmap[x+1][y]=='+'||bmap[x+1][y]=='3'||bmap[x+1][y]=='2'){
            return false;
        }
    }
    else if(c=='1'){
        if(isin(x-1,y) && bmap[x-1][y]=='|'||bmap[x-1][y]=='+'||bmap[x-1][y]=='1'||bmap[x-1][y]=='4'){
            return false;
        }
        if(isin(x,y-1) && bmap[x][y-1]=='-'||bmap[x][y-1]=='+'||bmap[x][y-1]=='1'||bmap[x][y-1]=='2'){
            return false;
        }
    }
    else if(c=='2'){
        if(isin(x,y-1) && bmap[x][y-1]=='-'||bmap[x][y-1]=='+'||bmap[x][y-1]=='1'||bmap[x][y-1]=='2'){
            return false;
        }
        if(isin(x+1,y) && bmap[x+1][y]=='|'||bmap[x+1][y]=='+'||bmap[x+1][y]=='3'||bmap[x+1][y]=='2'){
            return false;
        }
    }
    else if(c=='3'){
        if(isin(x+1,y) && bmap[x+1][y]=='|'||bmap[x+1][y]=='+'||bmap[x+1][y]=='3'||bmap[x+1][y]=='2'){
            return false;
        }
        if(isin(x,y+1) && bmap[x][y+1]=='-'||bmap[x][y+1]=='+'||bmap[x][y+1]=='3'||bmap[x][y+1]=='4'){
            return false;
        }
    }
    else if(c=='4'){
        if(isin(x,y+1) && bmap[x][y+1]=='-'||bmap[x][y+1]=='+'||bmap[x][y+1]=='3'||bmap[x][y+1]=='4'){
            return false;
        }
        if(isin(x-1,y) && bmap[x-1][y]=='|'||bmap[x-1][y]=='+'||bmap[x-1][y]=='1'||bmap[x-1][y]=='4'){
            return false;
        }
    }
    return true;
}
bool sdcheck(){
    int num=0;
    for(int i=0;i<2;i++){
        int x = sd[i][0];
        int y = sd[i][1];
        if(isin(x-1,y)){
            if(bmap[x-1][y]=='|'||bmap[x-1][y]=='+'||bmap[x-1][y]=='1'||bmap[x-1][y]=='4'){
                num++;
            }
        }
        if(isin(x+1,y)){
            if(bmap[x+1][y]=='|'||bmap[x+1][y]=='+'||bmap[x+1][y]=='2'||bmap[x+1][y]=='3'){
                num++;
            }
        }
        if(isin(x,y-1)){
            if(bmap[x][y-1]=='-'||bmap[x][y-1]=='+'||bmap[x][y-1]=='1'||bmap[x][y-1]=='2'){
                num++;
            }
        }
        if(isin(x,y+1)){
            if(bmap[x][y+1]=='-'||bmap[x][y+1]=='+'||bmap[x][y+1]=='3'||bmap[x][y+1]=='4'){
                num++;
            }
        }
    }
    return num==2;
}
bool isin(int x,int y){
    return x>0 && y>0 && x<=r && y<=c;
}
/*
3 4
MZ.4
|..|
2--3

10 10
..........
..........
..........
..1--4....
..|..|....
..2--.---M
.....|....
.....|....
.....|....
Z----3....
*/