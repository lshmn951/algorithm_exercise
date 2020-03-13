package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3378_스타일리쉬들여쓰기 {
	static int master[][];
	static int my[][];
	static int p,q;
	static boolean [][][]pos;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String src = "({[)}]";
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			master = new int [p+1][4];
			my = new int [q+1][3];
			int input[] = new int [3];
			pos = new boolean [21][21][21];
			for(int i=0;i<p;i++) {
				String str = br.readLine();
				boolean b = false;
				int cnt = 0;
				for(int j=0;j<str.length();j++) {
					char temp = str.charAt(j);
					if(temp=='.') {
						if(!b) {
							cnt++;
						}
					}
					else {
						int idx = src.indexOf(temp);
						if(idx>-1&&idx<3) {
							input[idx] = input[idx]+1;
						}
						else if(idx>2&&idx<6) {
							input[idx-3] = input[idx-3]-1;
						}
						b=true;
					}
				}
				master[i][3] = cnt;
				for(int k=0;k<3;k++) {
					master[i+1][k] = input[k];
				}
			}
			Arrays.fill(input, 0);
			for(int i=0;i<q;i++) {
				String str = br.readLine();
				for(int j=0;j<str.length();j++) {
					char temp = str.charAt(j);
					int idx = src.indexOf(temp);
					if(idx>-1&&idx<3) {
						input[idx] = input[idx]+1;
					}
					else if(idx>2&&idx<6) {
						input[idx-3] = input[idx-3]-1;
					}
				}
				my[i+1] = input.clone();
			}
			mastercheck();
			System.out.print("#"+tc+" 0 ");
			for(int i=1;i<q;i++) {
				int out = myresult(i);
				System.out.print(out+" ");
			}
			System.out.println();
		}
	}
	public static void mastercheck() {
		for(int c=1;c<p;c++) {
			for(int x=1;x<21;x++) {
				for(int y=1;y<21;y++) {
					for(int z=1;z<21;z++) {
						if(pos[x][y][z]) {
							continue;
						}
						if(x*master[c][0]+y*master[c][1]+z*master[c][2]!=master[c][3]) {
							pos[x][y][z] = true;
						}
					}
				}
			}
		}
	}
	public static int myresult(int idx) {
		int count = 0;
		int res=-1;
		outer:for(int x=1;x<21;x++) {
			for(int y=1;y<21;y++) {
				for(int z=1;z<21;z++) {
					if(!pos[x][y][z]) {
						int temp = x*my[idx][0]+y*my[idx][1]+z*my[idx][2];
						count++;
						if(count==1) {
							res = temp;
						}
						else if(count>1) {
							if(temp!=res) {
								res = -1;
								break outer;
							}
						}
					}
				}
			}
		}
		return res;
	}
}
