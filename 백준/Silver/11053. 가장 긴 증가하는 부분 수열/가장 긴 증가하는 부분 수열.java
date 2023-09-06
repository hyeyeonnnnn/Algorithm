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
			if(arr[i]==arr[i-1]) {
				dp[i] = dp[i-1];
			}
			else {
				int max2 = 0;
				for(int j=1;j<i;j++) {
					if(arr[j]<arr[i] &&dp[j]>max2)
						max2 = dp[j];
				}
				dp[i] = max2+1;
			}
				
				
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		arr = new int[a+1];
		dp = new int[a+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=a;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		result(a);
		
		Arrays.sort(dp);
		
		System.out.println(dp[a]);
	}
}

