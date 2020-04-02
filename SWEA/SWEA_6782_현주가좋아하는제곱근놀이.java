package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6782_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			long N = Long.parseLong(br.readLine());
			int count = 0;
			
			while(N>2) {
				long temp = (long)Math.sqrt(N);
				if(temp*temp == N) {
					N = temp;
					count++;
				}
				else {
					long sqrt = (long)Math.pow(temp+1, 2);
					count += sqrt -N;
					N = sqrt;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}

}
