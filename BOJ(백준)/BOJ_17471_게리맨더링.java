package algo_exercise.BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 2. 7.
 * @see https://www.acmicpc.net/problem/17471
 * @mem 16296KB
 * @time 132ms
 * @caution 반례가 너무 많다...원형 구역, 
 * 						각각 연결은 되어있지만 2구역 이상인 구역들, 
 * 						다른 구역이 연결을 끊는 경우.
 */

public class BOJ_17471_게리맨더링 {
	static int [][] local;
	static int [] arr;
	static int sum,n,min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int [n+1];
		sum = 0;
		local = new int [n+1][n+1];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for(int i=1;i<=n;i++) {
			int k = sc.nextInt();
			for(int j=1;j<=k;j++) {
				int input = sc.nextInt();
				local[i][input] = 1;
			}
		}
		for(int i=1;i<=n/2;i++) {
			div(i,0,new int [n],new boolean[n+1],0);
		}
		if(min==Integer.MAX_VALUE) {
				System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	
	public static void div(int r,int k,int [] temp,boolean [] vis,int before) {
		if(k==r) {
			int s = 0;
			for(int i=0;i<k;i++) {
				s += temp[i];
			}
			if(min>Math.abs(sum-s-s)) {
				if(check(vis)) {
					min = Math.abs(sum-s-s);
				}
			}
		}
		else {
			for(int i=before;i<n;i++) {
				if(!vis[i+1]) {
					vis[i+1]=true;
					temp[k] = arr[i];
					div(r,k+1,temp,vis,i);
					vis[i+1]=false;
				}
			}
		}
	}
	
	public static boolean check(boolean []vis) {
		ArrayList<Integer> ch1 = new ArrayList<>();
		ArrayList<Integer> ch2 = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();
		boolean b1 = true;
		boolean b2 = true;
		
		for(int i=1;i<=n;i++) {
			if(vis[i]) {
				ch1.add(i);
			}
			else {
				ch2.add(i);
			}
		}
		
		boolean [] visit = new boolean[n+1];
		for(int i=0;i<ch2.size();i++) {
			visit[ch2.get(i)]=true;
		}
		if(ch1.size()==1) {
			b1 = true;
		}
		else {
			que.add(ch1.get(0));
			while(!que.isEmpty()){
				int temp = que.poll();
				if(visit[temp]) {
					continue;
				}
				visit[temp] = true;
				for(int i=1;i<=n;i++) {
					if(local[temp][i]==1 && !visit[i]) {
						que.add(i);
					}
				}
			}
			for(int i=0;i<ch1.size();i++) {
				if(!visit[ch1.get(i)]) {
					b1 = false;
					break;
				}
			}
		}
		
		
		visit = new boolean[n+1];
		for(int i=0;i<ch1.size();i++) {
			visit[ch1.get(i)]=true;
		}
		if(ch2.size()==1) {
			b2 = true;
		}
		else {
			que.add(ch2.get(0));
			while(!que.isEmpty()){
				int temp = que.poll();
				if(visit[temp]) {
					continue;
				}
				visit[temp] = true;
				for(int i=1;i<=n;i++) {
					if(local[temp][i]==1 && !visit[i]) {
						que.add(i);
					}
				}
			}
			for(int i=0;i<ch2.size();i++) {
				if(!visit[ch2.get(i)]) {
					b2 = false;
					break;
				}
			}
		}
		
		return b1 && b2;
	}
}