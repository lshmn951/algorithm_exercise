package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static int n;
	static List<Integer> [] gear;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int sum=0;
		gear = new List[4];
		for(int i=0;i<4;i++) {
			gear[i] = new ArrayList<Integer>();
			String str = bf.readLine();
			for(int j=0;j<str.length();j++) {
				gear[i].add(str.charAt(j)-'0');
			}
		}
		n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			revolve(in1-1,in2,new boolean [4]);

		}
		int s=1;
		for(int i=0;i<4;i++,s*=2) {
			if(gear[i].get(0)==1) {
				sum+= s;
			}
		}
		System.out.println(sum);
	}
	public static void revolve(int k,int q,boolean [] visit) {
		visit[k] = true;
		if(q==-1) {
			if(k+1<4 && !visit[k+1] && gear[k].get(2)!=gear[k+1].get(6)) {
				revolve(k+1,1,visit);
			}
			if(k-1>=0 && !visit[k-1] && gear[k].get(6)!=gear[k-1].get(2)) {
				revolve(k-1,1,visit);
			}
			int temp = gear[k].get(0);
			gear[k].remove(0);
			gear[k].add(temp);
		}
		else if(q==1) {
			if(k+1<4 && !visit[k+1] && gear[k].get(2)!=gear[k+1].get(6)) {
				revolve(k+1,-1,visit);
			}
			if(k-1>=0 && !visit[k-1] && gear[k].get(6)!=gear[k-1].get(2)) {
				revolve(k-1,-1,visit);
			}
			int temp = gear[k].get(gear[k].size()-1);
			gear[k].remove(gear[k].size()-1);
			gear[k].add(0, temp);
		}
	}
}
