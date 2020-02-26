package JA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1219_모자이크 {
	static int r,c;
	static int pnum;
	static boolean [] vis ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		vis = new boolean [c];
		int max=0;
		pnum = Integer.parseInt(br.readLine());
		int i = Integer.parseInt(br.readLine());
		for(int j=0;j<i;j++) {
			st = new StringTokenizer(br.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			if(in1>max) {
				max = in1;
			}
			vis[in2-1]=true;
		}
		int j;
		for(j=max;j<=r;j++) {
			if(check(j)) {
				break;
			}
		}
		System.out.println(j);
	}
	public static boolean check(int size) {
		int num = pnum;
		for(int i=0;i<c;i++) {
			if(vis[i]&&num>0) {
				num--;
				i+= (size-1);
			}
			else if(vis[i] && num==0) {
				return false;
			}
		}
		return true;
	}
}
