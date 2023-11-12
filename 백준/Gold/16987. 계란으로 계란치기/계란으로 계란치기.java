import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] d;
	static int[] weight;
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int depth, int cnt) {
		if(depth==N) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(d[depth]<=0 || cnt==N-1) {
			dfs(depth+1, cnt);
			return;
		}
		
		int real_cnt = cnt;
		for(int i=0;i<N;i++) {
			if(i==depth) continue;
			if(d[i]<=0) continue;
			
			d[i] -= weight[depth];
			d[depth] -= weight[i];
			
			if(d[i]<=0) cnt++;
			if(d[depth]<=0) cnt++;
			
			dfs(depth+1, cnt);
			
			d[i] += weight[depth];
			d[depth] += weight[i];
			cnt = real_cnt;
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		d = new int[N];
		weight = new int[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		System.out.println(max);
	}
}