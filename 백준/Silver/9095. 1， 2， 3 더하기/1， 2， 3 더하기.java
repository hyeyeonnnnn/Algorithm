import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int dp[] = new int[11];
    	 dp[0] = 0;
         dp[1] = 1;
         dp[2] = 2;
         dp[3] = 4;
         for(int j=4;j<=10;j++)
        	 dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
         
         int x = Integer.parseInt(br.readLine());
         for(int i=0;i<x;i++) {
        	 int n = Integer.parseInt(br.readLine());
             System.out.println(dp[n]);
         }
    }
}

