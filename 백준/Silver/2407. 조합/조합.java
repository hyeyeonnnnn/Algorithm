import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BigInteger[][] dp;
	
	static BigInteger comb(int n, int m) {
		if(n==1 || m==n || m==0) {
			BigInteger num = new BigInteger("1");
			return num;
		};
		if(dp[n][m]==null) {
			BigInteger num1 = new BigInteger(String.valueOf(comb(n-1,m)));
			BigInteger num2 = new BigInteger(String.valueOf(comb(n-1,m-1)));
			dp[n][m] = num1.add(num2);
		}
		return dp[n][m];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new BigInteger[n+1][m+1];
		
		System.out.println(comb(n, m));
	}
}

