import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int C;
	static int[][] arr;
	static boolean[] visited; //행 중복 x
	static boolean[] visited2; //열 중복 x
	static int max;
	static int[] result;
	static void dfs(int depth) {
		if(depth == 11) {
			int total = 0;
			for(int val : result) {
				total += val;
			}
			max = Math.max(max, total);
			return;
		}
		
		for(int i=0;i<11;i++) {		
			if(arr[depth][i] != 0 && !visited[depth] && !visited2[i]) {
				visited[depth] = true;
				visited2[i] = true;
				result[depth] = arr[depth][i];
				dfs(depth+1);
				visited[depth] = false;
				visited2[i] = false;
			}			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		C = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		arr = new int[11][11];
		result = new int[11];
		visited = new boolean[11];
		visited2 = new boolean[11];
		
		for(int j=0;j<C;j++) {
			for(int i=0;i<11;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<11;k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			max = Integer.MIN_VALUE;
			dfs(0);
			sb.append(max+"\n");
		}
		
		System.out.println(sb);
	}
}