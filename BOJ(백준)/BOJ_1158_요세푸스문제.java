package algo_exercise.BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> arr = new LinkedList<>();
		
		
		for(int i=0;i<N;i++) {
			arr.add(i+1);
		}
		
		sb.append("<");
		int i=K-1;
		int cur = 0;
		int cnt = N;
		while(cnt>0) {
			if(cur==0) {
				if(arr.size()==1) {
					sb.append(arr.get(i)+">");
					break;
				}
				else {
					sb.append(arr.get(i)+", ");
					arr.remove(i);
					cnt--;
					i--;
				}
			}
			i = (i+1)%arr.size();
			cur = (cur+1)%K;
			
		}
		System.out.println(sb);
	}

}
