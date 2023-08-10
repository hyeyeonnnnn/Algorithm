import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			
			fibonacci(n);
			sb.append(dp[n][0]+" "+dp[n][1]+"\n");
		}
		System.out.println(sb);
		
	}
	
	private static Integer[] fibonacci(int n) {
		if(dp[n][0]==null || dp[n][1]==null) {
			dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
		return dp[n];
	}
	}