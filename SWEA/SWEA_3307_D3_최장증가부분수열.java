package algo_exercise.SWEA;

import java.util.Scanner;

public class SWEA_3307_D3_최장증가부분수열 {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
         
        int tc = scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=tc;i++) {
            int l = scanner.nextInt();
            scanner.nextLine();
            int [] number = new int[l];
             
             
            for(int j=0;j<l;j++) {
                String tmp = scanner.next();
                number[j] = tmp.charAt(0)-'0';
            }
            int [] len = new int[l];
            len[0] = 1;
            for(int j=1;j<l;j++) {
                for(int k=j-1;k>=0;k--) {
                    if(number[k]<number[j]) {
                        if(len[k]>=len[j]) {
                            len[j] = len[k]+1;
                        }
                    }
                }
                if(len[j]==0) {
                    len[j]=1;
                }
            }
             
            int max = len[0];
            for(int j=1;j<l;j++) {
                if(max<len[j]) {
                    max = len[j];
                }
            }
            System.out.println("#"+i+" "+max);
        }
    }   
}
