package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 
 * @author 이성현
 * @since 2020. 2. 17.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15FZuqAL4CFAYD&categoryId=AV15FZuqAL4CFAYD&categoryType=CODE
 * @mem
 * @time
 * @caution 암호코드 숫자는 1로 끝나므로 뒤에서부터 검색할때 1이면 그 앞에 56자리를 보고 검사한다.
 */
public class SWEA_1240_단순2진암호코드 {
	static int T,N,M;
	static String [] str;
	static int [] arr = new int [8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(bf.readLine());
		next:for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			str = new String[N];
			int sum=0;
			for(int i=0;i<N;i++) {
				str[i] = bf.readLine();
			}
			for(int i=0;i<N;i++) {
				for(int j=M-1;j>=0;j--) {
					if(str[i].charAt(j)=='1') {
						sum=0;
						arr = new int [8];
						for(int q=j,w=7;w>=0;q-=7,w--) {
							arr[w] = change(str[i].substring(q-6,q+1));
							sum+=arr[w];
						}
						if(calc()%10==0) {
							System.out.println("#"+tc+" "+sum);
							continue next;
						}
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+0);
		}
		
	}
	public static int calc() {
		return ((arr[0]+arr[2]+arr[4]+arr[6])*3) +(arr[1]+arr[3]+arr[5])+arr[7];
	}
	public static int change(String src) {
		int cur = 0;
		int [] cnt = new int [5];
		int idx = 0;
		for(int i=0;i<src.length();i++) {
			if(cur!=src.charAt(i)-'0') {
				cur = src.charAt(i)-'0';
				idx++;
				cnt[idx]++;
			}
			else {
				cnt[idx]++;
			}
		}
		
		if(cnt[0]==3 && cnt[1]==2 && cnt[2]==1 && cnt[3]==1) {
			return 0;
		}
		else if(cnt[0]==2 && cnt[1]==2 && cnt[2]==2 && cnt[3]==1) {
			return 1;
		}
		else if(cnt[0]==2 && cnt[1]==1 && cnt[2]==2 && cnt[3]==2) {
			return 2;
		}
		else if(cnt[0]==1 && cnt[1]==4 && cnt[2]==1 && cnt[3]==1) {
			return 3;
		}
		else if(cnt[0]==1 && cnt[1]==1 && cnt[2]==3 && cnt[3]==2) {
			return 4;
		}
		else if(cnt[0]==1 && cnt[1]==2 && cnt[2]==3 && cnt[3]==1) {	
			return 5;
		}
		else if(cnt[0]==1 && cnt[1]==1 && cnt[2]==1 && cnt[3]==4) {	
			return 6;
		}
		else if(cnt[0]==1 && cnt[1]==3 && cnt[2]==1 && cnt[3]==2) {
			return 7;
		}
		else if(cnt[0]==1 && cnt[1]==2 && cnt[2]==1 && cnt[3]==3) {
			return 8;
		}
		else  {
			return 9;
		}
	}
}
