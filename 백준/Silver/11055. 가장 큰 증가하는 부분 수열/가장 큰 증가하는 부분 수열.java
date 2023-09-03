import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] arr;

	static void result(int n) {		
		for(int i=2;i<=n;i++) {
			int max = 0;
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[i]) {
					if(dp[j]>max)
						max = dp[j];
				}	
				dp[i] = max+arr[i];
			}
		
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		result(n);		
		Arrays.sort(dp);
		
		System.out.println(dp[n]);
	}
}

