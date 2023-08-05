import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static boolean flag = false;
    static int cnt =0;
    static int dp[] = new int[12];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
       
        recur(0,0);
        if(!flag) {
            System.out.println(-1);
        }
    }
    public static void recur(int num, int level) {
        if(num>n) {
            return ;
        }
        if(num ==n) {
            cnt++;
            if(cnt == k) {
                flag = true;
                for(int i=0; i<level-1;i++) {
                    System.out.print(dp[i]+"+");
                }
                System.out.println(dp[level-1]);
            }
            return ;
        }
        for(int i=1; i<=3; i++) {
            dp[level]=i;
            recur(num+i,level+1);
        }
        return ;
    }
}
