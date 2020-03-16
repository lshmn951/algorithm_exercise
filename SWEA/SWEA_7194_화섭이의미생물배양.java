package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7194_화섭이의미생물배양 {
	static int s,t,a,b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int res = 0;
			if(s==t) {
				res = 0;
			}
			else {
				if(b==1) {
					if((t-s)%a==0) {
						res = (t-s)/a;
					}
					else {
						res = -1;
					}
				}
				else {
					while(s!=t) {
						if(t<s) {
							res = -1;
							break;
						}
						else {
							if(t%b==0) {
								if(t/b<s) {
									t -=a;
								}
								else {
									t /=b;
								}
								res++;
							}
							else {
								t -=a;
								res++;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}
