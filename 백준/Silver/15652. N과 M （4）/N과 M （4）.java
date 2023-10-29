import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static private void dfs(int depth, int start) {
		if(depth==M) {
			for(int val : arr)
				sb.append(val+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			arr[depth] = i + 1;
			dfs(depth+1, i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		dfs(0, 0);
		System.out.println(sb);
	}
}