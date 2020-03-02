package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())+100;
			int y1 = Integer.parseInt(st.nextToken())+100;
			int x2 = Integer.parseInt(st.nextToken())+100;
			int y2 = Integer.parseInt(st.nextToken())+100;
			int num;
			int r = Math.abs(x1-x2);
			int c = Math.abs(y1-y2);
			if(r==c) {
				num = r+c;
			}
			else {
				num = Math.min(r, c) * 2;
				int d = Math.abs(r-c);
				if(d%2==0) {
					num += d*2;
				}
				else {
					num += d*2-1;
				}
			}
			System.out.println("#"+tc+" "+num);
		}
	}

}
