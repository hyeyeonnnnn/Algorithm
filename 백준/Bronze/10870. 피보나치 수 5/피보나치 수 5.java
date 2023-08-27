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
	static Integer[] dp;
	
	static int fibonacci(int n) {
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		
		if(dp[n]==null)
			dp[n] = fibonacci(n-1)+fibonacci(n-2);
		
		return dp[n];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Integer[n+2];
	
		System.out.println(fibonacci(n+1));
		
	}

}