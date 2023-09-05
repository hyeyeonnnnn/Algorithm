import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static long[][] dp;
	static int n;
	static void result() {
		for(int i=1;i<=n;i++) 
			for(int j=1;j<=n;j++){
				if(i==n&&j==n)
					continue;
				int go = arr[i][j];
				if(i+go<=n) {
					dp[i+go][j] += dp[i][j];
				}
				if(j+go<=n) {
					dp[i][j+go] += dp[i][j];
				}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		dp = new long[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		dp[1][1] = 1;
		
		result();
		
		System.out.println(dp[n][n]);
	}
	
}

