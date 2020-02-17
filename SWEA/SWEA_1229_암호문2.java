package algo_exercise.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 10.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AW_ArldKBSADFAVZ&contestProbId=AV14yIsqAHYCFAYD&probBoxId=AXAs3maKWg4DFAXq&type=PROBLEM&problemBoxTitle=2020-02-10&problemBoxCnt=1
 * @mem
 * @time
 * @caution
 */
public class SWEA_1229_암호문2 {
	static int n;
	static int m;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10;i++) {
			sb.append("#").append(i).append(" ");
			n = Integer.parseInt(bf.readLine());
			List<Integer> arr = new ArrayList<Integer>();
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			m = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				String temp = st.nextToken();
				if(temp.charAt(0)=='I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int k=0;k<y;k++) {
						int tem = Integer.parseInt(st.nextToken());
						arr.add(x+k,tem);
					}
				}
				else if(temp.charAt(0)=='D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int k=0;k<y;k++) {
						arr.remove(x);
					}
				}
			}
			for(int j=0;j<10;j++) {
				sb.append(arr.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
