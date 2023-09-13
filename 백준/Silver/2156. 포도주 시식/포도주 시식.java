import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] arr;
	static int n;
	static void result(int n) {
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(Math.max(arr[i]+dp[i-2], dp[i-1]), arr[i]+arr[i-1]+dp[i-3]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(n>=2)
			dp[2] = arr[1]+arr[2];
		result(n);
		System.out.println(dp[n]);
	}
	
}

