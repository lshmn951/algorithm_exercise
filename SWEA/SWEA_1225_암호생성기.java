package algo_exercise.SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			sc.next();
			Queue<Integer> que = new LinkedList<Integer>();
			for(int j=0;j<8;j++) {
				que.add(sc.nextInt());
			}
			int minus = 1;
			while(true) {
				int temp = que.poll();
				temp -= minus;
				minus++;
				if(minus==6) {
					minus=1;
				}
				if(temp<=0) {
					que.add(0);
					break;
				}
				que.add(temp);
			}
			System.out.print("#"+i+" ");
			while(!que.isEmpty()) {
				System.out.print(que.poll()+" ");
			}
			System.out.println();
		}
	}

}
