package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/8958
 * @mem
 * @time
 * @caution 
 */

public class BOJ_8958_ox퀴즈 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int tc = 0;tc<T;tc++) {
			String str = bf.readLine();
			int cur = 1;
			int sum = 0 ;
			for(int i=0;i<str.length();i++) {
				char temp = str.charAt(i);
				if(temp=='O') {
					sum+=cur;
					cur++;
				}
				else if(temp=='X') {
					cur=1;
				}
			}
			System.out.println(sum);
		}
	}

}
