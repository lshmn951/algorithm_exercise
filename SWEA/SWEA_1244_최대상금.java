package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_최대상금 {
	static int n;
	static String str;
	static int k;
	static int max;
	static char [] src;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=n;tc++) {
			max = 0;
			st = new StringTokenizer(bf.readLine());
			str = st.nextToken();
			k = Integer.parseInt(st.nextToken());
			src = str.toCharArray();
			int odd=0;
			if(k>src.length) {
				odd = (k-src.length)%2;
				k = src.length;
			}
			dfs(0);
			if(odd==0) {
				System.out.println("#"+tc+" "+max);
			}
			else {
				boolean b = true;
				for(int i=0;i<src.length-1;i++) {
					if(src[i]==src[i+1]) {
						System.out.println("#"+tc+" "+max);
						b = false;
						break;
					}
				}
				if(b) {
					System.out.print("#"+tc+" ");
					swap(src.length-2,src.length-1);
					for(int i=0;i<src.length;i++) {
						System.out.print(src[i]);
					}
					System.out.println();
				}
			}
			
		}
		
	}
	public static void dfs(int r) {
		if(r==k) {
			int result=0;
			int ten = 1;
			for(int i=src.length-1;i>=0;i--,ten*=10) {
				result += (src[i]-'0')*ten;
			}
			max = Math.max(max, result);
		}
		else {
			for(int i=0;i<src.length-1;i++) {
				for(int j=i+1;j<src.length;j++) {

						swap(i,j);
						dfs(r+1);
						swap(j,i);

				}
			}
		}
	}
	public static void swap(int x,int y) {
		char temp = src[y];
		src[y] = src[x];
		src[x] = temp;
	}
}
/*#1 321
#2 7732
#3 857147
#4 87664
#5 88832
#6 777770
#7 966354
#8 954311

#9 332211
#10 987645*/