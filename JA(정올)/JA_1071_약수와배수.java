package algo_exercise.JA;

import java.util.Scanner;

/**
 * 
 * @author 이성현
 * @since 2020. 1. 29.
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=351&sca=2030
 * @mem
 * @time
 * @caution
 */


public class JA_1071_약수와배수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int M = sc.nextInt();
		
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<N;i++) {
			if(M%arr[i]==0) {
				sum1+=arr[i];
			}
			if(arr[i]%M==0) {
				sum2+=arr[i];
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}

}
