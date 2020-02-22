package JA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1459_숫자고르기 {
	static int n;
    static int [] second;
    static int [] result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        second = new int [n+1];
        result = new int [n+1];
        int num=0;
        for(int i=1;i<=n;i++) {
            int r = Integer.parseInt(br.readLine());
            second[i] = r;
        }
        for(int i=1;i<=n;i++) {
        	if(check(i)) {
        		result[i]++;
        	}
        }
        int sum=0;
        for(int i=1;i<=n;i++) {
        	if(result[i]>0) {
        		sum++;
        	}
        }
        System.out.println(sum);
        for(int i=1;i<=n;i++) {
        	if(result[i]>0) {
        		System.out.println(i);
        	}
        }
    }
    public static boolean check(int i) {
    	int des = i;
    	for(int j=1;j<=n;j++) {
    		if(i==second[des]) {
    			return true;
    		}
    		des = second[des];
    	}
    	return false;
    }
}
