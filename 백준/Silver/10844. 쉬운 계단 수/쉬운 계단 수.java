import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	static int n;
	static long result(int length, int start) {
		if(length==1)
			return dp[length][start];
		
		if(dp[length][start]==0) {
			if(start == 0) {
				dp[length][start] = result(length-1,1);
			}
			else if(start==9) {
				dp[length][start] = result(length-1, 8);
			}
			else {
				dp[length][start] = result(length-1, start-1)+result(length-1,start+1);
			}
		}
		return dp[length][start]%1000000000;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
	
		dp = new long[n+1][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		long total = 0;
		for(int i=1;i<=9;i++) {
			total+=result(n,i);
		}
		System.out.println(total%1000000000);
	}
	
}

