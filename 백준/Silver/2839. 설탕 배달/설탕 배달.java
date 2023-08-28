import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int[] dp;
	
	static int result(int n) {
		if(n==0)
			return 0;
		if(n==1||n==2)
			return 1;
		if(dp[n]==0) {
			if(n%5==0)
				dp[n] = 1+result(n-5);
			else if(n%3==0)
				dp[n] = 1+result(n-3);
			else
				dp[n] = 1+Math.min(result(n-3), result(n-5));
			
		}
		return dp[n];

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		if(n==4 || n==7)
			System.out.println(-1);
		else
			System.out.println(result(n));

	}
}

