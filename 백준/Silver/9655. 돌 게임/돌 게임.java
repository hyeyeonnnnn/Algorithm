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
			return 2;
		else if(n==3)
			return 1;
		
		if(dp[n]==0) {
			dp[n] = result(n-3)+result(n-1);		
		}
		return dp[n];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		if(n%2==0)
			System.out.println("CY");
		else
			System.out.println("SK");

	}
}

