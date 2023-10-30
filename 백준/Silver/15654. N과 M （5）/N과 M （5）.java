import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	static private void dfs(int depth, int[] arr) {
		if(depth==M) {
			for(int val : result)
				sb.append(val+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				dfs(depth+1, arr);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		result = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);		
		dfs(0, arr);
		System.out.println(sb);
	}
}