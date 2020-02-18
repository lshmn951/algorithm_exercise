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
 * @since 2020. 2. 18.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV15OZ4qAPICFAYD&solveclubId=AW_ArldKBSADFAVZ&problemBoxTitle=2020-02-18&problemBoxCnt=2&probBoxId=AXBXF6fK8eYDFAVg+
 * @mem
 * @time
 * @caution
 */
public class SWEA_1247_최적경로 {
	static int N;
	static int min ;
	static Point [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(bf.readLine());
			list = new Point[N+2];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<N+2;i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i] = new Point(x,y);
			}
			min = Integer.MAX_VALUE;
			per(0,0,new boolean[N],list[0]);
			System.out.println("#"+tc+" "+min);
		}
		
	}
	public static void per(int k,int sum,boolean [] visit,Point p) {
		if(k==N) {
			sum += dist(p.x,p.y,list[1].x,list[1].y);
			min = Math.min(min, sum);
		}
		else {
			for(int i=2;i<list.length;i++) {
				if(!visit[i-2]) {
					visit[i-2] = true;
					sum += dist(p.x,p.y,list[i].x,list[i].y);
					per(k+1,sum,visit,list[i]);
					sum -=dist(p.x,p.y,list[i].x,list[i].y);
					visit[i-2] = false;
				}
			}
		}
	}
	
	public static int dist(int x1,int y1,int x2,int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}

/*#1 200
#2 304
#3 265
#4 307
#5 306
#6 366
#7 256
#8 399
#9 343
#10 391
*/