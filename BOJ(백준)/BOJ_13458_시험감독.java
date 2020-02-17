package algo_exercise.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1,st2;
		int n = Integer.parseInt(bf.readLine());
		st1 = new StringTokenizer(bf.readLine());
		st2 = new StringTokenizer(bf.readLine());
		long sum=0;
		int b = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int a;
		for(int i=0;i<n;i++) {
			
			a = Integer.parseInt(st1.nextToken());
			if(a-b<0) {
				sum++;
			}
			else {
				sum+= ((a-b)+(c-1))/c +1;
			}
		}
		System.out.println(sum);
	}

}
