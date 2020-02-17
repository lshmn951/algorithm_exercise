package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리복구하기 {
	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int tc = scanner.nextInt();
		for(int i=1;i<=tc;i++) {
			sb.append("#").append(i).append(" ");
			String bit = scanner.next();
			char temp = '0';
			int count = 0;
			for(int j=0;j<bit.length();j++) {
				if(bit.charAt(j)!=temp) {
					count++;
					temp = bit.charAt(j);
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	private static String src = "10\r\n" + 
			"01010101010101010101010101010101010101010101010101\r\n" + 
			"01\r\n" + 
			"1000110010011111010110000100100000000001001\r\n" + 
			"10011010001110111010111010001100101101\r\n" + 
			"00110101100001010000110010111\r\n" + 
			"101111110101010100111100101111001\r\n" + 
			"01110011110001110\r\n" + 
			"1010101001010101010101010100111111\r\n" + 
			"01010100010100101100111010100010111111011001011000\r\n" + 
			"1111100101101110000";
}
