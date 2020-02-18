package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/1759
 * @mem
 * @time
 * @caution 자음2개와 모음 1개를 포함하는 조합 출력
 */
public class BOJ_1759_암호만들기 {
	static int L,C;
	static char [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char [C];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		com(0,0,new char[L]);
	}
	public static void com(int k,int before,char [] temp) {
		if(k==L) {
			boolean b=false;
			int cnt = 0;
			for(int i=0;i<L;i++) {
				if(temp[i]=='a'||temp[i]=='e'||temp[i]=='i'||temp[i]=='o'||temp[i]=='u') {
					b= true;
				}
				else {
					cnt++;
				}
			}
			if(b && cnt>=2) {
				for(int i=0;i<L;i++) {
					System.out.print(temp[i]);
				}
				System.out.println();
			}
		}
		else {
			for(int i=before;i<C;i++) {
				temp[k] = arr[i];
				com(k+1,i+1,temp);
			}
		}
	}
}
