package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_2056_D1_연월일달력 {
	
	private static int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(src);
		int t = scanner.nextInt();//전체 test case
		//System.out.println(t);
		for(int i=1;i<=t;i++) { 
			//개별 test case 처리.
			sb.append("#").append(i).append(" ");
			String data = scanner.next();
			//System.out.println(data);
			String year = data.substring(0,4);
			String month = data.substring(4,6);
			String day = data.substring(6,8);
			int monthnum = Integer.parseInt(month); 
			if(monthnum<13 && monthnum>0) {
				int daynum = Integer.parseInt(day);
				if(daynum<=days[monthnum] && daynum>0) {
					sb.append(year).append("/").append(month).append("/").append(day);
				}
				else {
					sb.append("-1");
				}
			}
			else {
				sb.append("-1");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static String src = "5\r\n" + 
			"22220228\r\n" + 
			"20150002\r\n" + 
			"01010101\r\n" + 
			"20140230\r\n" + 
			"11111111";
}
