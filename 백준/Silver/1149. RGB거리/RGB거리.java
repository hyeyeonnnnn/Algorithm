import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		int min = Math.min(result(N-1,0), result(N-1,1));
		min = Math.min(min, result(N-1,2));
		
		System.out.println(min);
		
	}
	
	public static int result(int N, int index) {
		if(dp[N][index]==0) {
			if(index==0)
				dp[N][index] = Math.min(result(N-1,1), result(N-1,2)) + arr[N][0];
			else if(index==1)
				dp[N][index] = Math.min(result(N-1,0), result(N-1,2)) + arr[N][1];
			else
				dp[N][index] = Math.min(result(N-1,0), result(N-1,1)) + arr[N][2];
		
		}
		return dp[N][index];
		
	}

}
