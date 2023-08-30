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
		if(n==1)
			return 1;
		else if(n==2)
			return 3;
		if(dp[n]==0)
			dp[n] = (result(n-1) + result(n-2)*2)%10007;
		return dp[n];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		System.out.println(result(n));
	}
}

