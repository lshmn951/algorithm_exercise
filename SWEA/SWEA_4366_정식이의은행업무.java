package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4366_정식이의은행업무 {
	static char [] ch1 = {'0','1'};
	static char [] ch2 = {'0','1','2'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String binary = br.readLine();
			String tenary = br.readLine();
			long result = 0;
			out:for(int i=0;i<binary.length();i++) {
				char t1 = binary.charAt(i);
				for(int q=0;q<2;q++) {
					if(ch1[q]!=t1) {
						binary = binary.substring(0, i) + ch1[q] +binary.substring(i+1,binary.length());
						for(int j=0;j<tenary.length();j++) {
							char temp = tenary.charAt(j);
							for(int c=0;c<3;c++) {
								if(temp!=ch2[c]) {
									tenary = tenary.substring(0,j)+ch2[c]+tenary.substring(j+1,tenary.length());
									long l1 = Long.parseLong(binary, 2);
									long l2 = Long.parseLong(tenary, 3);
									if(l1==l2) {
										result = l1;
										break out;
									}
								}
							}
							tenary = tenary.substring(0,j)+temp+tenary.substring(j+1,tenary.length());
						}
						binary = binary.substring(0, i) + t1 +binary.substring(i+1,binary.length());
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}

}
