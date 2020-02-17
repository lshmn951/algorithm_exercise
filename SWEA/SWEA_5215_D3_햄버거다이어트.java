package algo_exercise.SWEA;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_5215_D3_햄버거다이어트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<pair> que  = new LinkedList<pair>();
		StringBuilder sb= new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int tc = scanner.nextInt();
		for(int i=1;i<=tc;i++) {
			int max= 0;
			sb.append("#").append(i).append(" ");
			int N = scanner.nextInt();
			int L = scanner.nextInt();
			int []score = new int[N]; 
			int []cal = new int[N];
			for(int j=0;j<N;j++) {
				score[j] = scanner.nextInt();
				cal[j] = scanner.nextInt();
				
			}
			que.add(new pair(0,0,0));
			while(!que.isEmpty()) {
				pair e = que.poll();
				//System.out.printf("%d %d %d\n",e.x,e.y,e.z);
				
				if(max<=e.x) {
					max = e.x;
				}
				if(e.z < N) {
					if(e.y + cal[e.z] <= L) {
						que.add(new pair((e.x+score[e.z]),(e.y+cal[e.z]),e.z+1));
					}
					que.add(new pair(e.x,e.y,e.z+1));
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	private static String src = "1\r\n" + 
			"5 1000\r\n" + 
			"100 200\r\n" + 
			"300 500\r\n" + 
			"250 300\r\n" + 
			"500 1000\r\n" + 
			"400 400";
	
	public static class pair{
		int x,y,z;
		public pair(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
}
