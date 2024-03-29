import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		dp = new int[k+1];
		dp[0] = 1;
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=k; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
	}
	

		

	}